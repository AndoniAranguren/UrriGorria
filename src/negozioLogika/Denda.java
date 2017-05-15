package negozioLogika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Denda {
	private ArrayList<Objektuak> listaStock= new ArrayList<Objektuak>();
	private ArrayList<Erosketa> listaErosketak= new  ArrayList<Erosketa>();
	public Denda(){
		erosketakHasieratu();
		stockaErreseteatu();
	}
	private void erosketakHasieratu(){
		listaErosketak.clear();
		ErosketaFactory eros=ErosketaFactory.getErosketaFactory();
		listaErosketak.add(eros.createErosketa("Bomba"));
		listaErosketak.add(eros.createErosketa("Misil"));
		listaErosketak.add(eros.createErosketa("Misil Zuzendua"));
		listaErosketak.add(eros.createErosketa("Misil Zuzendua Pro"));
		listaErosketak.add(eros.createErosketa("Radarra"));
		listaErosketak.add(eros.createErosketa("Fragata"));
		listaErosketak.add(eros.createErosketa("Itsaspekoa"));
		listaErosketak.add(eros.createErosketa("Suntsitzailea"));
		listaErosketak.add(eros.createErosketa("HegazkinOntzia"));
		listaErosketak.add(eros.createErosketa("Itsasontzi Guztiak"));
		listaErosketak.add(eros.createErosketa("x5Bomba"));
	}
	private void stockaErreseteatu(){
		listaStock.clear();
		gehituXAldiz("Bomba", 50);
		gehituXAldiz("Misil", 20);
		gehituXAldiz("Misil Zuzendua", 5);
		gehituXAldiz("Misil Zuzendua Pro", 2);
		gehituXAldiz("Radarra",5);
		gehituXAldiz("Fragata", 4);
		gehituXAldiz("Itsaspekoa", 3);
		gehituXAldiz("Suntsitzailea", 2);
		gehituXAldiz("HegazkinOntzia", 1);
	}
	public void dendaEguneratu(){
		
	}
	public ArrayList<Objektuak> dendakIzakinakDitu(Erosketa pErosketa) {
		ArrayList<Objektuak> ob = pErosketa.getObjektuak();
		ArrayList<Objektuak> aux= listaStock;
//		Objektuak azkenengoObj=ob.get(ob.size()-1);
//		boolean dauzka=true;
//		while(dauzka && ob.size()!=0){
//			azkenengoObj=ob.get(ob.size()-1);
//			if(aux.contains(azkenengoObj)){
//				aux.remove(azkenengoObj);
//				ob.remove(ob.size()-1);
//			}else dauzka=false;
//		}
//		if(dauzka){
//			listaStock=aux;
//			ob=pErosketa.getObjektuak();
//		}else ob=null;
		listaStock.contains(pErosketa.getObjektuak());
		return ob;
	}
	public void objektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer) {
		if(pZer){ listaStock.addAll(pObjektuak);
		}else listaStock.removeAll(pObjektuak);
		
	}
	private void gehituXAldiz(String pIzen,int pZ){
		Objektuak e=ObjektuakFactory.getObjektuakFactory().createObjektua(pIzen);
		for(int i=0;i<pZ;i++){listaStock.add(e);}
	}
	public Erosketa erosketaLortu(String pErosketa){
		int i = listaErosketak.indexOf(ErosketaFactory.getErosketaFactory().createErosketa(pErosketa));
		Erosketa eros= null;
		if(i!=-1){
			eros=listaErosketak.get(i);
		}
		return eros;
	}
	public ArrayList<String> dendaEman() {
		ArrayList<String> inb= new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		for (Erosketa ob : listaErosketak) {
			list.add(ob.getIzena());
		}
		Set<String> unique = new HashSet<String>(list);
		for (String key : unique) {
		    inb.add(key + ": " + Collections.frequency(list, key));
		}
		return inb;
	}
}
