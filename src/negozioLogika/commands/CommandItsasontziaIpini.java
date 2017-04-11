package negozioLogika.commands;

import negozioLogika.ItsasontziFactory;
import negozioLogika.Partida;

public class CommandItsasontziaIpini extends Commands {
	String jokalari;
	String ontzia;
	int koordX, koordY;
	char norabidea;
	
	public void exekutatu(String pJ, String pOntzi, int pX, int pY, char pNorabidea){
		if(konprobatu()){
			CommandObjetuaKendu k = new CommandObjetuaKendu();
			k.exekutatu(jokalari, ontzia);
			Partida.itsasontziaJarri(pOntzi, pX, pY, pNorabidea,jokalari);
		}
	}
	private boolean konprobatu(){
		int luzeera = ItsasontziFactory.getItsasontziFactory().createItsasontzia(ontzia).luzeera;
		return Partida.kokatuDaiteke(koordX, koordY, luzeera, norabidea,jokalari);
	}
}
