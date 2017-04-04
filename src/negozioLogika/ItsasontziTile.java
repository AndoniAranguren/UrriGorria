package negozioLogika;

public class ItsasontziTile extends Tile {
	private Itsasontzia itsasontzi;
	private int bizitza=200;
	public ItsasontziTile(int a, int b,String pJabea, Itsasontzia pItsasontzia) {
		super(a, b,pJabea);
		itsasontzi = pItsasontzia;
		// TODO Auto-generated constructor stub
	}
	private void bizitzaAldatu(int pIndarra){
		bizitza-=pIndarra;
	}
	public boolean suntsitutaDago(){
		return bizitza<=0;
	}
}
