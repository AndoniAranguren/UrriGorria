package negozioLogika;

public abstract class Objektuak {
	protected String izena;
	protected int kopurua;
	

	public Objektuak(String pIzena, int pKop){
		izena=pIzena;
		kopurua=pKop;
	}
	public boolean izenBerdina (String pIzena){
		return this.izena.equals(pIzena);
	}
	public Mapa aktibatu(String pNori, Mapa pMapa, int pX, int pY,char pNorabide,boolean pZer) {
		return pMapa;
	}
	public void erabili(String nori, int koordX, int koordY, char norabidea) {
	}
	public String getIzena(){
		return izena;
	}
	public int getKopurua() {
		return kopurua;
	}
	public void gehitu(int pKop,boolean pZer) {
		if(pZer)
			kopurua+=pKop;
		else
			kopurua-=pKop;
	}
	public boolean kopuruNahikoa(int pKop) {
		return (kopurua>=pKop&&kopurua>0);
	}
}
