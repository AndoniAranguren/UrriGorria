package negozioLogika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Inbentarioa {//jokalari bakoitzak eta dendak inbentario bat izango dute
	
	private ArrayList<Objektuak> objektuak;
	
	public Inbentarioa(){
		objektuak= new ArrayList<Objektuak>();
	}
	
	public void objektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer){
		for (Objektuak objektuBakoitza : pObjektuak) {
			if(pZer){ 	this.objektuak.add(		objektuBakoitza);}
			else{		this.objektuak.remove(	objektuBakoitza);}
		}
	}

	public boolean objektuakDitu(ArrayList<Objektuak> pObjektuak) {		
		boolean daude=true;
		List<String> list= new ArrayList<String>(),listParametro = new ArrayList<String>();
		for (Objektuak ob : objektuak) {
			list.add(ob.getIzena());
		}
		for (Objektuak ob : pObjektuak) {
			listParametro.add(ob.getIzena());
		}
		Set<String> unique1= new HashSet<String>(list);
		for(String pO:unique1){
			daude=Collections.frequency(list, pO)>=Collections.frequency(listParametro, pO);
		}
		return daude;
	}

	public ArrayList<String> inbentarioaEman() {
		ArrayList<String> inb= new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		for (Objektuak ob : objektuak) {
			list.add(ob.getIzena());
		}
		Set<String> unique = new HashSet<String>(list);
		for (String key : unique) {
		    inb.add(key + ": " + Collections.frequency(list, key));
		}
		return inb;
	}
}
