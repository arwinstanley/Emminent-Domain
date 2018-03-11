import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class DoorDeck implements Deck {
	private ArrayList<DoorCard> deck;
	private Stack<DoorCard> discarded;
	private Stack<DoorCard> toDis;
	public DoorDeck(ArrayList<DoorCard> toAdd) {
		deck = toAdd;
		discarded = new Stack<DoorCard>();
		toDis = new Stack<DoorCard>();
		shuffle();
	}
	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		DoorCard temp = new DoorCard("", "", "");
		for(int j = 0; j<10;j++) {
			for(int i = 0; i<deck.size(); i++) {
				int r = (int) Math.random()*deck.size();
				temp = deck.get(r);
				deck.set(r, deck.get(i));
				deck.set(i, temp);
			}
		}
	}
	public ArrayList<DoorCard> getDeck() {
		return deck;
	}
	public void setDeck(ArrayList<DoorCard> deck) {
		this.deck = deck;
	}
	public Stack<DoorCard> getDiscarded() {
		return discarded;
	}
	public void setDiscarded(Stack<DoorCard> discarded) {
		this.discarded = discarded;
	}
	public Stack<DoorCard> getToDis() {
		return toDis;
	}
	public void setToDis(Stack<DoorCard> toDis) {
		this.toDis = toDis;
	}
	@Override
	public void deal(Player player) {
		if(deck.size()<4)
			reIntroduce();
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i++) {
			player.addToHand(deck.remove((int)Math.random()*deck.size()));
		}
	}
    public void discard(DoorCard card) {
    	toDis.add(card);
    	discard();
    }
	@Override
	public void discard() {
		// TODO Auto-generated method stub
		discarded.add(toDis.pop());
	}

	@Override
	public void reIntroduce() {
		// TODO Auto-generated method stub
		while(!discarded.isEmpty()) {
			deck.add(discarded.pop());
		}
		shuffle();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return deck.size();
	}

	@Override
	public int discardSize() {
		// TODO Auto-generated method stub
		return discarded.size();
	}
	public void kickDownTheDoor(Player player, Board board) {
		String tempHold= "fight";
		if(deck.size()<= 1)
			reIntroduce();
		if(deck.get(deck.size()-1).getType().equals("monster")) {
			Monster enemy = new Monster((MonsterDoor)deck.get(deck.size()-1));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Youve encountered " + enemy);
			System.out.println("Would you like to fight or run");
			boolean valid = false;
			while(!valid) {
				try {
					tempHold = br.readLine();
				} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(tempHold.equals("fight")) {
					valid = true;
					enemy.fight(player, board);
				}
				else if(tempHold.equals("run")) {
					valid = true;
					if(!player.run()) {
						System.out.println("You cant get away");
						enemy.fight(player, board);
					}
					else{
						System.out.println("You got away");
					}
				}
				else {
					System.out.println("please enter fight or run");
				}
			}
			discard(deck.remove(deck.size()-1));
			board.setFight(true);
		}
		else if(deck.get(deck.size()-1).getType().equals("curse")) {
			CurseDoor temp =(CurseDoor) deck.get(deck.size()-1);
			temp.spoopy(player, board);
			discard(deck.remove(deck.size()-1));
		}
		else
			player.addToHand(deck.remove(deck.size()-1));
		return ;
	}
	
}
