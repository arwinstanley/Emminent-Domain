
public abstract class LvlUpSpell extends SpellLoot {
private String condition;
public LvlUpSpell(String id, String desc, int gp) {
	super(id, desc, gp);
	condition = "none";
}
public abstract boolean isConditionMet();
public String getCondition() {
	return condition;
}
public void setCondition(String condition) {
	this.condition = condition;
}
}
