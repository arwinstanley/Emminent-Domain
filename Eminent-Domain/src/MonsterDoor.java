	/**
	 * @author arwinstanley
	 * @Date 3/11/18
	 * 
	 * This Class is used to represent monster cards and it extends DoorCard
	 * 
	 */
public class MonsterDoor extends DoorCard  {
	// amount of treasure gained
	private int treasure;
	// amaount of lvls gained
	private int gainedLvls;
	// creatures lvl
	private int level;
	// punishment for defeat
	private String badStuff;
	// sets type to "monster" for all monster cards
	private static final String TYP = "monster";
	
	/**
	 * @param id is the id
	 * @param desc is the description
	 * @param tres is tresure gained
	 * @param lvlsUp is the lvls gained
	 * @param lvl is the monsters lvl
	 * @param bad is the punishment 
	 * @return none
	 * 
	 * fairly standard constructor, calls its super
	 * 
	 */
	public MonsterDoor(String id, String desc, int tres, int lvlsUp, int lvl, String bad) {
		super(id, desc,TYP);
		treasure = tres;
		gainedLvls = lvlsUp;
		level = lvl;
		badStuff = bad;
	}	/**
	* @param none
	* @return new Monster with the source being 'this' card
	* 
	* Creates an Entity Monster from this Card
	* 
	*/
	public Monster summon() {
		return new Monster(this);
	}
	/**
	* @param none
	* @return treasure
	* 
	* fairly standard getter
	* 
	*/
	public int getTreasure() {
		return treasure;
	}
	/**
	* @param none
	* @return gainedLevels
	* 
	* fairly standard getter
	* 
	*/
	public int getGainedLvls() {
		return gainedLvls;
	}
	/**
	* @param none
	* @return card lvl
	* 
	* fairly standard getter
	* 
	*/
	public int getLevel() {
		return level;
	}
	/**
	* @param none
	* @return the bad stuff
	* 
	* fairly standard getter
	* 
	*/
	public String getBadStuff() {
		return badStuff;
	}
}
