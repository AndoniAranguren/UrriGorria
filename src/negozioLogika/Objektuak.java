package negozioLogika;

public abstract class Objektuak {
	protected String izena;
	

	public Objektuak(String pIzena){
		this.izena=pIzena;
	}
	public boolean izenBerdina (String pObjektua){
		return this.izena==pObjektua;
	}
	public Mapa aktibatu(String pNori, Mapa pMapa, int pX, int pY,char pNorabide,boolean pZer) {
		return pMapa;
	}
	public void erabili(String nori, int koordX, int koordY, char norabidea) {
	}
	public String getIzena(){
		return izena;
	}
}
