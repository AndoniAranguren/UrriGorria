package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

import negozioLogika.ItsasontziTile;

public abstract class Itsasontzia {
	public final int luzeera,prezioa;
	private final String mota;
	private boolean suntsituta;
	private ArrayList<ItsasontziTile> tileLista;
	public Itsasontzia(String pMota){
		mota=pMota;
		luzeera = ItsasontziFactory.getItsasontziFactory().luzeeraLortu(pMota);
		prezioa = ItsasontziFactory.getItsasontziFactory().prezioaLortu(pMota);
		tileLista= new ArrayList<ItsasontziTile>();
		}
	public void itsasontziaKokatu(int x, int y, char norabidea, String pJabea){
		//Mapan jada itsasontzia kokatu ahal dela begiratu dugu
		for (int i=0;i<luzeera;i++){
			tileLista.add(new ItsasontziTile(pJabea,x, y,this));
			if(norabidea=='N') y--;
			if(norabidea=='S') y++;
			if(norabidea=='E') x++;
			if(norabidea=='W') x--;
		}
	}
//	public int getLuzera(){
//		return luzeera;
//	}
//	public int getPrezioa(){
//		return prezioa;
//	}
	public abstract void informazioaInprimatu();
	public void tileGehitu(ItsasontziTile pTile, boolean pZer) {
		// TODO Auto-generated method stub
		if(pZer){
			tileLista.add(pTile);
		}
		else{
			tileLista.remove(pTile);
		}
	}
	public void suntsitutaDago() {
		// TODO Auto-generated method stub
		boolean suntsitutaDago=true;
		Iterator<ItsasontziTile> it=tileLista.iterator();
		while(suntsitutaDago && it.hasNext()){
			suntsitutaDago= it.next().suntsitutaDago();
		}
		suntsituta=suntsitutaDago;
	}
	public boolean hauDa(String pOntzi, int pX, int pY) {
		// TODO Auto-generated method stub
		return (pOntzi==mota && hemenDago(pX,pY));
	}
	private boolean hemenDago(int pX, int pY) {
		// TODO Auto-generated method stub
		boolean aurkituta=false;
		Iterator<ItsasontziTile> it=tileLista.iterator();
		while(!aurkituta && it.hasNext()){
			aurkituta= it.next().posizioanDago(pX, pY);
		}
		return aurkituta;
	}
}


