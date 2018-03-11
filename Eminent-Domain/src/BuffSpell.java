
public class BuffSpell extends SpellLoot {
private int bonus;
private int mult;
private Entity [] targets ;
public BuffSpell(String id, String desc, int gp, int bonuss, Entity [] targ) {
	super(id, desc, gp);
	mult = 1;
	bonus = bonuss;
	targets = targ;
}
public BuffSpell(String id, String desc, int gp, Entity [] targ, int multi) {
	super(id, desc, gp);
	mult = multi;
	bonus = 0;
	targets = targ;
}
public int getBonus() {
	return bonus;
}
public void setBonus(int bonus) {
	this.bonus = bonus;
}
public int getMult() {
	return mult;
}
public void setMult(int mult) {
	this.mult = mult;
}
public Entity[] getTargets() {
	return targets;
}
public void setTargets(Entity[] targets) {
	this.targets = targets;
}
}
