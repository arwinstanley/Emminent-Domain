	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is a representation of the arms cards and extend Loot
	 */
public class ArmsLoot extends LootCard {
	//the bonus attack you get
	private int bonus;
	// hand, head, footwear, etc...
	private String slot;
	//if it isnt big its small
	private boolean big;
	// if it doesent give bonuses it gives an ability
	private String ability;
	// sets all of the types for this card to be arms
	private static final String TYP = "arms";
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param gp is the amount of Gold its worth
	 * @param bonus is the attack bonus
	 * @param slot is where it goes on the character
	 * @param thiq is big or small
	 * 
	 * this constructor is used when the item has a bonus not an ability
	 * 
	 */
	public ArmsLoot(String id, String desc, int gp, int bonus, String slot, boolean thiq) {
		super(id, desc, gp, TYP);
		this.bonus = bonus;
		this.slot = slot;
		big = thiq;
		ability = "none";
	}
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param gp is the amount of Gold its worth
	 * @param slot is where it goes on the character
	 * @param thiq is big or small
	 * @param specialMove is the special ability
	 * 
	 * this constructor is used when the item has an ability and no bonus
	 * 
	 */
	public ArmsLoot(String id, String desc, int gp, String slot, boolean thiq, String specialMove) {
		super(id, desc, gp, TYP);
		bonus = 0;
		this.slot = slot;
		big = thiq;
		ability = specialMove;
	}
	/**
	 * @param none
	 * @return bonus
	 * 
	 * fairly standard getter
	 * 
	 */
	public int getBonus() {
		return bonus;
	}
	/**
	 * @param none
	 * @return slot
	 * 
	 * fairly standard getter
	 * 
	 */
	public String getSlot() {
		return slot;
	}
	/**
	 * @param none
	 * @return big
	 * 
	 * fairly standard getter
	 * 
	 */
	public boolean isBig() {
		return big;
	}
	/**
	 * @param none
	 * @return ability
	 * 
	 * fairly standard getter
	 * 
	 */
	public String getAbility() {
		return ability;
	}
}
