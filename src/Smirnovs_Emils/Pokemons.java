package Smirnovs_Emils;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemons {

	// 		================ ATRIBŪTI ================
	
			private int damage, HP, level, defense, maxHP;
			private String vards, bilde, tips;
			
			
			// ========== KONSTRUKTORS ==========
			
			public Pokemons(int damage, int HP, int level, int defense, int maxHP, String vards, String bilde, String tips) {
				this.damage = damage;
				this.HP = HP;
				this.level = level;
				this.defense = defense;
				this.maxHP = maxHP;
				this.vards = vards;
				this.bilde = bilde;
				this.tips = tips;
				
			}
			
			// Abstrakta metode (varbūt nakotnē pagaidām es nevaru izdomāt.)
//			public abstract int Uzbrukt();
			
			
			//=============== GETTER METODES ==================
			
			public int getDamage() {
				return damage;
			}
			
			public int getHP() {
				return HP;
			}
			
			public int getLevel() {
				return level;
			}
			
			public int getDefense() {
				return defense;
			}
			
			public int getMaxHP() {
				return maxHP;
			}
			
			public String getVards() {
				return vards;
			}
			
			public String getBilde() {
				return bilde;
			}
			
			
			
			//=============== SETTER METODES ==================
			
			public void setDamage(int damage) {
				this.damage = damage;
			}
			
			public void setHP(int HP) {
				this.HP = HP;
			}
			
			public void setLevel(int level) {
				this.level = level;
			}
			
			public void setDefense(int defense) {
				this.defense = defense;
			}

			public void setMaxHP(int maxHP) {
				this.maxHP = maxHP;
			}
			
			public void setVards(String vards) {
				this.vards = vards;
			}
			
			public void setBilde(String bilde) {
				this.bilde = bilde;
			}
}
