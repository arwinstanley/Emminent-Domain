	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is the first extension in the door section of the hierarchy and it extends Card
	 * 
	 */
public class DoorCard extends Card {
	//Once again this String is crucial for checking the type of a Door Card
	private String type;
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param typ is the type of Door Card
	 * @return none
	 * 
	 * fairly standard constructor, calls its super
	 * 
	 */
	public DoorCard(String id, String desc, String typ) {
		super(id, desc);
		type = typ;
	}
	/**
	* @param none
	* @return type
	* 
	* fairly standard getter
	* 
	*/
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		return "(" +this.getId()+ ", "+ this.getType()+ ")";
	}
}
