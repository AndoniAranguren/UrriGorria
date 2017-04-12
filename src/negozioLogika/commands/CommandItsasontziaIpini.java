package negozioLogika.commands;

import negozioLogika.ItsasontziFactory;
import negozioLogika.Partida;

public class CommandItsasontziaIpini extends Commands {
	String jokalari;
	String[] ontzia;
	int koordX, koordY;
	char norabidea;
	
	public void exekutatu(String pJ, String pOntzi, int pX, int pY, char pNorabidea){
		//datuak gorde
		jokalari=pJ;
		ontzia[0]=pOntzi;
		koordX=pX;
		koordY=pY;
		norabidea=pNorabidea;
		
		if(konprobatu()){
			Partida.jokalariariObjektuakEman(jokalari, ontzia, false);
			Partida.itsasontziaJarri(jokalari, ontzia[0], koordX, koordY, norabidea, true);
		}
	}
	public void deuseztatu(){
		Partida.jokalariariObjektuakEman(jokalari, ontzia, true);
		Partida.itsasontziaJarri(jokalari, ontzia[0], koordX, koordY, norabidea, false);
	}
	private boolean konprobatu(){
		int luzeera = ItsasontziFactory.getItsasontziFactory().luzeeraLortu(ontzia[0]);
		return Partida.kokatuDaiteke(koordX, koordY, luzeera, norabidea,jokalari);
	}
}
