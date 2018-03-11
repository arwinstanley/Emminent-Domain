	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is the first class in the loot branch and extends card
	 */
public class LootCard extends Card {
	// the amount of gold the card is worth
	private int gp;
	//again this is incredibly useful for determing the type of loot
	private String type;
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param goldVal is the amount of Gold its worth
	 * @param ty is the type
	 * 
	 * fairly standard constructor calls its super
	 * 
	 */
	public LootCard(String id, String desc, int goldVal, String ty){
		super(id, desc);
		gp = goldVal;
		type = ty;
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
	/**
	 * @param none
	 * @return gp
	 * 
	 * fairly standard getter
	 * 
	 */
	public int getGP() {
		return gp;
	}
}
