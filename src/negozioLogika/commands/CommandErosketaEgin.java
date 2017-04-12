package negozioLogika.commands;

import negozioLogika.ItsasontziFactory;
import negozioLogika.Partida;

public class CommandErosketaEgin {
	String jokalari,erosketa;
	String[] objektuak=null;
	int prezioa=0;
	
	public void exekutatu(String pJ, String pErosketa){
		if(konprobatu()){
			Partida.jokalariariDiruaEman(jokalari, prezioa, false);
			Partida.dendariObjektuakEman(jokalari, objektuak, false);
			Partida.jokalariariObjektuakEman(jokalari, objektuak, true);
		}
	}
		
	public void deuseztatu(){
		Partida.jokalariariDiruaEman(jokalari, prezioa, true);
		Partida.dendariObjektuakEman(jokalari, objektuak, true);
		Partida.jokalariariObjektuakEman(jokalari, objektuak, false);
	}
	
	private boolean konprobatu(){
		objektuak=Partida.dendakIzakinakDitu(jokalari,erosketa);
		prezioa=Partida.jokalariakDiruaDu(jokalari, erosketa);
		return (objektuak!=null&&prezioa>=0);
	}
}