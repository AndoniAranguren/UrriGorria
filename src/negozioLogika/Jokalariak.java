package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Jokalariak {
	
	protected String izena;
	boolean bizirik;
	protected Mapa mapa;
	protected Inbentarioa inb;
	private Denda denda;
	private int dirua;
	
	public Jokalariak(String pIzena){
		izena=pIzena;
		jokalariaErreseteatu();
	}
	
	public abstract void itsasontziakIpini();
	
	public void jokalariaErreseteatu(){
		denda= new Denda();
		inb = new Inbentarioa();
		dirua=500;
		bizirik=true;
		mapa= new Mapa(izena);
		
		ArrayList<Objektuak> objektuak=new ArrayList<Objektuak>();
		objektuak=denda.dendakIzakinakDitu(ErosketaFactory.getErosketaFactory()
				.createErosketa("DHasteko Objektu Guztiak"));
		denda.objektuakEman(objektuak, false);
		inb.objektuakEman(objektuak, true);
	}
	
	public boolean kokatuDaiteke( int pX, int pY,  char pNorabidea, int pLuzeera){
		return mapa.kokatuDaiteke(pX, pY,  pNorabidea, pLuzeera);
	}
	public Itsasontzia itsasontziaJarri(Itsasontzia pOntzi, int pX, int pY, char pNorabidea, boolean pZer) {
		return mapa.itsasontziaJarri(izena, pOntzi, pX, pY, pNorabidea, pZer);
	}
	public boolean izenHauDu(String pJ) {
		return pJ==izena;
	}
	public ArrayList<Objektuak> dendakIzakinakDitu(Erosketa pErosketa) {
		return denda.dendakIzakinakDitu(pErosketa);		//Izakinik ez baldin badu, null bat bueltatuko du
	}
	public void jokalariariDiruaEman(int pPrezioa, boolean pZer) { 
		if(pZer==true)	dirua+=pPrezioa;
		else			dirua-=pPrezioa;
	}
	public void dendariObjektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer) {
		denda.objektuakEman(pObjektuak,pZer);
	}
	public void jokalariariObjektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer) {
		inb.objektuakEman(pObjektuak,pZer);
	}
	public String izenaLortu() {
		return izena;
	}
	public boolean objektuakNahikoakDitu(ArrayList<Objektuak> pObjektuak) {
		return inb.objektuakNahikoakDitu(pObjektuak);
	}
	public void jokalariariErasotu(String pNork, Objektuak pObjektua, int pX, int pY,char pNorabide, boolean pZer) {
		mapa=pObjektua.aktibatu(pNork,mapa, pX, pY, pNorabide, pZer);
	}
	public boolean jokalariaBizirikDago() {
		return bizirik;
	}
	public String[][] mapaInterpretatu(String pNork){
		return mapa.mapaInterpretatu(pNork);
	}
	public boolean jokalariakDiruaDu(int pPrezioa) {
		return (dirua>=pPrezioa);
	}
	public String getIzena() {
		return izena;
	}
	public ArrayList<String> inbentarioaEman() {
		return inb.inbentarioaEman();
	}
	public ArrayList<String> dendaEman() {
		return denda.dendaEman();
	}
	public int jokalariakZenbatDiru() {
		return dirua;
	}

	public void objektuaErabili(String pNori, String[] pInfo) {
		inb.objektuaErabili(pNori,pInfo);
	}

	public abstract void jokatuCPU(int pFasea);
}
