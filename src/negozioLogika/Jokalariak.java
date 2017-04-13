package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Jokalariak {
	
	private String izena;
	private Mapa mapa;
	private Inbentarioa inb;
	private Denda denda;
	private int dirua = 0;
	private ArrayList<Itsasontzia> nireItsasontziak;
	
	
	public Jokalariak(String pIzena){
		izena=pIzena;
	}
	
	
	public boolean kokatuDaiteke(int x, int y, int luzera, char norabidea){
		return mapa.kokatuDaiteke(x, y, luzera, norabidea);
	}
	public void itsasontziaJarri(String pOntzi, int pX, int pY, char pNorabidea, boolean pZer) {
		// TODO Auto-generated method stub
		if(pZer==true){
			Itsasontzia itsasontzia = ItsasontziFactory.getItsasontziFactory().createItsasontzia(pOntzi);
			itsasontzia = mapa.itsasontziaJarri(izena, itsasontzia, pX, pY, pNorabidea,pZer);
			nireItsasontziak.add(itsasontzia);
		}
		else{
			boolean aurkituta=false;
			Itsasontzia itsasontzia;
			Iterator<Itsasontzia> it=nireItsasontziak.iterator();
			while(!aurkituta && it.hasNext()){
				itsasontzia= it.next();
				if(itsasontzia.hauDa(pOntzi, pX, pY)){
					mapa.itsasontziaJarri(izena, itsasontzia, pX, pY, pNorabidea, pZer);
				}
				else{
					//Hemen ez dago itsasontzirik
				}
			}
		}
	}
	public boolean izenHauDu(String pJ) {
		// TODO Auto-generated method stub
		return pJ==izena;
	}
	public int jokalariakDiruaDu(String pJokalaria, String pErosketa) {
		// TODO Auto-generated method stub
		int diruaDu=-1;									//diru nahikorik ez badu, zenb negatiboa bueltatzen du
		if(denda.zenbatBalioDu(pErosketa)<=dirua){
			diruaDu=denda.zenbatBalioDu(pErosketa);		//diru nahikoa baldin badu, dirua bueltatzen du
		}
		return diruaDu;
	}
	public String[] dendakIzakinakDitu(String pErosketa) {
		// TODO Auto-generated method stub
		return denda.dendakIzakinakDitu(pErosketa);		//Izakinik ez baldin badu, null bat bueltatuko du
	}
	public void jokalariariDiruaEman(int pPrezioa, boolean pZer) { //pZer=true denean jokalariari dirua emango zaio, bestela kendu
		// TODO Auto-generated method stub
		if(pZer==true)	dirua+=pPrezioa;
		else			dirua-=pPrezioa;
	}
	public void dendariObjektuakEman(String[] pObjektuak, boolean pZer) {
		// TODO Auto-generated method stub
		denda.objektuakEman(pObjektuak,pZer);
	}
	public void jokalariariObjektuakEman(String[] pObjektuak, boolean pZer) {
		// TODO Auto-generated method stub
		inb.objektuakEman(pObjektuak,pZer);
	}
	public String izenaLortu() {
		// TODO Auto-generated method stub
		return izena;
	}
	public boolean objektuakDitu(String[] pObjektuak) {
		// TODO Auto-generated method stub
		return inb.objektuakDitu(pObjektuak);
	}

	public void erasoaJaso(String pNork, Armak pArma, int pX, int pY,char pNorabide, boolean pZer) {
		// TODO Auto-generated method stub
		mapa=pArma.erasoEgin(pNork,mapa, pX, pY, pNorabide, pZer);
	}
}
