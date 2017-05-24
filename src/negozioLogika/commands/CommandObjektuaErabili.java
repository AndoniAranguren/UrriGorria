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
		norabidea=pNorabide;
		//----------------------
		super.exekutatu();
	}
	public void egikaritu(boolean pZer){
		if(objektuak.get(0).itsasontziaDa()) {
			if(pZer){
				new CommandItsasontziaIpini(nori,(Itsasontzia)objektuak.get(0), koordX, koordY, norabidea);
			}else
				Partida.getPartida().komandoaAtzera(1);
		}else{
			objektuak.get(0).behinErabili(pZer);
			Partida.jokalariariErasotu(jokalaria, nori, objektuak.get(0), koordX, koordY, norabidea, pZer);
			super.komandoaGorde(pZer);
			Partida.getPartida().faseaAldatu(pZer);}
	}
	
	protected boolean konprobatu(){
		return (Partida.jokalariakObjektuakNahikoakDitu(jokalaria, objektuak) && Partida.jokalariaBizirikDago(nori)
				&&fasea==objektuak.get(0).getFasea());
	}
	public String info(){
		String info=super.info();
		return info.concat("CommandObjektuaErabili'"+objektuak.get(0).getIzena());
	}
}