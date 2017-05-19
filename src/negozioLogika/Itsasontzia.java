package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

import negozioLogika.ItsasontziTile;

public class Itsasontzia extends Objektuak {
	protected final int luzeera,premioa;
	private int ezkutua,ezkutuLehen;
	private final int ezkutuMax=200;
	
	private String jabea=null;
	private boolean suntsituta;
	private ArrayList<ItsasontziTile> tileLista;
	public Itsasontzia(String pMota, int pKop, int pLuzeera, int pPremioa){
		super(pMota, pKop,0);
		ezkutuLehen=0;ezkutua=0;
		luzeera = pLuzeera;
		premioa = pPremioa;
		tileLista= new ArrayList<ItsasontziTile>();
	}
	public void informazioaInprimatu() {
		System.out.println("\nMota: "+izena);
//		System.out.println("       Kopurua: "	+kopurua);
		System.out.println("       Jabea: "		+jabea);
//		System.out.println("       Luzera: "	+luzeera);
//		System.out.println("       Premioa: "	+premioa);
//		System.out.println("       Suntsituta: "+suntsituta);
	}
	public void tileGehitu(ItsasontziTile pTile, boolean pZer) {
		if(pZer){
			tileLista.add(pTile);}
		else{
			tileLista.remove(pTile);}
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
	public ArrayList<ItsasontziTile> ezkutuaJarri(boolean pZer){
		if(pZer){
			ezkutuLehen=ezkutua;
			ezkutua=ezkutuMax;
		}
		else{
			ezkutua=ezkutuLehen;
		}
		for(int i=0; i<tileLista.size();i++) 
			tileLista.get(i).setEzkutua(pZer);
		return tileLista;
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
	public ArrayList<Tile> jo(String pNork,int pIndarra,int pX,int pY, boolean pZer) {
		int i=0;
		boolean bilatzen=true;
		ItsasontziTile itsTile=null;
		Iterator<ItsasontziTile> it= tileLista.iterator();
		ArrayList<Tile>tile=new ArrayList<Tile>();
		
		while(it.hasNext()&&bilatzen){//tile-a bilatu
			itsTile = it.next();
			if(!itsTile.posizioanDago(pX, pY))i++;
			
			else{//aurkitu da
				bilatzen=false;
				itsTile=tileBatiErasotu(pNork,itsTile,pIndarra,pZer);
				tileLista.set(i,itsTile);			
			}
		}
		Partida.jokalariariDiruaEman(pNork, konprobazioak(),pZer);
		return tile;
	}
	public int konprobazioak() {
		int bizirik=0;
		boolean lehenSuntsituta=suntsituta;
		
		for(ItsasontziTile tile : tileLista)
			if(tile.bizirikDago())bizirik++;
		
		suntsituta=(bizirik==0);	
		
		ArrayList<ItsasontziTile> listaT=new ArrayList<ItsasontziTile>();
		for(int i=0; i<tileLista.size();i++) {
			ItsasontziTile tile = tileLista.get(i);
			tile.setEzkutua(ezkutua>0);
			tile.suntsitutaDago(suntsituta);
			listaT.add(tile);
		}
		for(ItsasontziTile tile : listaT)tileLista.add(tile);
			
		return (lehenSuntsituta!=suntsituta? premioa:0);
	}
	private ItsasontziTile tileBatiErasotu(String pNork,ItsasontziTile pT,int pIndarra, boolean pZer) {
		if(pZer){
			if(ezkutua>0){
				ezkutua-=pIndarra;
				pIndarra=0;
			}
		}else{
			if(pT.bizirikDago()){
				ezkutua+=pIndarra;
				pIndarra=0;
			}
		}
		pT.jo(pNork, pIndarra, pZer);
		if (ezkutuOsoaDu())ezkutua=ezkutuMax;
		return pT;
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
	public boolean getSuntzituta() {
		return suntsituta;
	}
}