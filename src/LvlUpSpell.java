	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is a representation of lvl Up Spells Spells
	 */
public class LvlUpSpell extends SpellLoot {
	//condition to lvl up
	private String condition;
	//sets all the types of this to lvlupspell
	private static final String TYP = "lvlupspell";
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param gp is the amount of Gold its worth
	 * 
	 * fairly standard constructor calls its super
	 * 
	 */
	public LvlUpSpell(String id, String desc, int gp) {
		super(id, desc, gp, TYP);
		condition = "none";
	}
	/**
	 * @param none
	 * @return condition
	 * 
	 * fairly standard getter
	 * 
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @param cond the new condition
	 * @return slot
	 * 
	 * fairly standard setter
	 * 
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @param none
	 * @return board the current game board
	 * 
	 * Its literally the title 
	 * 
	 */
	public void checkCondition(Board board) {
		
	}
}
