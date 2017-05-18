package negozioLogika.commands;

import java.util.ArrayList;

import negozioLogika.Itsasontzia;
import negozioLogika.Objektuak;
import negozioLogika.Partida;

public class CommandItsasontziaIpini extends Commands {
	private ArrayList<Objektuak> ontzia= new ArrayList<Objektuak>();
	private Itsasontzia jarritakoOntzia;
	private int koordX, koordY;
	private char norabidea;
	private String nori;
	
	public CommandItsasontziaIpini(String pJ, Itsasontzia pItsasontzia, int pX, int pY, char pNorabidea){
		//Datuak gorde----------
		super();
		nori = pJ;
		ontzia.add(pItsasontzia);
		jarritakoOntzia=pItsasontzia;
		koordX=pX;
		koordY=pY;
		norabidea=pNorabidea;
		//----------------------
		super.exekutatu();
	}
	

	protected void egikaritu(boolean pZer) {
		ontzia.get(0).behinErabili(pZer);
		jarritakoOntzia=Partida.itsasontziaJarri(nori, (Itsasontzia) jarritakoOntzia, koordX, koordY, norabidea, pZer);
		super.komandoaGorde(pZer);
	}
	protected boolean konprobatu(){
		return (Partida.kokatuDaiteke(nori, koordX, koordY, norabidea, ((Itsasontzia) ontzia.get(0)).luzeera())
				&& Partida.jokalariakObjektuakNahikoakDitu(jokalaria, ontzia)
				&& nori.equals(jokalaria));
	}
	public String info(){
		String info=super.info();
		return info.concat("CommandItsasontziaIpini'"+ontzia.get(0).getIzena());
	}
}
