package negozioLogika;

import java.util.ArrayList;

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
		}else komandoZerrenda.remove(pK);
	}
	public void egoeraraBueltatu(int[] pEgoera){
		//txanda=egoera[0];
		//fasea=egoera[1];
		//iraupena=egoera[2];
		int ind=komandoZerrenda.size()-1;
		while(pEgoera!=komandoZerrenda.get(ind).egoeraLortu()){
			komandoZerrenda.get(ind).deuseztatu();
			ind--;
		}
		
	}
}
