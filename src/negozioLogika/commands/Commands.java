package negozioLogika.commands;

import negozioLogika.Partida;

public abstract class Commands {
	private int[] egoera= new int[2];
	protected String jokalaria;
	public Commands(){
		egoera=Partida.egoeraLortu();
		//txanda=egoera[0];
		//fasea=egoera[1];
		//iraupena=egoera[2];
		jokalaria=Partida.norenTxandaDa();
	}
	public void exekutatu(){
	}
	public int[] egoeraLortu(){
		return egoera;
	}
}
