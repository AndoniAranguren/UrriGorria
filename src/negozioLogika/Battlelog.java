package negozioLogika;

import java.util.ArrayList;

import negozioLogika.commands.Commands;

public class Battlelog {
	//Atributuak
	private static Battlelog neureBurua;
	private ArrayList<Commands> komandoZerrenda= new ArrayList<Commands>(); //GERO DATU BASERA MUGITU
	
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
	public ArrayList<String> logaEman() {
		ArrayList<String> loga= new ArrayList<String>();
		for (Commands komandoa : komandoZerrenda) {
			loga.add(komandoa.info());
		}
		return loga;
	}
	public void komandoaAtzera(int pZenbat) {
		Partida.getPartida().setCpuAktibatu(false);
		String norenTxandaZen=Partida.getPartida().norenTxandaDaIzena();
		for(int i=0;i<pZenbat;i++){
			komandoaAtzera();
		}
		while(!norenTxandaZen.equals(Partida.getPartida().norenTxandaDaIzena())) 
			komandoaAtzera();
		Partida.getPartida().setCpuAktibatu(true);
	}
}
