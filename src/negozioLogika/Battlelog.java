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
		}else komandoZerrenda.remove(komandoZerrenda.size()-1);
	}
	public void komandoaAtzera(){
		if(komandoZerrenda.size()>0){
			komandoZerrenda.get(komandoZerrenda.size()-1).deuseztatu();
		}
	}
	public void turnoraBueltatu(int pTurno){
		//txanda=egoera[0];
		//fasea=egoera[1];
		//iraupena=egoera[2];

	}
	public ArrayList<String> logaEman() {
		ArrayList<String> loga= new ArrayList<String>();
		for (Commands komandoa : komandoZerrenda) {
			loga.add(komandoa.info());
		}
		return loga;
	}
	public void komandoaAtzera(String[] pInfo) {
		int ind=komandoZerrenda.size()-1;
		String[] infoC= new String[3];
		boolean aurkituGabe=true;
		while(aurkituGabe){
			komandoZerrenda.get(ind).getInfo();
			aurkituGabe=(pInfo[0].equals(infoC[0])&&
						pInfo[1].equals(infoC[1])&&
						pInfo[2].equals(infoC[2]));
			komandoaAtzera();
		}
	}
}
