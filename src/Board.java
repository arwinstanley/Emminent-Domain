	/**
	 * @author arwinstanley
	 * @Date 8/25/18
	 * 
	 * This Class is a representation of the board-state of the game and it calls most of the game functions
	 */
public class Board {
	// keeps track of the turns
	private int turnCount;
	// player 1
	private Player p1;
	//player 2
	private Player p2;
	//represents the stack of loot cards
	private LootDeck lootDeck;
	//represents the stack of door cards
	private DoorDeck doorDeck;
	//boolean to keep track of the turn
	private boolean turn;   // p1 = true
	// boolean to track whether or not there was a fight this turn
	private boolean fight;
	/**
	 * @param p1 is the first player
	 * @param p2 is the second player
	 * @param lootDeck is the lootDeck object that represents the loot cards
	 * @param doorDeck is the object that represents the pile of Door cards
	 * 
	 * this constructor is used to create a basic blank board
	 * 
	 */
	public Board(Player p1, Player p2, LootDeck lootDeck, DoorDeck doorDeck) {
		this.p1 =p1;
		this.p2 =p2;
		this.lootDeck =lootDeck;
		this.doorDeck =doorDeck;
		turnCount = 1;
		fight = false;
	}	
	/**
	 * @return boolean fight is true when there is a fight happening
	 * 
	 * standard getter for fight
	 * 
	 */
	public boolean isFight() {
		return fight;
	}
	/**
	 * @param fight is the boolean whether or not there is a fight
	 * @return none
	 * 
	 * standard setter for fight
	 * 
	 */
	public void setFight(boolean fight) {
		this.fight = fight;
	}
	/**
	 * @return turnCount is an int representation of how many turns have taken place 
	 * 
	 * standard function to iterate turnCount
	 * 
	 */
	public int nextTurn() {
		if(turn)
			turn = false;
		else
			turn = true;
		turnCount ++;
		fight = false;
		return turnCount;
	}
	/**
	 * @return none
	 * 
	 * helper method that shuffles the loot and door decks as well as deals cards to player 1 and 2
	 * 
	 */
	public void startGame() {
		lootDeck.shuffle();
		doorDeck.shuffle();
		lootDeck.deal(p1);
		lootDeck.deal(p2);
		doorDeck.deal(p1);
		doorDeck.deal(p2);
		turn = true;
	}
	/**
	 * @param player is the player object your dealing too
	 * @return none
	 * 
	 * helper method that deals in any given player
	 * 
	 */
	public void dealIn(Player player) {
		lootDeck.deal(player);
		doorDeck.deal(player);
	}
	/**
	 * @return none
	 * 
	 * This is the big guns for this class this method runs pretty much everything else needed to do to run the game
	 * Edit: this part might need further documentation
	 * 
	 */
	public void runTurn() {
		if(turn) {
			doorDeck.kickDownTheDoor(p1, this);
			if(!fight) {
				MonsterDoor mon = (MonsterDoor)p1.findFight();
				if(!(mon ==null)) {
					Monster challenge = new Monster(mon);
					challenge.fight(p1, this);
				}
				lootDeck.lootTheRoom(1, p1);
			} 
			update();
			return;
		}
		else {
			doorDeck.kickDownTheDoor(p2, this);
			if(!fight) {
				MonsterDoor mon = (MonsterDoor)p2.findFight();
				if(!(mon ==null)) {
					Monster challenge = new Monster(mon);
					challenge.fight(p1, this);
				}
				lootDeck.lootTheRoom(1, p2);
			}
			update();
			return;
		}
	}
	/**
	 * @return int turnCount
	 * 
	 * standard getter for turnCount
	 * 
	 */
	public int getTurnCount() {
		return turnCount;
	}
	/**
	 * @param int turnCount
	 * 
	 * standard setter for turnCount
	 * 
	 */
	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	/**
	 * @return p1 is the player1 object
	 *  
	 * standard getter for player1
	 * 
	 */
	public Player getP1() {
		return p1;
	}
	/**
	 * @param Player p1
	 * 
	 * standard setter for player1
	 * 
	 */
	public void setP1(Player p1) {
		this.p1 = p1;
	}
	/**
	 * @return p2 is the player2 object
	 *  
	 * standard getter for player2
	 * 
	 */
	public Player getP2() {
		return p2;
	}
	public void setP2(Player p2) {
		this.p2 = p2;
	}
	public LootDeck getLootDeck() {
		return lootDeck;
	}
	public void setLootDeck(LootDeck lootDeck) {
		this.lootDeck = lootDeck;
	}
	public DoorDeck getDoorDeck() {
		return doorDeck;
	}
	public void setDoorDeck(DoorDeck doorDeck) {
		this.doorDeck = doorDeck;
	}
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public void update() {
		if(p1.getLvl()==0) {
			System.out.println(p1.getName()+ " you are dead, you must redraw your hand");
			p1.die(this);
		}
		if(p2.getLvl()==0) {
			System.out.println(p2.getName()+ " you are dead, you must redraw your hand");
			p2.die(this);
		}
		if(p1.getLvl()==10) {
			System.out.println(p1.getName()+ " you Won in "+ turnCount + " turns");
			System.exit(0);
		}
		if(p2.getLvl()==10) {
			System.out.println(p2.getName()+ " you Won in "+ turnCount + " turns");
			System.exit(0);
		}
	}
}
