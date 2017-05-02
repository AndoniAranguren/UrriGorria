package negozioLogika.commands;

import negozioLogika.Itsasontzia;
import negozioLogika.Partida;

public class CommandItsasontziaIpini extends Commands {
	private Itsasontzia[] ontzia= new Itsasontzia[0];
	private int koordX, koordY;
	private char norabidea;
	
	public CommandItsasontziaIpini(String pJ, Itsasontzia pItsasontzia, int pX, int pY, char pNorabidea){
		//Datuak gorde----------
		super.exekutatu();
		ontzia[0]= pItsasontzia;
		koordX=pX;
		koordY=pY;
		norabidea=pNorabidea;
		//----------------------
	}
	
	public void exekutatu(){
		if(konprobatu()){
			Partida.jokalariariObjektuakEman(jokalaria, ontzia, false);
			ontzia[0] = Partida.itsasontziaJarri(jokalaria, ontzia[0], koordX, koordY, norabidea, true);
			super.komandoaGorde(true);
		}
	}
	public void deuseztatu(){
		Partida.jokalariariObjektuakEman(jokalaria, ontzia, true);
		Partida.itsasontziaJarri(jokalaria, ontzia[0], koordX, koordY, norabidea, false);
		super.komandoaGorde(false);
	}
	private boolean konprobatu(){
		return Partida.kokatuDaiteke(jokalaria, koordX, koordY, norabidea, ontzia[0].luzeera());
	}
}
