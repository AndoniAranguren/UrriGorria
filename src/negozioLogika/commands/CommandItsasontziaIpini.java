package negozioLogika.commands;

import negozioLogika.ItsasontziFactory;
import negozioLogika.Partida;

public class CommandItsasontziaIpini extends Commands {
	private String[] ontzia;
	private int koordX, koordY;
	private char norabidea;
	
	public CommandItsasontziaIpini(String pJ, String pOntzi, int pX, int pY, char pNorabidea){
		//Datuak gorde----------
		super.exekutatu();
		ontzia[0]=pOntzi;
		koordX=pX;
		koordY=pY;
		norabidea=pNorabidea;
		//----------------------
	}
	
	public void exekutatu(){
		if(konprobatu()){
			Partida.jokalariariObjektuakEman(jokalaria, ontzia, false);
			Partida.itsasontziaJarri(jokalaria, ontzia[0], koordX, koordY, norabidea, true);
		}
	}
	public void deuseztatu(){
		Partida.jokalariariObjektuakEman(jokalaria, ontzia, true);
		Partida.itsasontziaJarri(jokalaria, ontzia[0], koordX, koordY, norabidea, false);
	}
	private boolean konprobatu(){
		int luzeera = ItsasontziFactory.getItsasontziFactory().luzeeraLortu(ontzia[0]);
		return Partida.kokatuDaiteke(koordX, koordY, luzeera, norabidea,jokalaria);
	}
}
