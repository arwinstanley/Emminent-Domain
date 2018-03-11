	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is a representation of Transmutation Spells
	 */
public class TransSpell extends SpellLoot {
	//the condition for you to cast
	private String condition;
	//Sets all of the cards of this class to type transpell
	private static final String TYP = "transpell";
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param gp is the amount of Gold its worth
	 * 
	 * fairly standard constructor calls its super
	 * 
	 */
	public TransSpell(String id, String desc, int gp) {
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
	public void setCondition(String cond) {
		condition = cond ;
	}	/**
	 * @param none
	 * @return board the current game board
	 * 
	 * Its literally the title 
	 * 
	 */
	public void checkCondition(Board board) {
		
	}
}
