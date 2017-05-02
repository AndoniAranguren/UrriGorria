package negozioLogika.commands;

import negozioLogika.Partida;
import negozioLogika.Itsasontzia;
import negozioLogika.Objektuak;

public class CommandObjektuaErabili extends Commands {
	
	private String nori;
	private Objektuak[] objektuak=new Objektuak[0];
	private int koordX, koordY;
	private char norabidea;
	
	public CommandObjektuaErabili(String pJ, Objektuak pObjektuak, int pX, int pY, char pNorabide){
		//Datuak gorde----------
		super();
		nori=pJ;
		objektuak[0]= pObjektuak;
		koordX=pX;
		koordY=pY;
		//----------------------
	}
	public void exekutatu(){
		if(konprobatu()){
			Partida.jokalariariObjektuakEman(jokalaria, objektuak, false);
			if(objektuak[0] instanceof Itsasontzia) objektuak[0].erabili(nori, koordX, koordY, norabidea);
			else Partida.jokalariariErasotu(jokalaria, nori, objektuak[0], koordX, koordY, norabidea, true);
			super.komandoaGorde(true);
		}
	}
	
	public void deuseztatu(){
		Partida.jokalariariObjektuakEman(jokalaria, objektuak, true);
		Partida.jokalariariErasotu(jokalaria,nori,objektuak[0],koordX,koordY,norabidea,false);
		super.komandoaGorde(false);
	}
	private boolean konprobatu(){
		return (Partida.jokalariakObjektuakDitu(jokalaria, objektuak) && Partida.jokalariaBizirikDago(nori));
	}
}