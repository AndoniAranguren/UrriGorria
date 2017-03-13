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
	
	public void itsasontziaIpiniNahiDa(Itsasontzia pOntzi, int pX, int pY, char pNorabidea){
		if(this.posizioEgokia(pOntzi.luzeera(), pX, pY, pNorabidea)){
			Kontsola.komandoaLortu("itsasontziaIpini").exekutatu(this, pOntzi, pX, pY, pNorabidea);
		}//else doSomething?
	}
	
	private boolean posizioEgokia(int pOntzi.luzeera, int pX, int pY, char pNorabidea){
		int xKont,yKont,luzeeraKont;
		xKont=pX;
		yKont=pY;
		luzeeraKont=pOntzi.luzeeraEman();
		boolean egokia,konprobazioakFalta=true;
		
		while (konprobazioakFalta){
			egokia=this.jokalariMapa[pY][pX].posizioEgokia(pOntzi.luzeera());
			luzeeraKont--;
			
			if(egokia){
				konprobazioakFalta= (0!=luzeeraKont);
				this.mugituNorabidera(xKont,yKont,pNorabidea);
			}else konprobazioakFalta=egokia;
		}
		return egokia;
	}
	private void mugituNorabidera(int pX, int pY, char pNorabidea){
		switch (pNorabidea){
		case 'N': pY++; break;
		case 'E': pX++; break;
		case 'S': pY--; break;
		case 'W': pX--; break;
		default: break;
	}
	public boolean kokatuDaiteke(int x, int y, int luzera, String norabidea) throws IndexOutOfBoundsException{
		boolean libre = true;
		while(libre){ //Lehenengoaren eta azkenengoaren ondoko posizioak begiratu baita, urez inguratua egon behar baitu
			for (int i=-2;i<luzera;i++){
				if(norabidea=="N"){
					if(!jokalariMapa[x-1][y+1].uraDa()) libre = false;
					if(!jokalariMapa[x][y+1].uraDa()) libre = false;
					if(!jokalariMapa[x+1][y+1].uraDa()) libre = false;
					y--;}
				if(norabidea=="E"){
					if(!jokalariMapa[x-1][y-1].uraDa()) libre = false;
					if(!jokalariMapa[x-1][y].uraDa()) libre = false;
					if(!jokalariMapa[x-1][y+1].uraDa()) libre = false;
					x++;}
				if(norabidea=="W"){
					if(!jokalariMapa[x+1][y-1].uraDa()) libre = false;
					if(!jokalariMapa[x+1][y].uraDa()) libre = false;
					if(!jokalariMapa[x+1][y+1].uraDa()) libre = false;
					x--;}
				if(norabidea=="S"){
					if(!jokalariMapa[x-1][y-1].uraDa()) libre = false;
					if(!jokalariMapa[x][y-1].uraDa()) libre = false;
					if(!jokalariMapa[x+1][y-1].uraDa()) libre = false;
					y++;}
			}
		}
		return libre;
	}
	
}