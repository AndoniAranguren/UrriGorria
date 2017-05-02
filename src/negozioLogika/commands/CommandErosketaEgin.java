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
		super.exekutatu();
		objektuak=Partida.dendakIzakinakDitu(jokalaria,erosketa);
		prezioa=pErosketa.getPrezioa();
		//----------------------
	}
	
	public void exekutatu(String pErosketa){
		if(konprobatu()){
			Partida.jokalariariDiruaEman(jokalaria, prezioa, false);
			Partida.dendariObjektuakEman(jokalaria, objektuak, false);
			Partida.jokalariariObjektuakEman(jokalaria, objektuak, true);
			super.komandoaGorde(true);
		}
	}
		
	public void deuseztatu(){
		Partida.jokalariariDiruaEman(jokalaria, prezioa, true);
		Partida.dendariObjektuakEman(jokalaria, objektuak, true);
		Partida.jokalariariObjektuakEman(jokalaria, objektuak, false);
		super.komandoaGorde(false);
	}
	
	private boolean konprobatu(){
		return (objektuak!=null&&Partida.jokalariakDiruaDu(jokalaria,prezioa));
	}
}