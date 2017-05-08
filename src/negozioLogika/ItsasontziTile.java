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
		if(pZer){
			if(itsasontzi.ezkutuaDauka()){
				itsasontzi.ezkutuariJo(pIndarra, pZer);
			}
			else{
				bizitza-=pIndarra;
				if(this.suntsitutaDago()){
					itsasontzi.suntsitutaDago();
				}
			}
		}
		else{
			if (bizitza<100) bizitza=100;
			else itsasontzi.ezkutuariJo(pIndarra, pZer);
		}
	}
	public boolean suntsitutaDago(){
		return bizitza<=0;
	}
	public void ezkutuaJarri(boolean pZer){
		itsasontzi.ezkutuaJarri(pZer);
	}
}