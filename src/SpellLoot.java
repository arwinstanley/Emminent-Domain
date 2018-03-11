	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is a over head representation of the Spell cards and extend Loot
	 */
public class SpellLoot extends LootCard {
	// the target for the spell
	private Entity target;
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param gp is the amount of Gold its worth
	 * @param type is the type
	 * 
	 * fairly standard constructor calls its super
	 * 
	 */
	public SpellLoot(String id, String desc, int gp, String type) {
		super(id, desc, gp, type);
	}
	/**
	 * @param Targ the new target
	 * @return none
	 * 
	 * fairly standard setter sets target
	 * 
	 */
	public void setTarget(Entity targ) {
		target = targ;
	}
}
