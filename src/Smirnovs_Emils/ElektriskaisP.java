package Smirnovs_Emils;

import java.util.Random;

public class ElektriskaisP extends Pokemons{
	
	static Random rand = new Random();
	
	// =========== ATRIBŪTI =============
		private int paralizeIesp = 25; // 25% iespēja
		private int ladetsLimenis = 0;
		private final int maxLadets = 3;
		private int shockDMG = 5;
		private boolean irUzladets = false; // ja true tad 100% paralīze
	    
	    
	// =========== KONSTRUKTORS ============
	
	public ElektriskaisP(int damage, int HP, int level, int defense, int maxHP, String vards, String bilde, String tips, String runat) {
		super(damage, HP, level, defense, maxHP, vards, bilde, tips, runat);
		
	}

	@Override
	public boolean SpecialATK() {
		if(irUzladets) {
			irUzladets = false;
			ladetsLimenis = 0;
		}
		
		//25% iespēja ka būs special ATK, kas paralizēs pretinieku.
		boolean paralize = rand.nextInt(100) < paralizeIesp;
		
		// Katru uzbrukumu uzlādejas
        if (ladetsLimenis < maxLadets) {
        	ladetsLimenis++;
        }
        
        // Ja ir max līmenis sasniegts tad nākamais uzbrukums būs 100% paralīze
        if (ladetsLimenis == maxLadets) {
        	irUzladets = true;
        }
        
        if(irUzladets)
        	paralize = true;
	    
        return paralize;
	}
	
}
