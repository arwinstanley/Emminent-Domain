
public class Board {
	private int turnCount;
	private Player p1;
	private Player p2;
	private LootDeck lootDeck;
	private DoorDeck doorDeck;
	private boolean turn;   // p1 = true
	private boolean fight;
	
public Board(Player p1, Player p2, LootDeck lootDeck, DoorDeck doorDeck) {
		this.p1 =p1;
		this.p2 =p2;
		this.lootDeck =lootDeck;
		this.doorDeck =doorDeck;
		turnCount = 1;
		fight = false;
	}
public boolean isFight() {
	return fight;
}
public void setFight(boolean fight) {
	this.fight = fight;
}
public int nextTurn() {
	if(turn)
		turn = false;
	else
		turn = true;
	turnCount ++;
	fight = false;
	return turnCount;
}
public void startGame() {
	lootDeck.shuffle();
	doorDeck.shuffle();
	lootDeck.deal(p1);
	lootDeck.deal(p2);
	doorDeck.deal(p1);
	doorDeck.deal(p2);
	turn = true;
}
public void dealIn(Player player) {
	lootDeck.deal(player);
	doorDeck.deal(player);
}
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
public int getTurnCount() {
	return turnCount;
}
public void setTurnCount(int turnCount) {
	this.turnCount = turnCount;
}
public Player getP1() {
	return p1;
}
public void setP1(Player p1) {
	this.p1 = p1;
}
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
