package negozioLogika;

public class ItsasontziTile extends Tile {
	
	private static Itsasontzia itsasontzi;
	private final int bizitzaMax=100;
	private int bizitza;
	private boolean suntsituta,ezkutua;
	
	public ItsasontziTile(String pJabea, int pX, int pY, Itsasontzia pItsasontzia) {
		super(pJabea,pX, pY);
		bizitza=bizitzaMax;
		itsasontzi = pItsasontzia;
		suntsituta=false;
		ezkutua=false;
		super.kokatzekoGaitasunaEman(false);
		super.identifikadorea="Itsasontzi";
	}
	
	public int bizitzaAldatu(int pIndarra, boolean pZer){
		bizitza=bizitza+(pZer? -pIndarra:pIndarra);
		if (bizitzaOsoaDu())bizitza=bizitzaMax;
		return bizitza;
	}
	public void ezkutuaJarri(boolean pZer){
		itsasontzi.ezkutuaJarri(pZer);
	}

	protected String identifikadorea(){
		if(suntsituta){
			return "Suntsituta";
		}else if(!bizirikDago()){
			return "Ukituta";
		}else if(ezkutua){
			return "Ezkutua";
		}else
			return identifikadorea;
	}
	public boolean itsasontziaDa() {
		return true;
	}
	public boolean bizirikDago(){
		return bizitza>0;
	}
	public boolean ondoratuta() {
		return suntsituta;
	}
	public boolean bizitzaOsoaDu() {
		return bizitza>=bizitzaMax;
	}	
	public boolean ezkutuaDu() {
		return ezkutua;
	}
	public boolean berdinak(ItsasontziTile tile) {
		return (tile.jabeaDa(ikusiAhal.get(0)) && tile.posizioanDago(koordX,koordY));
	}

	public void suntsitutaDago(boolean pZer) {
		suntsituta=pZer;		
	}

	public void setEzkutua(boolean pZer) {
		ezkutua=pZer;		
	}
}