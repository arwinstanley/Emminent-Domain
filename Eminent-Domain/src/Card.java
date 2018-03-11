
public class Card {
private String id;
private String desc;
public Card(String iden, String descr) {
	id =iden;
	desc = descr;
}
public String getId() {
	return id;
}
public String getDesc() {
	return desc;
}
public void setId(String in) {
	id= in;
}
public void setDesc(String in) {
	desc = in;
}
}
