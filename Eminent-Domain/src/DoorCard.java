
public class DoorCard extends Card {
	private String type;
public DoorCard(String id, String desc, String typ) {
	super(id, desc);
	type = typ;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	String out = "";
	return "(" +this.getId()+ ", "+ this.getType()+ ")";
	
}
}
