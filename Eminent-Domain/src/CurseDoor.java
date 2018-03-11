import java.util.Stack;

public class CurseDoor extends DoorCard {
public CurseDoor(String id, String desc) {
	super(id, desc,"curse");
}
public void spoopy(Player target, Board board) {
	switch(this.getId()) {
	case "curse! lose a small item": 
		target.discRandBigSmall(false, board);
		target.update();
		break;
	case "curse! lose a level" :
		target.setLvl(target.getLvl()-1);
		target.update();
		break;
	case "curse! lose two cards":
		target.discRandom(board);
		target.discRandom(board);
		break;
	case "curse! change sex" :
		boolean change = (target.getGender())? false: true;
		target.setGender(change);
		break;
	case "curse! change race" :
		Stack<DoorCard> temp = new Stack<DoorCard>();
		DoorCard hold = new DoorCard("", "", "");
		while(!(board.getDoorDeck().getDiscarded()==null)&&!(board.getDoorDeck().getDiscarded().isEmpty())) {
			if(board.getDoorDeck().getDiscarded().peek().getType().equals("race")) {
				hold = board.getDoorDeck().getDiscarded().pop();
				while(!temp.isEmpty()) {
					board.getDoorDeck().discard(temp.pop());
				}
				board.getDoorDeck().discard(target.getRaceCard());
				target.setPlayerRace((RaceDoor)hold);
				return;
			}
			else {
				temp.add(board.getDoorDeck().getDiscarded().peek());
			}	
		}
		break;
}
}
}
