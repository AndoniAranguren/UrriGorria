package negozioLogika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import frontend.UrriGorriaUI;


public class Inbentarioa {//jokalari bakoitzak eta dendak inbentario bat izango dute
	
	private ArrayList<Objektuak> objektuak;
	
	public Inbentarioa(){
		objektuak= new ArrayList<Objektuak>();
		stockaErreseteatu();
	}
	private void stockaErreseteatu(){
		objektuak.clear();
		ObjektuakFactory ob=ObjektuakFactory.getObjektuakFactory();
		objektuak.add(ob.createObjektua("Bomba", 0));
		objektuak.add(ob.createObjektua("Misil", 0));
		objektuak.add(ob.createObjektua("Misil Zuzendua", 0));
		objektuak.add(ob.createObjektua("Misil Zuzendua Pro", 0));
		objektuak.add(ob.createObjektua("Radarra",0));
		objektuak.add(ob.createObjektua("Fragata", 0));
		objektuak.add(ob.createObjektua("Itsaspekoa", 0));
		objektuak.add(ob.createObjektua("Suntsitzailea", 0));
		objektuak.add(ob.createObjektua("HegazkinOntzia", 0));
	}
	
	public void objektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer){
		Objektuak objektua;
		int pos;
		for (Objektuak objektuBakoitza : pObjektuak) {
			pos=objektuarenPosLortu(objektuBakoitza);
			if(pos!=-1){
				objektua=objektuak.get(pos);
				objektua.gehitu(objektuBakoitza.getKopurua(),pZer);
				objektuak.set(pos, objektua);
			}
		}
	}

	public boolean objektuakNahikoakDitu(ArrayList<Objektuak> pObjektuak) {	
		Objektuak objektua;
		Iterator<Objektuak> it=pObjektuak.iterator();
		while(it.hasNext()){
			objektua=it.next();
			if(!objektuak.get(objektuarenPosLortu(objektua)) //Objektua bilatu eta gero konprobatu
					.kopuruNahikoa(objektua.getKopurua())) return false;
		}
		return true;
	}

	public ArrayList<String> inbentarioaEman() {
		ArrayList<String> list=new ArrayList<String>();
		for (Objektuak ob : objektuak) {
			list.add(ob.getIzena() + ": " + ob.getKopurua());
		}
		return list;
	}

	public void objektuaErabili(String pNori, String[] pInfo) {
		if(objektuaDu(pInfo[0])){
			int pos=objektuarenPosLortu(pInfo[0]);
			objektuak.get(pos).erabili(pNori, Integer.parseInt(pInfo[1]), Integer.parseInt(pInfo[2]), 
					pInfo[3].charAt(0));
		}
	}
	private boolean objektuaDu(String pIzena) {
		return (objektuarenPosLortu(pIzena)!=-1);
	}

	private int objektuarenPosLortu(String pObj){
		boolean aurkituta=false;
		int ind=0;
		Iterator<Objektuak> it=objektuak.iterator();
		while(!aurkituta&&it.hasNext()){
			if(it.next().izenBerdina(pObj)) aurkituta=true;
			else ind++;
		}
		if(!aurkituta){
			ind=-1;
		}
		return ind;
	}
	private int objektuarenPosLortu(Objektuak pObj){
		return objektuarenPosLortu(pObj.getIzena());
	}
}
