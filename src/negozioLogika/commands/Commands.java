package negozioLogika.commands;

import negozioLogika.Partida;

public abstract class Commands {
	private int[] egoera= new int[2];
	public void exekutatu(){
		egoera=Partida.egoeraLortu();
		//txanda=egoera[0];
		//fasea=egoera[1];
		//iraupena=egoera[2];
	}
	public int[] egoeraLortu(){
		return egoera;
	}
}
