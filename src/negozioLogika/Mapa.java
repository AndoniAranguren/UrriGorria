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

	public boolean kokatuDaiteke(int pX, int pY, char pNorabidea, int pLuzeera){// throws IndepXOutOfBoundsEpXception{
		boolean libre = true;
		while(libre){ //Lehenengoaren eta azkenengoaren ondoko posizioak begiratu baita, urez inguratua egon behar baitu
			for (int i=-2;i<pLuzeera;i++){
				if(pNorabidea=='N'){
					if(!jokalariMapa[pX-1][pY+1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[pX][pY+1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[pX+1][pY+1].kokatuDaiteke()) libre = false;
					pY--;}
				if(pNorabidea=='E'){
					if(!jokalariMapa[pX-1][pY-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[pX-1][pY].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[pX-1][pY+1].kokatuDaiteke()) libre = false;
					pX++;}
				if(pNorabidea=='W'){
					if(!jokalariMapa[pX+1][pY-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[pX+1][pY].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[pX+1][pY+1].kokatuDaiteke()) libre = false;
					pX--;}
				if(pNorabidea=='S'){
					if(!jokalariMapa[pX-1][pY-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[pX][pY-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[pX+1][pY-1].kokatuDaiteke()) libre = false;
					pY++;}
			}
		}
		return libre;
	}

	public Itsasontzia itsasontziaJarri(String pJabea, Itsasontzia pItsasontzia, int pX, int pY, char pNorabidea, boolean pZer) {
		// TODO Auto-generated method stub
			ItsasontziTile tile;
			for (int i=0;i<=pItsasontzia.luzeera;i++){
				if(pZer){
					tile= new ItsasontziTile(pJabea, pX, pY, pItsasontzia);
					jokalariMapa[pX][pY]= tile;
				}
				else{
					tile=(ItsasontziTile)jokalariMapa[pX][pY];				
					jokalariMapa[pX][pY]=new UraTile(pJabea, pX, pY);
				}
				//Izan ahal da, tile bateri erasotzean itsasontzi nagusia ez jasotzea
				//Honela tilak itsasontzi atributu ezberdina duelako. Itsason1[Tile(Itsason2)]
				pItsasontzia.tileGehitu(tile,pZer);							
				jokalariMapa[pX-1][pY].kokatzekoGaitasunaEman(!pZer);	//Itsasontzia jartzen bada(pZer=t) ->Gaitasuna kentzen zaio	(pZer=f)
				jokalariMapa[pX+1][pY].kokatzekoGaitasunaEman(!pZer);
				jokalariMapa[pX][pY-1].kokatzekoGaitasunaEman(!pZer);
				jokalariMapa[pX][pY+1].kokatzekoGaitasunaEman(!pZer);
			}
		return pItsasontzia;
	}

	public boolean erasoSinpleaJaso(String pNork,int pX, int pY, int pIndarra, boolean pZer) {
		// TODO Auto-generated method stub
		if(pX<=Tamaina && pY<=Tamaina){
			jokalariMapa[pX][pY].jo(pNork, pIndarra, pZer);
			return true;
		}else return false;
	}
}