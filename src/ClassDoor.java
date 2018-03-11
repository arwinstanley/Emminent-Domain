	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is used to represent Class cards and it extends DoorCard
	 * 
	 */
public class ClassDoor extends DoorCard {
	//is the primary ability of the Class
	private String primary;
	//is the secondary ability
	private String secondary;
	//sets the type to Class for all of these cards
	private static final String TYP = "class";
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param prime is the desc of the primary power
	 * @param seco is the description of the secondary power
	 * 
	 * fairly standard constructor, calls its super
	 * 
	 */
	public ClassDoor(String id, String desc, String prime, String seco) {
		super(id, desc, TYP);
		primary = prime;
		secondary = seco;
	}
	/**
	 * @param none
	 * @return primary is the desc of the primary trait
	 * 
	 * fairly standard getter
	 * 
	 */
	public String getPrimary() {
		return primary;
	}
	/**
	 * @param none
	 * @return secondary is the desc of the secondary trait
	 * 
	 * fairly standard getter
	 * 
	 */
	public String getSecondary() {
		return secondary;
	}
	/**
	 * @param target the target of the ability
	 * @param board the current game board
	 * @return none
	 * 
	 * runs the primary ability
	 * 
	 */
	public void runPrime(Entity target, Board board) {
		
	}
	/**
	 * @param target the target of the ability
	 * @param board the current game board
	 * @return none
	 * 
	 * runs the secondary ability
	 * 
	 */
	public void runSecond(Entity target, Board board) {
		
	}
}
