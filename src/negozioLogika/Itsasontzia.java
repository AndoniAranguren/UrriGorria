package negozioLogika;

import negozioLogika.ItsasontziTile;

public abstract class Itsasontzia {
	public final int luzeera,prezioa;
	private int tileKont=0;
	private ItsasontziTile[] tileLista;
	public Itsasontzia(String pMota){
		luzeera = ItsasontziFactory.getItsasontziFactory().luzeeraLortu(pMota);
		prezioa = ItsasontziFactory.getItsasontziFactory().prezioaLortu(pMota);
		tileLista= new ItsasontziTile[luzeera];
		}
	public void itsasontziaKokatu(int x, int y, char norabidea, String pJabea){
		//Mapan jada itsasontzia kokatu ahal dela begiratu dugu
		for (int i=0;i<luzeera;i++){
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

	public int getPrezioa(){
		return prezioa;
	}
	
	public abstract void informazioaInprimatu();
	public void tileGehitu(ItsasontziTile pTile) {
		// TODO Auto-generated method stub
		tileLista[tileKont]=pTile;
	}

}


