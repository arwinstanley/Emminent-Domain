
public class Monster extends Entity {
	private MonsterDoor me;
	
public Monster(MonsterDoor base) {
	super(base.getLevel());
	me = base;
}
public void fightWon(Player player, LootDeck deck) {
	player.addLvls(me.getGainedLvls());
	deck.lootTheRoom(me.getTreasure(), player);
	player.setLooted(true);
}
public void fightLost(Player player, Board board) {
	switch(me.getId()) {
		case "amazon": 
			player.setLvl(player.getLvl()-2);
			break;
		case "bigfoot" :
			player.remove("footwear", board);
			break;
		case "insurance salesman":
			player.setLvl(1);
			break;
		case "plutonium dragon" :
			player.die(board);
			break;
		case "potted plant" :
			player.setLvl(player.getLvl()-1);
			break;
	}
	return;
}
public void fight(Player player, Board board) {
	int debuff = 0;
	boolean aggro = true;
	switch(me.getId()) {
		case "amazon": 
			aggro = (player.getGender()) ? true : false;
			break;
		case "bigfoot" :
			debuff = 3;
			break;
		case "insurance salesman":
			debuff = player.getArmsBonus();
			break;
		case "plutonium dragon" :
			aggro = (player.getLvl()<=4) ? false : true;
			break;
		case "potted plant" :
			debuff = (player.getPlayerRace().equals("elf")) ? 3 : 0;
			break;
	}
	if(!aggro) {
		System.out.println("You won");
		fightWon(player, board.getLootDeck());
		return;
	}
	else if(player.getTotalLvl()-debuff > this.getLvl()) {
		System.out.println("You won");
		fightWon(player, board.getLootDeck());
		return;
	}
	else {
		System.out.println("You lost");
		fightLost(player, board);
		return;
	}
}
@Override
public String toString() {
	return me.getId() + " a lvl " + getLvl() + " Monster, with " + me.getTreasure() + " treasure(s)";
}
}
