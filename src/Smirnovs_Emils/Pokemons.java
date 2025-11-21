package Smirnovs_Emils;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemons {

	// 		================ ATRIBŪTI ================
	
			private int damage, HP, level, defense, maxHP;
			private String vards, bilde, tips, runat;
			
			
			// ========== KONSTRUKTORS ==========
			
			public Pokemons(int damage, int HP, int level, int defense, int maxHP, String vards, String bilde, String tips, String runat) {
				this.damage = damage;
				this.HP = HP;
				this.level = level;
				this.defense = defense;
				this.maxHP = maxHP;
				this.vards = vards;
				this.bilde = bilde;
				this.tips = tips;
				this.runat = runat;
				
			}
			
			// Abstrakta metode
			public abstract boolean SpecialATK();
			
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
			
			public String getRunat() {
				return runat;
			}
			
			public String getTips() {
				return tips;
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
			
			public void setRunat(String runat) {
				this.runat = runat;
			}
			
			public void setTips(String tips) {
				this.tips = tips;
			}
}
