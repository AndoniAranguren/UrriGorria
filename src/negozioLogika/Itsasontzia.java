package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

import negozioLogika.ItsasontziTile;

public class Itsasontzia extends Objektuak {
	protected final int luzeera,prezioa;
	private final String jabea=null;
	private boolean suntsituta;
	private ArrayList<ItsasontziTile> tileLista;
	public Itsasontzia(String pMota, int pLuzeera, int pPrezioa){
		super(pMota);
		luzeera = pLuzeera;
		prezioa = pPrezioa;
		tileLista= new ArrayList<ItsasontziTile>();
	}
	public void informazioaInprimatu() {
		// TODO Auto-generated method stub
		System.out.println("       Mota: "		+izena);
		System.out.println("       Jabea: "		+jabea);
		System.out.println("       Luzera: "	+luzeera);
		System.out.println("       Prezioa: "	+prezioa);
		System.out.println("       Suntsituta: "+suntsituta);

	}
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
	public boolean hauDa(Itsasontzia pOntzi) {
		// TODO Auto-generated method stub
		return (pOntzi.izenBerdina(super.izena) && pOntzi.tileBerdinakDira(tileLista));
	}
//	private boolean hemenDago(int pX, int pY) {
//		// TODO Auto-generated method stub
//		boolean aurkituta=false;
//		Iterator<ItsasontziTile> it=tileLista.iterator();
//		while(!aurkituta && it.hasNext()){
//			aurkituta= it.next().posizioanDago(pX, pY);
//		}
//		return aurkituta;
//	}
	private boolean tileBerdinakDira(ArrayList<ItsasontziTile> pTileLista){
		return pTileLista==this.tileLista;
	}
	public int luzeera() {
		// TODO Auto-generated method stub
		return luzeera;
	}
}


