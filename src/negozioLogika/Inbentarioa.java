package negozioLogika;

import java.util.ArrayList;

public class Inbentarioa {//jokalari bakoitzak eta dendak inbentario bat izango dute
	
	private ArrayList<Objektuak> objektuak;

	public void objektuakEman(String[] pObjektuak, boolean pZer){
		for (String objektuBakoitza : pObjektuak) {
			if(pZer){ 	this.objektuak.add(		ObjektuakFactory.getObjektuakFactory().createObjektua(objektuBakoitza));}
			else{		this.objektuak.remove(	ObjektuakFactory.getObjektuakFactory().createObjektua(objektuBakoitza));}
		}
	}

	public boolean objektuakDitu(String[] pObjektuak) {
		// TODO Auto-generated method stub
		boolean guztiakDitu=true;
		for (String objektuBakoitza : pObjektuak) {
			guztiakDitu= !this.objektuak.contains(	ObjektuakFactory.getObjektuakFactory().createObjektua(objektuBakoitza));
		}
		return guztiakDitu;
	}
}
