package negozioLogika.commands;

import negozioLogika.Partida;

import java.util.ArrayList;

import negozioLogika.Itsasontzia;
import negozioLogika.Objektuak;

public class CommandObjektuaErabili extends Commands {
	
	private String nori;
	private ArrayList<Objektuak> objektuak=new ArrayList<Objektuak>();
	private int koordX, koordY;
	private char norabidea;
	
	public CommandObjektuaErabili(String pJ, Objektuak pObjektuak, int pX, int pY, char pNorabide){
		//Datuak gorde----------
		super();
		nori=pJ;
		objektuak.add(pObjektuak);
		koordX=pX;
		koordY=pY;
		//----------------------
	}
	public void exekutatu(){
		if(konprobatu()){
			Partida.jokalariariObjektuakEman(jokalaria, objektuak, false);
			if(objektuak.get(0) instanceof Itsasontzia) objektuak.get(0).erabili(nori, koordX, koordY, norabidea);
			else Partida.jokalariariErasotu(jokalaria, nori, objektuak.get(0), koordX, koordY, norabidea, true);
			super.komandoaGorde(true);
		}
	}
	
	public void deuseztatu(){
		Partida.jokalariariObjektuakEman(jokalaria, objektuak, true);
		Partida.jokalariariErasotu(jokalaria,nori,objektuak.get(0),koordX,koordY,norabidea,false);
		super.komandoaGorde(false);
	}
	private boolean konprobatu(){
		return (Partida.jokalariakObjektuakDitu(jokalaria, objektuak) && Partida.jokalariaBizirikDago(nori));
	}
	public String info(){
		String info=super.info();
		return info.concat("CommandObjektuaErabili ("+objektuak.get(0)+")");
	}
}