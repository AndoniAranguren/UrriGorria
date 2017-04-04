package negozioLogika;

import negozioLogika.ItsasontziTile;

public abstract class Itsasontzia {
	public final int luzeera;
	private int prezioa;
	private ItsasontziTile[] tileLista;
	public Itsasontzia(int pLuzera, int pPrezioa){
		luzera = pLuzera;
		prezioa = pPrezioa;
		tileLista= new ItsasontziTile[luzera];
		}
	public void itsasontziaKokatu(int x, int y, char norabidea, String pJabea){
		//Mapan jada itsasontzia kokatu ahal dela begiratu dugu
		for (int i=0;i<luzera;i++){
			tileLista[i] = new ItsasontziTile(x, y, pJabea,this);
			if(norabidea=='N') y--;
			if(norabidea=='S') y++;
			if(norabidea=='E') x++;
			if(norabidea=='W') x--;
		}
	}
	
	public int getLuzera(){
		return luzeera;
	}
	
	public void erasoaJaso(int x, int y){
		for(int i=0;i<luzeera;i++){
			if(!tileLista[i].jotaDago())
			if(tileLista[i].kokalekuHauDa(x, y)){
				tileLista[i].jo();
			}
			if(this.suntzituta()) System.out.println("Hondoratuta!");
		}
	}
	public int getPrezioa(){
		return prezioa;
	}
	
	public abstract void informazioaInprimatu();

}


