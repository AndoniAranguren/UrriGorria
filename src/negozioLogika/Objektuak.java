package negozioLogika;

import negozioLogika.commands.CommandObjektuaErabili;

public abstract class Objektuak {
	protected String izena;
	protected int kopurua,fase;
	

	public Objektuak(String pIzena, int pKop, int pZeFasetanErabili){
		izena=pIzena;
		kopurua=pKop;
		fase=pZeFasetanErabili;
	}
	public boolean izenBerdina (String pIzena){
		return izena.equals(pIzena);
	}
	public abstract Mapa aktibatu(String pNork, Mapa pMapa, int pX, int pY,char pNorabide,boolean pZer);
	public void erabili(String pNori, int pX, int pY,char pNorabide) {
		if(kopurua>0) new CommandObjektuaErabili(pNori, this, pX, pY, pNorabide);
	}
	public void behinErabili(boolean pZer){
		if(pZer)kopurua--;
		else kopurua++;
		if(kopurua<0)kopurua=0;
	}
	public String getIzena(){
		return izena;
	}
	public int getKopurua() {
		return kopurua;
	}
	public int getFasea(){
		return fase;
	}
	public void gehitu(int pKop,boolean pZer) {
		if(pZer)kopurua+=pKop;
		else	kopurua-=pKop;
	}
	public boolean kopuruNahikoa(int pKop) {
		return (kopurua>=pKop&&kopurua>0);
	}
	public boolean itsasontziaDa() {
		return false;
	}
	public int getLuzeera() {
		return 0;
	}
	public boolean isArma(){
		return false;
	}
	public boolean isEkipo() {
		return false;
	}

}
