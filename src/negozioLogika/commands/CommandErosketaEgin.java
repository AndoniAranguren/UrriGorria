package negozioLogika.commands;

import negozioLogika.Objektuak;
import negozioLogika.Partida;

import java.util.ArrayList;

import negozioLogika.Erosketa;

public class CommandErosketaEgin extends Commands {
	Erosketa erosketa;
	ArrayList<Objektuak> objektuak=null;
	int prezioa=0;
	
	public CommandErosketaEgin(String pJ, Erosketa pErosketa){
		//Datuak gorde----------
		super();
		erosketa=pErosketa;
		objektuak=Partida.dendakIzakinakDitu(jokalaria,erosketa);
		prezioa=pErosketa.getPrezioa();
		//----------------------
		super.exekutatu();
	}
	protected void egikaritu(boolean pZer){
		Partida.jokalariariDiruaEman(jokalaria, prezioa, !pZer);
		Partida.dendariObjektuakEman(jokalaria, objektuak, !pZer);
		Partida.jokalariariObjektuakEman(jokalaria, objektuak, pZer);
		Partida.getPartida().faseaAldatu(pZer);
		super.komandoaGorde(pZer);
	}
	
	protected boolean konprobatu(){
		return (objektuak!=null&&Partida.jokalariakDiruaDu(jokalaria,prezioa));
	}
	
	public String info(){
		String info=super.info();
		return info.concat("CommandErosketaEgin'" +erosketa.getIzena());
	}
}