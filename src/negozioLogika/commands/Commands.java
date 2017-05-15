package negozioLogika.commands;

import negozioLogika.Partida;
import negozioLogika.Battlelog;

public abstract class Commands {
	
	private int[] egoera= new int[2];
	protected String jokalaria;
	
	public Commands(){
		egoera=Partida.egoeraLortu();
		//fasea=egoera[0];
		//txanda=egoera[1];
		//iraupena=egoera[2];
		jokalaria=Partida.norenTxandaDa();
	}
	
	public void exekutatu(){
		if(konprobatu()){
			egikaritu(true);
		}
	}
	public void deuseztatu(){
		egikaritu(false);
	}
	protected abstract boolean konprobatu();
	protected abstract void egikaritu(boolean b);

	public int[] egoeraLortu(){
		return egoera;
	}
	protected void komandoaGorde(boolean pZer){
		Battlelog.BattlelogaLortu().komandoaGorde(this,pZer);
	}

	public String info() {
		String info= new String();
		info=("("+egoera[2]+") "+jokalaria+":\n");
		return info;
	}
}
