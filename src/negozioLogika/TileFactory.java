package negozioLogika;

public class TileFactory {
	private static TileFactory nTileFactory = null;
	private TileFactory(){}
	public static TileFactory getTileFactory(){
		if(nTileFactory==null) nTileFactory = new TileFactory();
		return nTileFactory;
	}
	public Tile createUraTile(String pJabea, int x, int y){
		Tile nireTile= new UraTile(pJabea,x,y); 
		return nireTile;
	}
	public Tile createItsasontziTile(int x, int y, Itsasontzia pItsas, String pJabea){
		Tile nireTile= new ItsasontziTile(x, y, pJabea, pItsas);
		return nireTile;
	}
}
