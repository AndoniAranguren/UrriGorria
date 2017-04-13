package negozioLogika;

import java.util.ArrayList;

public class Inbentarioa {//jokalari bakoitzak eta dendak inbentario bat izango dute
	
	private ArrayList<Objektuak> objektuak;

	public void objektuakEman(Objektuak[] pObjektuak, boolean pZer){
		for (Objektuak objektuBakoitza : pObjektuak) {
			if(pZer){ 	this.objektuak.add(		objektuBakoitza);}
			else{		this.objektuak.remove(	objektuBakoitza);}
		}
	}

	public boolean objektuakDitu(Objektuak[] pObjektuak) {
		// TODO Auto-generated method stub
		boolean guztiakDitu=true;
		for (Objektuak objektuBakoitza : pObjektuak) {
			guztiakDitu= !this.objektuak.contains(	objektuBakoitza);
		}
		return guztiakDitu;
	}
}
