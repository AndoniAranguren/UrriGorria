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
		listaErosketak.add(eros.createErosketa("Misilx5"));
		listaErosketak.add(eros.createErosketa("Misil Zuzendua"));
		listaErosketak.add(eros.createErosketa("Misil Zuzendua Pro"));
		listaErosketak.add(eros.createErosketa("Radarra"));
		listaErosketak.add(eros.createErosketa("Fragata"));
		listaErosketak.add(eros.createErosketa("Itsaspekoa"));
		listaErosketak.add(eros.createErosketa("Suntsitzailea"));
		listaErosketak.add(eros.createErosketa("HegazkinOntzia"));
		listaErosketak.add(eros.createErosketa("Itsasontzi Guztiak"));
	}
	private void stockaErreseteatu(){
		listaStock.clear();
		ObjektuakFactory ob=ObjektuakFactory.getObjektuakFactory();
		listaStock.add(ob.createObjektua("Bomba", 50));
		listaStock.add(ob.createObjektua("Misil", 20));
		listaStock.add(ob.createObjektua("Misil Zuzendua", 5));
		listaStock.add(ob.createObjektua("Misil Zuzendua Pro", 2));
		listaStock.add(ob.createObjektua("Radarra",5));
		listaStock.add(ob.createObjektua("Fragata", 4));
		listaStock.add(ob.createObjektua("Suntsitzailea", 3));
		listaStock.add(ob.createObjektua("Itsaspekoa", 2));
		listaStock.add(ob.createObjektua("HegazkinOntzia", 1));
	}
	public ArrayList<Objektuak> dendakIzakinakDitu(Erosketa pErosketa) {
		if(zenbatErosiAhal(pErosketa)>0)
			return pErosketa.getObjektuak();
		else
			return null;
	}
	public void objektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer) {
		Objektuak objektua;
		int pos;
		for (Objektuak objektuBakoitza : pObjektuak) {
			pos=objektuarenPosLortu(objektuBakoitza);
			if(pos!=-1){
				objektua=listaStock.get(pos);
				objektua.gehitu(objektuBakoitza.getKopurua(),pZer);
				listaStock.set(pos, objektua);
			}
		}
	}
	private int objektuarenPosLortu(Objektuak pObj){
		return objektuarenPosLortu(pObj.getIzena());
	}
	private int objektuarenPosLortu(String pObj){
		boolean aurkituta=false;
		int ind=0;
		Iterator<Objektuak> it=listaStock.iterator();
		while(!aurkituta&&it.hasNext()){
			if(it.next().izenBerdina(pObj)) aurkituta=true;
			else ind++;
		}
		if(!aurkituta){
			ind=-1;
		}
		return ind;
	}
	public ArrayList<String> dendaEman() {
		ArrayList<String> list=new ArrayList<String>();
		for (Erosketa ob : listaErosketak) {
			list.add(ob.getIzena() + ": " + zenbatErosiAhal(ob)+ " ("+ob.getPrezioa()+"€)");
		}
		return list;
	}
	private int zenbatErosiAhal(Erosketa pErosketa) {
		int kopHandiena=99,pos;
		boolean izakinakDitu=true;
		Iterator<Objektuak> it=pErosketa.getIterator();
		Objektuak stockObj =null,erosObj;
		
		while(it.hasNext()&&izakinakDitu){
			erosObj=it.next();
			pos=objektuarenPosLortu(erosObj);
			if(pos!=-1){
				stockObj=listaStock.get(pos);
				
				if((erosObj.getKopurua())==0){//infinitu aldiz erosi ahal duzu hau
				}else if(erosObj.getKopurua()<=stockObj.getKopurua()){
					if(kopHandiena>stockObj.getKopurua()/(erosObj.getKopurua()))
							kopHandiena=stockObj.getKopurua()/(erosObj.getKopurua());
				}else {
					izakinakDitu=false; 
				}
			}
		}
		if(izakinakDitu)
			kopHandiena=(kopHandiena>99? 99 : kopHandiena);
		else 
			kopHandiena=0;
		return kopHandiena;
	}
}
