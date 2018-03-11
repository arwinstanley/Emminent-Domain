
public class ArmsLoot extends LootCard {
private int bonus;
private String slot;
private boolean big;
private String ability;
public ArmsLoot(String id, String desc, int gp, int bonus, String slot, boolean thiq) {
	super(id, desc, gp, "arms");
	this.bonus = bonus;
	this.slot = slot;
	big = thiq;
	ability = "none";
}
public ArmsLoot(String id, String desc, int gp, String slot, boolean thiq, String specialMove) {
	super(id, desc, gp, "arms");
	bonus = 0;
	this.slot = slot;
	big = thiq;
	ability = specialMove;
}
public int getBonus() {
	return bonus;
}
public void setBonus(int bonus) {
	this.bonus = bonus;
}
public String getSlot() {
	return slot;
}
public void setSlot(String slot) {
	this.slot = slot;
}
public boolean isBig() {
	return big;
}
public void setBig(boolean big) {
	this.big = big;
}
public String getAbility() {
	return ability;
}
public void setAbility(String ability) {
	this.ability = ability;
}
}
