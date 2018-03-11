import java.util.ArrayList;

public class EminentTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Player petr = new Player(false, "Willim");
      Player alx = new Player(true, "alx");
      //MonsterDoor nme = new MonsterDoor(id, desc, tres, lvlsUp, lvl, bad)
      MonsterDoor amzn = new MonsterDoor("amazon", "this ones female", 2, 1, 8,"lose 2 lvls");
      MonsterDoor insuranceBoi = new MonsterDoor("insurance salesman", "this ones mean", 3, 2, 10,"go to lvl 1");
      MonsterDoor bigFoot = new MonsterDoor("bigfoot", "this one has big feet", 2, 1, 6,"lose your footwear");
      MonsterDoor pluto = new MonsterDoor("plutoniam dragon", "this one breathes fire", 5, 3, 20,"u ded");
      MonsterDoor pot = new MonsterDoor("potted plant", "this one isnt alive", 1, 1, 1,"lose 1 lvl");
      
      //CurseDoor nme = new CurseDoor(id, desc)
      CurseDoor small = new CurseDoor("curse! lose a small item", "lose a small item smh");
      CurseDoor lvl = new CurseDoor("curse! lose a level", "lose a level item smh");
      CurseDoor dos = new CurseDoor("curse! lose two cards", "lose a two card item smh");
      CurseDoor tran = new CurseDoor("curse! change sex", "against catholic social teaching smh");
      CurseDoor rac = new CurseDoor("curse! change race", "I think this is against catholic social teaching smh");
      
      
   
      MonsterDoor amzn2 = new MonsterDoor("amazon", "this ones female", 2, 1, 8,"lose 2 lvls");
      MonsterDoor insuranceBoi2 = new MonsterDoor("insurance salesman", "this ones mean", 3, 2, 10,"go to lvl 1");
      MonsterDoor bigFoot2 = new MonsterDoor("bigfoot", "this one has big feet", 2, 1, 6,"lose your footwear");
      MonsterDoor pluto2 = new MonsterDoor("plutoniam dragon", "this one breathes fire", 5, 3, 20,"u ded");
      MonsterDoor pot2 = new MonsterDoor("potted plant", "this one isnt alive", 1, 1, 1,"lose 1 lvl");
      
      CurseDoor small2 = new CurseDoor("curse! lose a small item", "lose a small item smh");
      CurseDoor lvl2 = new CurseDoor("curse! lose a level", "lose a level item smh");
      CurseDoor dos2 = new CurseDoor("curse! lose two cards", "lose a two card item smh");
      CurseDoor tran2 = new CurseDoor("curse! change sex", "against catholic social teaching smh");
      CurseDoor rac2 = new CurseDoor("curse! change race", "I think this is against catholic social teaching smh");
      
      
      //ArmsLoot(String id, String desc, int gp, int bonus, String slot, boolean thiq)
       ArmsLoot rat1 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 0, 1,"one hand", false);
       ArmsLoot rat2 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 1, 1,"one hand", false);
       ArmsLoot rat3 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 2, 1,"one hand", false);
       ArmsLoot rat4 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 4, 1,"one hand", false);
       ArmsLoot rat5 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 8, 1,"one hand", false);
       ArmsLoot rat6 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 16, 1,"one hand", false);
       ArmsLoot rat7 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 32, 1,"one hand", false);
       ArmsLoot rat8 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 64, 1,"one hand", false);
       ArmsLoot rat9 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 128, 1,"one hand", false);
       ArmsLoot rat10 = new ArmsLoot("rat on a stick", "Its absolutley worthless", 256, 1,"one hand", false);
       
       
       ArrayList<DoorCard> doorDeck = new ArrayList<DoorCard>(20);
       ArrayList<LootCard> lootDeck = new ArrayList<LootCard>(10);
       
       lootDeck.add(rat1);
       lootDeck.add(rat2);
       lootDeck.add(rat3);
       lootDeck.add(rat4);
       lootDeck.add(rat5);
       lootDeck.add(rat6);
       lootDeck.add(rat7);
       lootDeck.add(rat8);
       lootDeck.add(rat9);
       lootDeck.add(rat10);

       
       doorDeck.add(amzn);
       doorDeck.add(insuranceBoi);
       doorDeck.add(bigFoot);
       doorDeck.add(pluto);
       doorDeck.add(pot);

       
       doorDeck.add(amzn2);
       doorDeck.add(insuranceBoi2);
       doorDeck.add(bigFoot2);
       doorDeck.add(pluto2);
       doorDeck.add(pot2);
       
       doorDeck.add(small2);
       doorDeck.add(lvl2);
       doorDeck.add(dos2);
       doorDeck.add(tran2);
       doorDeck.add(rac2);
       
       LootDeck deckL = new LootDeck(lootDeck);
       DoorDeck deckD = new DoorDeck(doorDeck);
       
       
       
       
       Board test = new Board(alx, petr, deckL, deckD);
       
       test.startGame();
       test.runTurn();
       for(DoorCard x : test.getDoorDeck().getDeck()) {
    	   System.out.print(" "+x+",");
       }
	}

}
