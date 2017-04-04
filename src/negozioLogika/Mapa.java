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

	public boolean kokatuDaiteke(int x, int y, int luzera, String norabidea) throws IndexOutOfBoundsException{
		boolean libre = true;
		while(libre){ //Lehenengoaren eta azkenengoaren ondoko posizioak begiratu baita, urez inguratua egon behar baitu
			for (int i=-2;i<luzera;i++){
				if(norabidea=="N"){
					if(!jokalariMapa[x-1][y+1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x][y+1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x+1][y+1].kokatuDaiteke()) libre = false;
					y--;}
				if(norabidea=="E"){
					if(!jokalariMapa[x-1][y-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x-1][y].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x-1][y+1].kokatuDaiteke()) libre = false;
					x++;}
				if(norabidea=="W"){
					if(!jokalariMapa[x+1][y-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x+1][y].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x+1][y+1].kokatuDaiteke()) libre = false;
					x--;}
				if(norabidea=="S"){
					if(!jokalariMapa[x-1][y-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x][y-1].kokatuDaiteke()) libre = false;
					if(!jokalariMapa[x+1][y-1].kokatuDaiteke()) libre = false;
					y++;}
			}
		}
		return libre;
	}
	
}