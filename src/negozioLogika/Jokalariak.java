package negozioLogika;

public abstract class Jokalariak {
	String izena, fasea;
	Mapa mapa;
	//Inbentario inb;
	int dirua, jarritakoItsasontziak = 0;
	Itsasontzia[] nireItsasontziak;
	
	public Jokalariak(){
		fasea="Iniziala";
	}
	public boolean kokatuDaiteke(int x, int y, int luzera, char norabidea){
		return mapa.kokatuDaiteke(x, y, luzera, norabidea);
	}
	public void itsasontziaJarri(String pOntzi, int pX, int pY, char pNorabidea) {
		// TODO Auto-generated method stub
		Itsasontzia itsasontzia = ItsasontziFactory.getItsasontziFactory().createItsasontzia(pOntzi);
		itsasontzia = mapa.itsasontziaJarri(izena, itsasontzia, pX, pY, pNorabidea);
		nireItsasontziak[jarritakoItsasontziak]=itsasontzia;
		jarritakoItsasontziak++;
	}
	public boolean izenHauDu(String pJ) {
		// TODO Auto-generated method stub
		return pJ==izena;
	}
	public void objektuaKendu(String pObjektua) {
		// TODO Auto-generated method stub
		
	}
}
