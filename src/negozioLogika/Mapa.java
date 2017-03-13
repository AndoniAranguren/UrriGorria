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
				pMap[Y][X]= new UraTile(jabea,Y,X);
			}
		}
	}
	
	public void itsasontziaIpiniNahiDa(Itsasontzia pOntzi, int pX, int pY, char pNorabidea){
		if(this.posizioEgokia(pOntzi.luzeera(), pX, pY, pNorabidea)){
			
		}//else doSomething?
	}
	
	public boolean posizioEgokia(int pX, int pY){
		return this.jokalariMapa[pY][pX].posizioEgokia();
	}
}