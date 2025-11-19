package Smirnovs_Emils;

public class ElektriskaisP extends Pokemons{
	
	// =========== ATRIBŪTI =============
	// To do..
	
	// =========== KONSTRUKTORS ============
	
	public ElektriskaisP(int damage, int HP, int level, int defense, int maxHP, String vards, String bilde, String tips) {
		super(damage, HP, level, defense, maxHP, vards, bilde, tips);

		
	}
	
	@Override
	public int Uzbrukt(Pokemons pretinieks) {
	    int dmg = Math.max(1, getDamage() - pretinieks.getDefense() / 2);
	    pretinieks.setHP(pretinieks.getHP() - dmg);
	    return dmg;
	}
}
