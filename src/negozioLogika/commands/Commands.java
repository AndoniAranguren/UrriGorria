package negozioLogika.commands;

import negozioLogika.Partida;
import negozioLogika.Battlelog;

public abstract class Commands {
	
	protected int turnoa,fasea;
	protected String jokalaria;
	
	public Commands(){
		int[] egoera=Partida.getPartida().egoeraLortu();
		turnoa=egoera[2];
		fasea=egoera[0];
		//fasea=egoera[0];
		//txanda=egoera[1];
		//iraupena=egoera[2];
		jokalaria=Partida.getPartida().norenTxandaDaIzena();
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

	protected void komandoaGorde(boolean pZer){
		Battlelog.BattlelogaLortu().komandoaGorde(this,pZer);
	}

	public String info() {
		String info= new String();
		info=(turnoa+"'"+jokalaria+"'"+fasea+"-ç("+turnoa+") "+jokalaria+":<br>");
		return info;
	}

	public String[] getInfo() {
		String[] info= new String[3];
		info[0]=""+turnoa;
		info[1]=""+fasea;
		info[2]=jokalaria;
		return info;
	}
}
