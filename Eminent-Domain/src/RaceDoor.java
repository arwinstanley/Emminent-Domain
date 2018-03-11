
public class RaceDoor extends DoorCard {
private String passive;
public RaceDoor(String id, String desc, String pass) {
	super(id, desc, "race");
	passive = pass;
}
public String getPassive() {
	return passive;
}
public void setPassive(String passive) {
	this.passive = passive;
}
}
