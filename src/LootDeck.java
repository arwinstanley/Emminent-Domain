import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LootDeck implements Deck {
	private ArrayList<LootCard> deck;
	private Stack<LootCard> discarded;
	private Stack<LootCard> toDis;
	public LootDeck(ArrayList<LootCard> toAdd) {
		deck = toAdd;
		discarded = new Stack<LootCard>();
		toDis = new Stack<LootCard>();
		shuffle();
	}
	public ArrayList<LootCard> getDeck() {
		return deck;
	}
	public void setDeck(ArrayList<LootCard> deck) {
		this.deck = deck;
	}
	public Stack<LootCard> getDiscarded() {
		return discarded;
	}
	public void setDiscarded(Stack<LootCard> discarded) {
		this.discarded = discarded;
	}
	public Stack<LootCard> getToDis() {
		return toDis;
	}
	public void setToDis(Stack<LootCard> toDis) {
		this.toDis = toDis;
	}
	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		LootCard temp = new LootCard("", "", 0, "");
		for(int j = 0; j<10;j++) {
			for(int i = 0; i<deck.size(); i++) {
				int r = (int) Math.random()*deck.size();
				temp = deck.get(r);
				deck.set(r, deck.get(i));
				deck.set(i, temp);
			}
		}
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
    public void discard(LootCard card) {
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
	public void lootTheRoom(int amount, Player player) {
		if(deck.size()<amount)
			reIntroduce();
		for(int i = 0; i < amount; i++) {
			player.addToHand(deck.remove((int)Math.random()*deck.size()));
		}
	}
}
