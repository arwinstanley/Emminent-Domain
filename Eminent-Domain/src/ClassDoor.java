
public class ClassDoor extends DoorCard {
private String primary;
private String secondary;
public ClassDoor(String id, String desc, String prime, String seco) {
	super(id, desc, "class");
	primary = prime;
	secondary = seco;
}
public String getPrimary() {
	return primary;
}
public void setPrimary(String primary) {
	this.primary = primary;
}
public String getSecondary() {
	return secondary;
}
public void setSecondary(String secondary) {
	this.secondary = secondary;
}
}
