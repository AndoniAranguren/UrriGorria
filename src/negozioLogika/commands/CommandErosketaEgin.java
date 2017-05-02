package negozioLogika.commands;

import negozioLogika.Objektuak;
import negozioLogika.Partida;

public class CommandErosketaEgin extends Commands {
	String erosketa;
	Objektuak[] objektuak=null;
	int prezioa=0;
	
	public CommandErosketaEgin(String pJ, String pErosketa){
		//Datuak gorde----------
		super.exekutatu();
		objektuak=Partida.dendakIzakinakDitu(jokalaria,erosketa);
		prezioa=Partida.jokalariakDiruaDu(jokalaria,erosketa);
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
		return (objektuak!=null&&prezioa>=0);
	}
}