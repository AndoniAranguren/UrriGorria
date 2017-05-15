package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

import negozioLogika.ItsasontziTile;

public class Itsasontzia extends Objektuak {
	protected final int luzeera,prezioa;
	private int ezkutua;
	private final String jabea=null;
	private boolean suntsituta;
	private ArrayList<ItsasontziTile> tileLista;
	public Itsasontzia(String pMota, int pKop, int pLuzeera, int pPrezioa){
		super(pMota, pKop);
		ezkutua=0;
		luzeera = pLuzeera;
		prezioa = pPrezioa;
		tileLista= new ArrayList<ItsasontziTile>();
	}
	public void informazioaInprimatu() {
		// TODO Auto-generated method stub
		System.out.println("       Mota: "		+izena);
		System.out.println("       Kopurua: "	+kopurua);
		System.out.println("       Jabea: "		+jabea);
		System.out.println("       Luzera: "	+luzeera);
		System.out.println("       Prezioa: "	+prezioa);
		System.out.println("       Suntsituta: "+suntsituta);

	}
	public void tileGehitu(ItsasontziTile pTile, boolean pZer) {
		if(pZer){
			tileLista.add(pTile);
		}
		else{
			tileLista.remove(pTile);
		}
	}
	public void suntsitutaDago() {
		boolean suntsitutaDago=true;
		Iterator<ItsasontziTile> it=tileLista.iterator();
		while(suntsitutaDago && it.hasNext()){
			suntsitutaDago= it.next().suntsitutaDago();
		}
		suntsituta=suntsitutaDago;
	}
	public boolean hauDa(Itsasontzia pOntzi) {
		return (pOntzi.izenBerdina(izena) && pOntzi.tileBerdinakDira(tileLista));
	}
	private boolean tileBerdinakDira(ArrayList<ItsasontziTile> pTileLista){
		boolean ezberdinak=true;
		Iterator<ItsasontziTile> it;
		for(ItsasontziTile tile: pTileLista){
			it=tileLista.iterator();
			ezberdinak=true;
			while(it.hasNext()&&ezberdinak){
				ezberdinak= !it.next().equals(tile);
			}
			if(ezberdinak) break;
		}
		return ezberdinak;
	}
	public int luzeera() {
		return luzeera;
	}
	public void ezkutuaJarri(boolean pZer){
		if(pZer) ezkutua=200;
		else ezkutua-=200;
	}
	public boolean ezkutuaDauka(){
		return ezkutua!=0;
	}
	public void ezkutuariJo(int pIndarra, boolean pZer){
		if (pZer) this.ezkutua-=pIndarra;
		else this.ezkutua+=pIndarra;
	}
}


