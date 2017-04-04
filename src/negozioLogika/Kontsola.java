package negozioLogika;

import java.util.ArrayList;

public class Kontsola {
	//Atributuak
	private static Kontsola neureBurua;
	ArrayList<Commands> komandoZerrenda= new ArrayList<Commands>(); //GERO DATU BASERA MUGITU
	
	//Eraikitzailea
	public Kontsola(){
		neureBurua=null;
	}
	public static Kontsola kontsolaLortu(){
		if(neureBurua == null){
			neureBurua = new Kontsola();
		}return neureBurua;
	}
	public void CommandSartu(Commands k){
		komandoZerrenda.add(k);
	}
}
