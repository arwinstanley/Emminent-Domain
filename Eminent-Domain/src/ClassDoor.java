	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is used to represent Class cards and it extends DoorCard
	 * 
	 */
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
	public String getSecondary() {
		return secondary;
	}
}
