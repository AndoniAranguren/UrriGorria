package negozioLogika;

public class Jokalaria extends Jokalariak {
	private void intsasontziaIpini(){
		//getItsasontzia jokalaritik
		Kontsola.komandoaLortu("CommandItsasontziaIpini").exekutatu(this, pOntzi, pX, pY, pNorabidea);
	}
}
