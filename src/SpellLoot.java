
public class SpellLoot extends LootCard {
	private Monster target;
public SpellLoot(String id, String desc, int gp) {
	super(id, desc, gp, "spell");
}
public void cast(Monster mon) {
	target = mon;
}
}
