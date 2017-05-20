package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

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
		listaErosketak.add(eros.createErosketa("Bombax10"));
		listaErosketak.add(eros.createErosketa("Misil"));
		listaErosketak.add(eros.createErosketa("Misilx5"));
		listaErosketak.add(eros.createErosketa("MisilZuzendua"));
		listaErosketak.add(eros.createErosketa("MisilZuz.Pro"));
		listaErosketak.add(eros.createErosketa("Radarra"));
		listaErosketak.add(eros.createErosketa("Ezkutua"));
		listaErosketak.add(eros.createErosketa("Konponketa"));
	}
	private void stockaErreseteatu(){
		listaStock.clear();
		ObjektuakFactory ob=ObjektuakFactory.getObjektuakFactory();
		listaStock.addAll(ob.objektuGuztiak(false));
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
	public Erosketa erosketaBatLortu(int pFase, int pDiru){
		boolean aurkituta=false,erosiAhalDa;
		int ind=0;
		Erosketa erosketa=null;
		Iterator<Erosketa> it=listaErosketak.iterator();
		while(!aurkituta&&it.hasNext()){
			erosketa=it.next();
			if(erosketa.fasekoObjektuBatDu(pFase)&&erosketa.diruNahikoaDu(pDiru)){	//erosketa aurkitu da
				if(dendakIzakinakDitu(erosketa)!=null)aurkituta=true;				//stocka du
			}
		}
		int pos=Partida.getPartida().nextInt(listaErosketak.size());
		while(pos>0){
			if(it.hasNext())it=listaErosketak.iterator();
			erosketa=it.next();
			if(erosketa.fasekoObjektuBatDu(pFase)&&erosketa.diruNahikoaDu(pDiru)){	//erosketa aurkitu da
				if(pos>0)pos--;
			}
		}
		if(pos>0)erosketa=null;
		return erosketa;
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
			if(!(ob.getIzena().charAt(0)=='D'))
				list.add(ob.getIzena() + ": " + zenbatErosiAhal(ob)+ " ("+ob.getPrezioa()+"€");
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
				if((erosObj.getKopurua())<0){//infinitu aldiz erosi ahal duzu hau
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
