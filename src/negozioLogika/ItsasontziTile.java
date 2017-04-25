package negozioLogika;

public class ItsasontziTile extends Tile {
	
	private Itsasontzia itsasontzi;
	private int bizitza=100;
	
	public ItsasontziTile(String pJabea, int pX, int pY, Itsasontzia pItsasontzia) {
		// TODO Auto-generated constructor stub
		super(pJabea,pX, pY);
		identifikadorea="ItsasontziTile";
		itsasontzi = pItsasontzia;
		super.kokatuAhalDa=false;
		super.identifikadorea="Itsasontzi";
	}
	
	public void bizitzaAldatu(int pIndarra, boolean pZer){
		if(!pZer){
			if(itsasontzi.ezkutuaDauka()){
				itsasontzi.ezkutuariJo(pIndarra);
			}
			else{
				bizitza-=pIndarra;
				if(this.suntsitutaDago()){
					itsasontzi.suntsitutaDago();
				}
			}
		}
		else{//erregenera daiteke, hau da, suntsituta badago ondo egotera pasako da BAINA itsasontzia guztiz suntsitua balego EZ
			bizitza=100;
		}
	}
	public boolean suntsitutaDago(){
		return bizitza<=0;
	}
	public void ezkutuaJarri(){
		itsasontzi.ezkutuaJarri();
	}
}