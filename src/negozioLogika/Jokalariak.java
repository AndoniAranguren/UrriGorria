package negozioLogika;

public abstract class Jokalariak {
	Mapa mapa;
	Inbentario inb;
	String fasea;
	int dirua;
	Itsasontzia[] nireItsasontziak;
	
	public Jokalariak(){
		fasea="Iniziala";
	}
	public boolean kokatuDaiteke(int x, int y, int luzera, String norabidea){
		return mapa.kokatuDaiteke(x, y, luzera, norabidea);
	}
}
