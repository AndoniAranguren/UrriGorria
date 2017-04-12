package negozioLogika;

public class TileFactory {
	private static TileFactory nTileFactory = null;
	private TileFactory(){}
	public static TileFactory getTileFactory(){
		if(nTileFactory==null) nTileFactory = new TileFactory();
		return nTileFactory;
	}
	public Tile createUraTile(String pJabea, int pX, int pY){
		Tile nireTile= new UraTile(pJabea,pX,pY); 
		return nireTile;
	}
	public Tile createItsasontziTile(String pJabea, int pX, int pY, Itsasontzia pItsas){
		Tile nireTile= new ItsasontziTile(pJabea, pX, pY, pItsas);
		return nireTile;
	}
}
