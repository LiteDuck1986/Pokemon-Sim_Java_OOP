package Smirnovs_Emils;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemons {

	// 		================ ATRIBŪTI ================
	
			private int damage, HP, level, defense, maxHP;
			private String name;
			
			
			// ========== KONSTRUKTORS ==========
			
			public Pokemons(int damage, int HP, int level, int defense, int maxHP, String name) {
				this.damage = damage;
				this.HP = HP;
				this.level = level;
				this.defense = defense;
				this.maxHP = maxHP;
				this.name = name;
				
			}
			
			
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
			
			public String getName() {
				return name;
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
			
			public void setName(String name) {
				this.name = name;
			}
}
