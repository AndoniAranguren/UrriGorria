package negozioLogika;

import java.util.ArrayList;

import negozioLogika.commands.Commands;

public class Battelog {
	//Atributuak
	private static Battelog neureBurua;
	ArrayList<Commands> komandoZerrenda= new ArrayList<Commands>(); //GERO DATU BASERA MUGITU
	
	//Eraikitzailea
	public Battelog(){
		neureBurua=null;
	}
	public static Battelog BattlelogaLortu(){
		if(neureBurua == null){
			neureBurua = new Battelog();
		}return neureBurua;
	}
	public void CommandSartu(Commands k){
		komandoZerrenda.add(k);
	}
}
