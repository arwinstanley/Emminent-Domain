	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is the highest in the Card inheritance hierarchy and outlines the basic functions of a Card 
	 * Throughout this project I use LastName Inheritance naming, so I put the most recent Parent Name directly after the class name
	 */
public class Card {
	//This is one of the most important Strings in the program and it guides pretty much everything later on
	private String id;
	//Card description
	private String desc;
	/**
	 * @param iden is the id
	 * @param descr is the description
	 * @return none
	 * 
	 * fairly standard constructor
	 * 
	 */
	public Card(String iden, String descr) {
		id =iden;
		desc = descr;
	}
	/**
	* @param none
	* @return id
	* 
	* fairly standard getter
	* 
	*/
	public String getId() {
		return id;
	}
	/**
	* @param none
	* @return desc
	* 
	* fairly standard getter
	* 
	*/
	public String getDesc() {
		return desc;
	}
	/**
	* @param in, the new id
	* @return none
	* 
	* fairly standard setter
	* 
	*/
	public void setId(String in) {
		id= in;
	}
	/**
	* @param in, the new id
	* @return none
	* 
	* fairly standard setter
	* 
	*/
	public void setDesc(String in) {
		desc = in;
	}
}
