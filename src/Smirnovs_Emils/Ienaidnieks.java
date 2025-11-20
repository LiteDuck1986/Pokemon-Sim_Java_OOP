package Smirnovs_Emils;

public class Ienaidnieks {

	public Pokemons orginalaisP;
    public int HP;
    
    public Ienaidnieks(Pokemons p) {
        this.orginalaisP = p; // orģinālais pokemona objekts
        this.HP = p.getMaxHP();  // Cīņu vienmēr sāks ar max HP
    }

    public int getDamage() {
        return orginalaisP.getDamage();
    }
    
    public int getDefense() {
        return orginalaisP.getDefense();
    }

    public String getVards() {
        return orginalaisP.getVards();
    }

    public String getBilde() {
        return orginalaisP.getBilde();
    }
    
    public int getMaxHP() {
        return orginalaisP.getMaxHP();
    }
    
    public int getLevel() {
        return orginalaisP.getLevel();
    }
    
    public String getRunat() {
        return orginalaisP.getRunat();
    }
	
}
