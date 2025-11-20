package Smirnovs_Emils;

import java.util.Random;

public class UdensP extends Pokemons{
	
	static Random rand = new Random();

	// =========== ATRIBŪTI =============
		// To do..
		
		// =========== KONSTRUKTORS ============
		
		public UdensP(int damage, int HP, int level, int defense, int maxHP, String vards, String bilde, String tips, String runat) {
			super(damage, HP, level, defense, maxHP, vards, bilde, tips, runat);

			
		}

		@Override
		public boolean SpecialATK() {
			//25% iespēja ka būs special ATK, kas palielinās pokemona HP.
			return rand.nextInt(4) == 0;
			
		}
		
		
}
