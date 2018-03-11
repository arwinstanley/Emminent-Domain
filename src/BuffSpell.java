	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is a representation of lvl Up Spells extends SpellLoot
	 */
public class BuffSpell extends SpellLoot {
	//
	private int bonus;
	private int mult;
	private Entity target;
	private static final String TYP = "buffspell";
	public BuffSpell(String id, String desc, int gp, int bonuss, Entity targ) {
		super(id, desc, gp, TYP);
		mult = 1;
		bonus = bonuss;
		target = targ;
	}
	public BuffSpell(String id, String desc, int gp, Entity targ, int multi) {
		super(id, desc, gp, TYP);
		mult = multi;
		bonus = 0;
		target = targ;
	}
	public int getBonus() {
		return bonus;
	}
	public int getMult() {
		return mult;
	}
	public Entity getTargets() {
		return target;
	}
}
