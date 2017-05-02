package negozioLogika;
<<<<<<< HEAD
import negozioLogika.commands.CommandErosketaEgin;
import java.util.ArrayList;
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
	public void erosketaExekutatu(String pNork){
		new CommandErosketaEgin(pNork,this).exekutatu();
	}
	public ArrayList<Objektuak> getObjektuak() {
		// TODO Auto-generated method stub
		return erosketak;
=======
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
>>>>>>> branch 'master' of https://github.com/Kaskagues/UrriGorria
	}
}
