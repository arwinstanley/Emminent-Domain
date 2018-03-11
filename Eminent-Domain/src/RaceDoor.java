	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is used to represent Race cards and it extends DoorCard
	 * 
	 */
public class RaceDoor extends DoorCard {
	// A string desc of the passive trait
	private String passive;
	// sets the type to race for all of these cards
	private static final String TYP = "race";
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param pass is the desc of the passive trait
	 * 
	 * fairly standard constructor, calls its super
	 * 
	 */
	public RaceDoor(String id, String desc, String pass) {
		super(id, desc, TYP);
		passive = pass;
	}
	/**
	* @param none
	* @return passive
	* 
	* fairly standard getter
	* 
	*/
	public String getPassive() {
		return passive;
	}
	/**
	* @param board is the game board
	* @return none
	* 
	* checks the board state against the passive ability
	* 
	*/
	public void checkPassive(Board board) {
	
	}
}
