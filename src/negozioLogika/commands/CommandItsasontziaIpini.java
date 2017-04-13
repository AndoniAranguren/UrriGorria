package negozioLogika.commands;

import negozioLogika.ItsasontziFactory;
import negozioLogika.Itsasontzia;
import negozioLogika.Partida;

public class CommandItsasontziaIpini extends Commands {
	private Itsasontzia ontzia;
	private int koordX, koordY;
	private char norabidea;
	
	public CommandItsasontziaIpini(String pJ, String pOntzi, int pX, int pY, char pNorabidea){
		//Datuak gorde----------
		super.exekutatu();
		ontzia=ItsasontziFactory.getItsasontziFactory().createItsasontzia(pOntzi);
		koordX=pX;
		koordY=pY;
		norabidea=pNorabidea;
		//----------------------
	}
	
	public void exekutatu(){
		if(konprobatu()){
			Itsasontzia[] ob= new Itsasontzia[0];
			ob[0]=ontzia;
			Partida.jokalariariObjektuakEman(jokalaria, ob, false);
			ontzia = Partida.itsasontziaJarri(jokalaria, ontzia, koordX, koordY, norabidea, true);
		}
	}
	public void deuseztatu(){
		Itsasontzia[] ob= new Itsasontzia[0];
		ob[0]=ontzia;
		Partida.jokalariariObjektuakEman(jokalaria, ob, true);
		Partida.itsasontziaJarri(jokalaria, ontzia, koordX, koordY, norabidea, false);
	}
	private boolean konprobatu(){
		return Partida.kokatuDaiteke(jokalaria, koordX, koordY, norabidea, ontzia.luzeera());
	}
}
