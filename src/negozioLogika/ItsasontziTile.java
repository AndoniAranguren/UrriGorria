package negozioLogika;

public class ItsasontziTile extends Tile {
	
	private static Itsasontzia itsasontzi;
	private final int bizitzaMax=100;
	private int bizitza;
	
	public ItsasontziTile(String pJabea, int pX, int pY, Itsasontzia pItsasontzia) {
		super(pJabea,pX, pY);
		bizitza=bizitzaMax;
		itsasontzi = pItsasontzia;
		super.kokatzekoGaitasunaEman(false);
		super.identifikadorea="Itsasontzi";
	}
	
	public int bizitzaAldatu(int pIndarra, boolean pZer){
		System.out.println("Indarra: "+pIndarra+" "+bizitza+" lehen -> orain ");
		bizitza=bizitza+(pZer? -pIndarra:pIndarra);
		if (bizitzaOsoaDu())bizitza=bizitzaMax;
		System.out.print(bizitza);
		return bizitza;
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
	public boolean bizitzaOsoaDu() {
		return bizitza>=bizitzaMax;
	}

	public boolean berdinak(ItsasontziTile tile) {
		return (tile.jabeaDa(ikusiAhal.get(0)) && tile.posizioanDago(koordX,koordY));
	}
}