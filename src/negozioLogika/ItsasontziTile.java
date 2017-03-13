package negozioLogika;

public class ItsasontziTile extends Itsasontzia{
	private int vit=100;
	private Itsasontzia itsasontzi;
	
	public ItsasontziTile(){	}
	
	public boolean suntsituta(){
		if (this.vit<=0) return true;
		else return false;
	}
	
	public void eraso(String etsaia, int damage){
		if (!this.itsasontzi.damageEzkutuari(damage)) this.vit-=damage;
	}
}
