import java.util.ArrayList;

public class Player extends Entity {
private String name;
ArrayList<LootCard> lootInHand;
ArrayList<DoorCard> doorsInHand;
private int handSize = 0;
private ArrayList<ArmsLoot> equipped;
private ClassDoor playerClass;
private RaceDoor playerRace;
private int armsBonus = 0;
private boolean gender = true;
private boolean looted;
private int totalLvl;
public int getTotalLvl() {
	return this.getLvl() + armsBonus;
}
public void setTotalLvl(int totalLvl) {
	this.totalLvl = totalLvl;
}
public Player(boolean gen, String nam ){
	super(2);
	name = nam;
	gender= gen;
	lootInHand = new ArrayList<LootCard>();
	doorsInHand = new ArrayList<DoorCard>();
	equipped = new ArrayList<ArmsLoot>(20);
	playerClass = new ClassDoor("serf", "jus a por farm hand", "none", "none");
	playerRace = new RaceDoor("human", "justa plain ole human", "none");
	int armsBonus = 0;
	totalLvl = getLvl() + armsBonus;
}
public void addToHand(LootCard card) {
	lootInHand.add(card);
}
public void addToHand(DoorCard card) {
	doorsInHand.add(card);
}
public void equip(int index) {
	if(lootInHand.get(index).getType().equals("arms")) {
		equipped.add((ArmsLoot)lootInHand.get(index));
	}
	update();
}
public void addLvls(int lvls) {
	this.setLvl(this.getLvl()+lvls);
}
public void update() {
	handSize = lootInHand.size()+ doorsInHand.size();
	int i =0 ;
	for(ArmsLoot x : equipped) {
		i+= x.getBonus();
	}
	armsBonus = i;
	totalLvl = getLvl() + armsBonus;
}
public SpellLoot playLootSpell(int index ,Monster target) {
	((SpellLoot) lootInHand.get(index)).cast(target);
	return (SpellLoot) lootInHand.remove(index);
	
}
public void die(Board board) {
	if(!(playerRace==null)) {
		board.getDoorDeck().discard(playerRace);
		playerRace = null;
	}
	if(!(playerClass==null)) {
		board.getDoorDeck().discard(playerClass);
		playerClass = null;
	}
	for(int i = equipped.size()-1; i>=0;i--) {
		board.getLootDeck().discard(equipped.remove(i));
	}
	for(int i = lootInHand.size()-1; i>=0;i--) {
		board.getLootDeck().discard(lootInHand.remove(i));
	}
	for(int i = doorsInHand.size()-1; i>=0;i--) {
		board.getDoorDeck().discard(doorsInHand.remove(i));
	}
	update();
	board.dealIn(this);
	return;
}

public void remove(String slot, Board board) {
	for(int i = equipped.size()-1;i>=0;i--) {
		if(equipped.get(i).getSlot().equals(slot)) {
			board.getLootDeck().discard(equipped.get(i));
			return;
		}
	}
}
public void discRandBigSmall(boolean test, Board board) {//true= big
	if(test) {
		for(int i = equipped.size()-1;i>=0;i--) {
			if(equipped.get(i).isBig()) {
				board.getLootDeck().discard(equipped.get(i));
				return;
			}
		}
	}
	else {
		for(int i = equipped.size()-1;i>=0;i--) {
			if(!equipped.get(i).isBig()) {
				board.getLootDeck().discard(equipped.get(i));
				return;
			}
		}
	}
}
public void discRandom(Board board) {
	int x;
	if(lootInHand.size() > 0&& doorsInHand.size()>0)
		 x = (int) Math.random()*2;
	else if(lootInHand.size()>0)
		x = 0;
	else
		x= 1;
	int y = (x==0) ? (int)Math.random()*lootInHand.size() :(int) Math.random()*doorsInHand.size();
	
	if(x == 1)
		board.getDoorDeck().discard(doorsInHand.get(y));
	if(x==0)
		board.getLootDeck().discard(lootInHand.get(y));
	return;
}
public boolean run() {
	if(((int)Math.random()*6 + 1) >= 4)
		return true;
	return false;
}
public DoorCard findFight(){
	for(int i = 0; i < doorsInHand.size(); i++) {
		if(doorsInHand.get(i).getType().equals("monster"))
			return doorsInHand.remove(i);
	}
	return null;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ArrayList<LootCard> getLootInHand() {
	return lootInHand;
}
public void setLootInHand(ArrayList<LootCard> lootInHand) {
	this.lootInHand = lootInHand;
}
public ArrayList<DoorCard> getDoorsInHand() {
	return doorsInHand;
}
public void setDoorsInHand(ArrayList<DoorCard> doorsInHand) {
	this.doorsInHand = doorsInHand;
}
public int getHandSize() {
	return lootInHand.size()+ doorsInHand.size();
}
public void setHandSize(int handSize) {
	this.handSize = handSize;
}
public ArrayList<ArmsLoot> getEquipped() {
	return equipped;
}
public void setEquipped(ArrayList<ArmsLoot> equiped) {
	this.equipped = equiped;
}
public String getPlayerClass() {
	return playerClass.getId();
}
public void setPlayerClass(ClassDoor playerClass) {
	this.playerClass = playerClass;
}
public String getPlayerRace() {
	return playerRace.getId();
}
public void setPlayerRace(RaceDoor playerRace) {
	this.playerRace = playerRace;
}
public int getArmsBonus() {
	update();
	return armsBonus;
}
public void setArmsBonus(int armsBonus) {
	this.armsBonus = armsBonus;
}
public boolean getGender() {
	return gender;
}
public void setGender(boolean gender) {
	this.gender = gender;
}
public boolean isLooted() {
	return looted;
}
public void setLooted(boolean looted) {
	this.looted = looted;
}
public RaceDoor getRaceCard() {
	return playerRace;
}
public ClassDoor getClassCard() {
	return playerClass;
}
}
