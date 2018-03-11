
public class LootCard extends Card {
private int gp;
private String type;
public LootCard(String id, String desc, int goldVal, String ty){
	super(id, desc);
	gp = goldVal;
	type = ty;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getGP() {
	return gp;
}
public void setGP(int goldVal) {
  gp = goldVal;
}
}
