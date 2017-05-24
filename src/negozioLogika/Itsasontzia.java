package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

import negozioLogika.TileItsasontzi;

public class Itsasontzia extends Objektuak {
	protected final int luzeera,premioa,ezkutuMax=200;
	private int ezkutua;
	private ArrayList<Integer> ezkutuLehen;
	
	private String jabea=null;
	private boolean suntsituta;
	private ArrayList<TileItsasontzi> tileLista;
	public Itsasontzia(String pMota, int pKop, int pLuzeera, int pPremioa){
		super(pMota, pKop,0);
		ezkutuLehen=new ArrayList<Integer>();
		ezkutua=0;
		ezkutuLehen.add(ezkutua);
		luzeera = pLuzeera;
		premioa = pPremioa;
		tileLista= new ArrayList<TileItsasontzi>();
	}
	public void tileGehitu(TileItsasontzi pTile, boolean pZer) {
		if(pZer){
			tileLista.add(pTile);}
		else{
			if(pTile==null){
				tileLista.clear();
			}else
				tileLista.remove(pTile);
		}
	}
	public boolean equals(Itsasontzia pOntzi) {
		return (pOntzi.izenBerdina(izena) && pOntzi.tileBerdinakDira(tileLista));
	}
	private boolean tileBerdinakDira(ArrayList<TileItsasontzi> pTileLista){
		boolean ezberdinak=true;
		Iterator<TileItsasontzi> it;
		for(TileItsasontzi tile: pTileLista){
			it=tileLista.iterator();
			while(it.hasNext()&&ezberdinak){
				ezberdinak= it.next().equals(tile);}
			if(!ezberdinak) break;
		}
		return ezberdinak;
	}

	public ArrayList<TileItsasontzi> setEzkutua(boolean pZer){
		if(pZer){
			ezkutuLehen.add(0,ezkutua);
			ezkutua=ezkutuMax;
		}
		else{
			ezkutua=ezkutuLehen.get(0);
			ezkutuLehen.remove(0);
		}
		return tileLista;
	}
	public ArrayList<TileItsasontzi> setKonponketa(boolean pZer) {
		for(int i=0; i<tileLista.size();i++) 
			tileLista.get(i).setKonponketa(pZer);
		konprobazioak(pZer);
		return tileLista;
	}
	public boolean itsasontziaDa(){
		return true;
	}
	public int jo(TileItsasontzi pT,int pIndarra,boolean pZer) { //Tiletatik jasoko da
		if(pZer){
			if(ezkutua>0){
				ezkutua-=pIndarra;
				pIndarra=0;
			}
		}else{
			if(pT.getBizirik()){
				ezkutua+=pIndarra;
				pIndarra=0;
			}
		}
		if (ezkutuOsoaDu())ezkutua=ezkutuMax;
		
		return pIndarra;
	}
	public void konprobazioak(boolean pZer) {
		int bizirik=0;
		boolean lehenSuntsituta=suntsituta;
		
		for(TileItsasontzi tile : tileLista)
			if(tile.getBizirik())bizirik++;
		
		suntsituta=!(bizirik>0);	
		
		ArrayList<TileItsasontzi> listaT=new ArrayList<TileItsasontzi>();
		for(int i=0; i<tileLista.size();i++) {
			TileItsasontzi tile = tileLista.get(i);
			listaT.add(i,tile);
		}
		tileLista=listaT;
		
		if(suntsituta){
			Partida.jokalariariDiruaEman(Partida.getPartida().norenTxandaDaIzena(), lehenSuntsituta!=suntsituta? premioa:0,pZer);
		}
	}
	public boolean ezkutuOsoaDu() {
		return ezkutua>=ezkutuMax;
	}
	public boolean posizioanDago(int pX,int pY) {
		boolean hauDa=false;
		for(TileItsasontzi its : tileLista){
			if(its.posizioanDago(pX, pY))
				hauDa=true;
		}
		return hauDa;
	}
	@Override
	public void aktibatu(String pNork, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer){
	}
	public boolean getSuntzituta() {
		return suntsituta;
	}
	public boolean getEzkutua() {
		return ezkutua>0;
	}
	public String getJabea() {
		return jabea;
	}
	public void setJabea(String jabea) {
		this.jabea = jabea;
	}	
	public int getLuzeera() {
		return luzeera;
	}
	public int[] getKoordenatuak() {
		int[] koord=new int[2];
		koord[0]=tileLista.get(0).getX();
		koord[1]=tileLista.get(0).getY();
		return koord;
	}
	public boolean getBizitzaOsoarekin() {
		int suntsituta=0;
		for(TileItsasontzi tile : tileLista)
			if(!tile.bizitzaOsoaDu())suntsituta++;
		return suntsituta==0;
	}
	
}