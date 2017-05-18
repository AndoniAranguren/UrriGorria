package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

import negozioLogika.ItsasontziTile;

public class Itsasontzia extends Objektuak {
	protected final int luzeera,prezioa;
	private int ezkutua,ezkutuLehen;
	private final int ezkutuMax=200;
	
	private String jabea=null;
	private boolean suntsituta;
	private ArrayList<ItsasontziTile> tileLista;
	public Itsasontzia(String pMota, int pKop, int pLuzeera, int pPrezioa){
		super(pMota, pKop,0);
		ezkutuLehen=0;ezkutua=0;
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
		if(pZer){
			ezkutuLehen=ezkutua;
			ezkutua=ezkutuMax;
		}
		else{
			ezkutua=ezkutuLehen;
		}
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
	public Tile jo(String pNork,int pIndarra, boolean pZer,int pX,int pY) {
		int i=0,emaitza=pIndarra;
		boolean bilatzen=true;
		ItsasontziTile its=null;
		Iterator<ItsasontziTile> it= tileLista.iterator();
		while(it.hasNext()&&bilatzen){
			its = it.next();
			if(its.posizioanDago(pX, pY)){
				bilatzen=false;
				if(pZer){
					emaitza=eskutuaErasotu(pIndarra, pZer);
				}else{
					if(its.bizitzaOsoaDu()){
						eskutuaErasotu(pIndarra, pZer);
					}else{
						its.jo(pNork,emaitza, pZer);
						emaitza=0;
					}
					
				}
			}
			else 
			i++;
		}
		its.jo(pNork,emaitza, pZer);
		return its;
	}
	private int eskutuaErasotu(int pIndarra, boolean pZer) {
		System.out.println("ezkutua: "+ezkutua);
		int emaitza=0;
		if(pZer){
			if(ezkutua>0){
				ezkutua-=pIndarra;
				emaitza=0;
			}else
				emaitza=pIndarra;
		}else{
			ezkutua+=pIndarra;
			emaitza=0;
		}
		if (ezkutuOsoaDu())ezkutua=ezkutuMax;
		System.out.println("emaitza: "+emaitza);
		return emaitza;
	}
	public boolean ezkutuOsoaDu() {
		return ezkutua>=ezkutuMax;
	}
	public boolean posizioanDago(int pX,int pY) {
		boolean hauDa=false;
		for(ItsasontziTile its : tileLista){
			if(its.posizioanDago(pX, pY))
				hauDa=true;
		}
		return hauDa;
	}
	@Override
	public Mapa aktibatu(String pNork, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer){
		return pMapa;
	}
}