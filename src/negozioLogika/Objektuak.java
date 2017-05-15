package negozioLogika;

import negozioLogika.commands.CommandObjektuaErabili;

public abstract class Objektuak {
	protected String izena;
	protected int kopurua;
	

	public Objektuak(String pIzena, int pKop){
		izena=pIzena;
		kopurua=pKop;
	}
	public boolean izenBerdina (String pIzena){
		return izena.equals(pIzena);
	}
	public Mapa aktibatu(String pNori, Mapa pMapa, int pX, int pY,char pNorabide,boolean pZer) {
		return pMapa;
	}
	public void erabili(String pNori, int pX, int pY,char pNorabide) {
		if(kopurua>0) new CommandObjektuaErabili(pNori, this, pX, pY, pNorabide);
	}
	public void behinErabili(boolean pZer){
		if(pZer)kopurua--;
		else kopurua++;
	}
	public String getIzena(){
		return izena;
	}
	public int getKopurua() {
		return kopurua;
	}
	public void gehitu(int pKop,boolean pZer) {
		if(pZer)kopurua+=pKop;
		else	kopurua-=pKop;
	}
	public boolean kopuruNahikoa(int pKop) {
		return (kopurua>=pKop&&kopurua>0);
	}

}
