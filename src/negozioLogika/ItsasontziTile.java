package negozioLogika;

public class ItsasontziTile extends Tile {
	
	private Itsasontzia itsasontzi;
	private int bizitza=100;
	
	public ItsasontziTile(String pJabea, int pX, int pY, Itsasontzia pItsasontzia) {
		// TODO Auto-generated constructor stub
		super(pJabea,pX, pY);
		itsasontzi = pItsasontzia;
		super.kokatuAhalDa=false;
		super.identifikadorea="Itsasontzi";
	}
	
	public void bizitzaAldatu(int pIndarra, boolean pZer){
		if(pZer)
			bizitza-=pIndarra;
		else if (bizitza<100) bizitza=100;
		itsasontzi.ezkutuariJo(pIndarra, pZer);
	}
	public boolean suntsitutaDago(){
		return bizitza<=0;
	}
	public void ezkutuaJarri(boolean pZer){
		itsasontzi.ezkutuaJarri(pZer);
	}
	public boolean itsasontziaDa() {
		return true;
	}
	public boolean bizirikDago(){
		return bizitza>0;
	}
}