package negozioLogika;

public class ItsasontziTile extends Tile {
	
	private static Itsasontzia itsasontzi;
	private int bizitza=100;
	
	public ItsasontziTile(String pJabea, int pX, int pY, Itsasontzia pItsasontzia) {
		super(pJabea,pX, pY);
		itsasontzi = pItsasontzia;
		super.kokatzekoGaitasunaEman(false);
		super.identifikadorea="Itsasontzi";
	}
	
	public void bizitzaAldatu(int pIndarra, boolean pZer){
		int emaitza=pIndarra;
		if(bizitza>0)emaitza=Partida.getPartida().itsasontziaJo(ikusiAhal.get(0),this,pIndarra, pZer);
		bizitza=bizitza+(pZer? -emaitza:emaitza);

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

	public boolean berdinak(ItsasontziTile tile) {
		return (tile.jabeaDa(ikusiAhal.get(0)) && tile.posizioanDago(koordX,koordY));
	}
}