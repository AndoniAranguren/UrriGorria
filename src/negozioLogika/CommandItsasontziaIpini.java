package negozioLogika;

public class CommandItsasontziaIpini extends Commands {
	Jokalaria jokalari;
	Itsasontzia ontzia;
	int koordX, koordY;
	char norabidea;
	
	public void exekutatu(Jokalaria pJ, Itsasontzia pOntzi, int pX, int pY, char pNorabidea){
		jokalari=pJ;
		ontzia=pOntzi;
		koordX=pX;
		koordY=pY;
		norabidea=pNorabidea;
		if(konprobatu()){
			Kontsola.komandoaLortu("CommandObjetuaKendu").exekutatu(jokalari,ontzia);
			jokalari.itsasontziaJarri(pOntzi, int pX, int pY, char pNorabidea)
		}
	}
	private boolean konprobatu(){
		return jokalari.kokatuDaiteke(x, y, luzera, norabidea);
		
	}
	
	private void mugituNorabidera(int pX, int pY, char pNorabidea){
		switch (pNorabidea){
		case 'N': pY++; break;
		case 'E': pX++; break;
		case 'S': pY--; break;
		case 'W': pX--; break;
		default: break;
		}
	}
}
