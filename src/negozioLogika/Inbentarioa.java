package negozioLogika;

import java.util.ArrayList;

public class Inbentarioa {//jokalari bakoitzak eta dendak inbentario bat izango dute
	
	private ArrayList<Objektuak> objektuak;

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
}
