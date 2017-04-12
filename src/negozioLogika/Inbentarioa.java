package negozioLogika;

import java.util.ArrayList;

public class Inbentarioa {//jokalari bakoitzak eta dendak inbentario bat izango dute
	
	private ArrayList<Objektuak> objektuak;

	public void objektuakEman(String[] pObjektua, boolean pZer){
		for (String objektuBakoitza : pObjektua) {
			if(pZer){ 	this.objektuak.add(		ObjektuakFactory.getObjektuakFactory().createObjektua(objektuBakoitza));}
			else{		this.objektuak.remove(	ObjektuakFactory.getObjektuakFactory().createObjektua(objektuBakoitza));}
		}
	}
}
