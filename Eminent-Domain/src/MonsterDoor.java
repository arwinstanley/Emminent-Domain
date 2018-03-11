
public class MonsterDoor extends DoorCard  {
private int treasure;
private int gainedLvls;
private int level;
private String badStuff;
private boolean alive = false;
private int debuff = 0;
public int getDebuff() {
	return debuff;
}
public void setDebuff(int debuff) {
	this.debuff = debuff;
}
public MonsterDoor(String id, String desc, int tres, int lvlsUp, int lvl, String bad) {
	super(id, desc,"monster");
	treasure = tres;
	gainedLvls = lvlsUp;
	level = lvl;
	badStuff = bad;
}
public Monster summon() {
	if(alive)
		return null;
	alive = true;
	return new Monster(this);
	
}
public int getTreasure() {
	return treasure;
}
public void setTreasure(int treasure) {
	this.treasure = treasure;
}
public int getGainedLvls() {
	return gainedLvls;
}
public void setGainedLvls(int gainedLvls) {
	this.gainedLvls = gainedLvls;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public String getBadStuff() {
	return badStuff;
}
public void setBadStuff(String badStuff) {
	this.badStuff = badStuff;
}
}
