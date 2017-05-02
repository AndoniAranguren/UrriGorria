package negozioLogika;
import negozioLogika.commands.*;
import java.util.ArrayList;

import negozioLogika.commands.Commands;

public class Erosketa {
	private ArrayList<Objektuak> erosketak;
	private int prezioa;
	private String mota;
	public Erosketa(int pPrezioa, String pMota, ArrayList<Objektuak> ob){
		prezioa=pPrezioa;
		mota=pMota;
		erosketak = ob;
	}
	public int getPrezioa(){
		return prezioa;
	}
	public void erosketaExekutatu(){
		CommandErosketaEgin c = new CommandErosketaEgin(Partida.getPartida().norenTxandaDa() ,mota);
		c.exekutatu();
	}
}
