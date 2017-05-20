package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Inbentarioa {//jokalari bakoitzak eta dendak inbentario bat izango dute
	
	private ArrayList<Objektuak> objektuak;
	
	public Inbentarioa(){
		objektuak= new ArrayList<Objektuak>();
		stockaErreseteatu();
	}
	private void stockaErreseteatu(){
		objektuak.clear();
		ObjektuakFactory ob=ObjektuakFactory.getObjektuakFactory();
		objektuak.addAll(ob.objektuGuztiak(true));
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
			list.add(ob.getFasea()+":"+ob.getIzena() + ": " + ob.getKopurua());
		}
		return list;
	}

	public void objektuaErabili(String pNori, String[] pInfo){
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
	public int lenght(){
		return objektuak.size();
	}
	public Objektuak get(int pX){
		return objektuak.get(pX);
	}
	public ArrayList<Itsasontzia> itsasontziakLortu() {
		ArrayList<Itsasontzia> lista= new ArrayList<Itsasontzia>();
		for(Objektuak its: objektuak)
			if(its.itsasontziaDa()&& its.getKopurua()>0) lista.add((Itsasontzia)its);
		return lista;
	}
	public boolean itsasontziGuztiakIpinita(){
		for(Itsasontzia its: itsasontziakLortu()){
			if(its.getKopurua()>0) return false;
		}
		return true;
	}
	public ArrayList<Objektuak> getObjektuak() {
		return objektuak;
	}
}
