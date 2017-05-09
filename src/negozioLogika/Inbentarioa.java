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
		// TODO Auto-generated method stub
		ArrayList<Objektuak> ob = pObjektuak, aux=objektuak;
		Objektuak azkenengoObj=ob.get(ob.size());
		boolean dauzka=true;
		while(dauzka && ob.size()!=0){
			azkenengoObj=ob.get(ob.size());
			if(aux.contains(azkenengoObj)){
				aux.remove(azkenengoObj);
				ob.remove(ob.size()-1);
			}else dauzka=false;
		}
		return dauzka;
	}

	public ArrayList<String> inbentarioaEman() {
		ArrayList<String> inb= new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		for (Objektuak ob : objektuak) {
			list.add(ob.izena);
		}
		Set<String> unique = new HashSet<String>(list);
		for (String key : unique) {
		    inb.add(key + ": " + Collections.frequency(list, key));
		    System.out.println(key + ": " + Collections.frequency(list, key));
		}
		return inb;
	}
}
