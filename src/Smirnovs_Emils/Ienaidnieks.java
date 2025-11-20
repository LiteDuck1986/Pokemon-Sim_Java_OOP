package Smirnovs_Emils;

public class Ienaidnieks {

	public Pokemons orginalaisP;
    public int HP;
    
    public Ienaidnieks(Pokemons p) {
        this.orginalaisP = p;
        this.HP = p.getMaxHP();  // Cīņu vienmēr sāks ar max HP
    }

    public int getDamage() {
        return orginalaisP.getDamage();
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
    
    public String getRunat() {
        return orginalaisP.getRunat();
    }
	
}
