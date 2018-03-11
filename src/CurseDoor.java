import java.util.Stack;
/**
 * @author arwinstanley
 * @Date 3/11/18
 * 
 * This Class is used to represent curse cards and it extends DoorCard
 * 
 */
public class CurseDoor extends DoorCard {
	//sets all of these cards type to curse
	private static final String TYP = "curse";
	/**
	 * @param id is the id
	 * @param desc is the description
	 * 
	 * fairly standard constructor, calls its super
	 * 
	 */
	public CurseDoor(String id, String desc) {
		super(id, desc,TYP);
	}
	/**
	 * @param target is the player being cursed
	 * @param board is the current game board
	 * @return none
	 * 
	 * runs the curse functions on target player
	 * 
	 */
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
