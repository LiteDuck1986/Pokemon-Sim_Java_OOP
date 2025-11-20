package Smirnovs_Emils;

import java.util.Random;

public class ElektriskaisP extends Pokemons{
	
	static Random rand = new Random();
	
	// =========== ATRIBŪTI =============
	
	// =========== KONSTRUKTORS ============
	
	public ElektriskaisP(int damage, int HP, int level, int defense, int maxHP, String vards, String bilde, String tips, String runat) {
		super(damage, HP, level, defense, maxHP, vards, bilde, tips, runat);
		
	}

	@Override
	public boolean SpecialATK() {
		//25% iespēja ka būs special ATK, kas paralizēs pretinieku.
		return rand.nextInt(4) == 0;
	    
	}
	
}
