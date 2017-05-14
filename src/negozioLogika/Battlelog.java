package negozioLogika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import negozioLogika.commands.Commands;

public class Battlelog {
	//Atributuak
	private static Battlelog neureBurua;
	ArrayList<Commands> komandoZerrenda= new ArrayList<Commands>(); //GERO DATU BASERA MUGITU
	
	//Eraikitzailea
	public Battlelog(){
		neureBurua=null;
	}
	public static Battlelog BattlelogaLortu(){
		if(neureBurua == null){
			neureBurua = new Battlelog();
		}return neureBurua;
	}
	public void komandoaGorde(Commands pK, boolean pZer){
		if(pZer){
			komandoZerrenda.add(pK);
		}else komandoZerrenda.remove(komandoZerrenda.size()-1);
		System.out.println("Komando zerrenda luzeera:"+komandoZerrenda.size());
	}
	public void komandoaAtzera(){
		if(komandoZerrenda.size()>0){
			komandoZerrenda.get(komandoZerrenda.size()-1).deuseztatu();
		}
	}
	public void egoeraraBueltatu(int[] pEgoera){
		//txanda=egoera[0];
		//fasea=egoera[1];
		//iraupena=egoera[2];
		int ind=komandoZerrenda.size()-1;
		while(pEgoera!=komandoZerrenda.get(ind).egoeraLortu()){
			komandoaAtzera();
		}
		
	}
	public ArrayList<String> logaEman() {
		ArrayList<String> loga= new ArrayList<String>();
		for (Commands komandoa : komandoZerrenda) {
			loga.add(komandoa.info());
		}
		return loga;
	}
}
