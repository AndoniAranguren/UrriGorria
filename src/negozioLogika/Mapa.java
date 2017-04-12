package negozioLogika;

public class Mapa {
	//Atributuak
	private static int Tamaina=10;
	private Tile[][] jokalariMapa;
	String jabea;
	
	//Eraikitzailea
	public Mapa(String pIzena){
		jabea= pIzena;
		jokalariMapa= new Tile[Tamaina][Tamaina];
		this.urezBete(jokalariMapa);
	}
		
	//Metodoak
	private void urezBete(Tile[][] pMap){
		for(int Y=0;Y<=Tamaina; Y++){
			for(int X=0;X<=Tamaina; X++){
				pMap[Y][X]=TileFactory.getTileFactory().createUraTile(jabea, X, Y);
			}
		}
	}

	public boolean kokatuDaiteke(int x, int y, int luzera, char norabidea) throws IndexOutOfBoundsException{
		boolean libre = true;
		while(libre){ //Lehenengoaren eta azkenengoaren ondoko posizioak begiratu baita, urez inguratua egon behar baitu
			for (int i=-2;i<luzera;i++){
				if(norabidea=='N'){
					if(!jokalariMapa[x-1][y+1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x][y+1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x+1][y+1].kokatuDaiteke()) libre = false;
					y--;}
				if(norabidea=='E'){
					if(!jokalariMapa[x-1][y-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x-1][y].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x-1][y+1].kokatuDaiteke()) libre = false;
					x++;}
				if(norabidea=='W'){
					if(!jokalariMapa[x+1][y-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x+1][y].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x+1][y+1].kokatuDaiteke()) libre = false;
					x--;}
				if(norabidea=='S'){
					if(!jokalariMapa[x-1][y-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x][y-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x+1][y-1].kokatuDaiteke()) libre = false;
					y++;}
			}
		}
		return libre;
	}

	public Itsasontzia itsasontziaJarri(String pJabea, Itsasontzia pItsasontzia, int pX, int pY, char pNorabidea, boolean pZer) {
		// TODO Auto-generated method stub
		if(pZer){
			ItsasontziTile tile;
			for (int i=0;i<=pItsasontzia.luzeera;i++){
				tile= new ItsasontziTile(pJabea, pX, pY, pItsasontzia);
				
				jokalariMapa[pX][pY]= tile;
				pItsasontzia.tileGehitu(tile,pZer);							//Izan ahal da, tile bateri erasotzean itsasontzi nagusia ez jasotzea
																		//Honela tilak itsasontzi atributu ezberdina duelako. Itsason1[Tile(Itsason2)]
				jokalariMapa[pX-1][pY].kokatzekoGaitasunaEman(pZer);
				jokalariMapa[pX+1][pY].kokatzekoGaitasunaEman(pZer);
				jokalariMapa[pX][pY-1].kokatzekoGaitasunaEman(pZer);
				jokalariMapa[pX][pY+1].kokatzekoGaitasunaEman(pZer);
			}
		}
		else{
			ItsasontziTile tile;
			for (int i=0;i<=pItsasontzia.luzeera;i++){
				
				tile=(ItsasontziTile)jokalariMapa[pX][pY];
				pItsasontzia.tileGehitu(tile,pZer);
				
				jokalariMapa[pX][pY]=new UraTile(pJabea, pX, pY);
				
				jokalariMapa[pX-1][pY].kokatzekoGaitasunaEman(pZer);
				jokalariMapa[pX+1][pY].kokatzekoGaitasunaEman(pZer);
				jokalariMapa[pX][pY-1].kokatzekoGaitasunaEman(pZer);
				jokalariMapa[pX][pY+1].kokatzekoGaitasunaEman(pZer);
			}
		}
		return pItsasontzia;
	}
	
<<<<<<< HEAD
	public void erasoaJaso(String pNork, int pX,int pY,int pIndarra){
		jokalariMapa[pX][pY].jo(pNork,pIndarra);
	}
=======
	public void erasoaJaso(int x,int y,String nork,int indarra){
		jokalariMapa[x][y].jo(nork,indarra);
		
	}
	
>>>>>>> refs/remotes/origin/master
}