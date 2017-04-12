package negozioLogika;

public class ItsasontziTile extends Tile {
	
	private Itsasontzia itsasontzi;
	private int bizitza=200;
	
	public ItsasontziTile(String pJabea, int a, int b, Itsasontzia pItsasontzia) {
		// TODO Auto-generated constructor stub
		super(a, b,pJabea);
		itsasontzi = pItsasontzia;
	}
	
	public void bizitzaAldatu(int pIndarra){
		bizitza-=pIndarra;
		if(this.suntsitutaDago()){
			itsasontzi.suntsitutaDago();
		}
	}
	public boolean suntsitutaDago(){
		return bizitza<=0;
	}
}
