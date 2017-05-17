package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

import negozioLogika.ItsasontziTile;

public class Itsasontzia extends Objektuak {
	protected final int luzeera,prezioa;
	private int ezkutua;
	private String jabea=null;
	private boolean suntsituta;
	private ArrayList<ItsasontziTile> tileLista;
	public Itsasontzia(String pMota, int pKop, int pLuzeera, int pPrezioa){
		super(pMota, pKop,0);
		ezkutua=0;
		luzeera = pLuzeera;
		prezioa = pPrezioa;
		tileLista= new ArrayList<ItsasontziTile>();
	}
	public void informazioaInprimatu() {
		System.out.println("\nMota: "+izena);
//		System.out.println("       Kopurua: "	+kopurua);
		System.out.println("       Jabea: "		+jabea);
//		System.out.println("       Luzera: "	+luzeera);
//		System.out.println("       Prezioa: "	+prezioa);
//		System.out.println("       Suntsituta: "+suntsituta);
	}
	public void tileGehitu(ItsasontziTile pTile, boolean pZer) {
		if(pZer){
			tileLista.add(pTile);}
		else{
			tileLista.remove(pTile);}
	}
	public void suntsitutaDago() {
		boolean suntsitutaDago=true;
		Iterator<ItsasontziTile> it=tileLista.iterator();
		while(suntsitutaDago && it.hasNext()){
			suntsitutaDago= it.next().suntsitutaDago();}
		suntsituta=suntsitutaDago;
	}
	
	public boolean equals(Itsasontzia pOntzi) {
		return (pOntzi.izenBerdina(izena) && pOntzi.tileBerdinakDira(tileLista));
	}
	private boolean tileBerdinakDira(ArrayList<ItsasontziTile> pTileLista){
		boolean ezberdinak=true;
		Iterator<ItsasontziTile> it;
		for(ItsasontziTile tile: pTileLista){
			it=tileLista.iterator();
			while(it.hasNext()&&ezberdinak){
				ezberdinak= it.next().berdinak(tile);}
			if(!ezberdinak) break;
		}
		return ezberdinak;
	}
	public int luzeera() {
		return luzeera;
	}
	public void ezkutuaJarri(boolean pZer){
		if(pZer) ezkutua=200;
		else ezkutua=0;
	}
	public boolean itsasontziaDa(){
		return true;
	}
	public int getLuzeera(){
		return this.luzeera;
	}
	public void jabeaJarri(String pIzena) {
		jabea=pIzena;		
	}
	public int jo(int pIndarra, boolean pZer) {
		int emaitza=0;
		if(pZer){
			if(ezkutua<=0)emaitza=pIndarra;
			else ezkutua-=pIndarra;
		}else{
			ezkutua+=pIndarra;
		}
		return emaitza;
	}
	public boolean tileHauDauka(ItsasontziTile pTile) {
		Iterator<ItsasontziTile> it=tileLista.iterator();
		while(it.hasNext()){
			if(it.next().berdinak(pTile))
				return true;
		}
		return false;
	}
}