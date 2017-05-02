package negozioLogika;

import java.util.ArrayList;

public class ErosketaFactory {
	private static ErosketaFactory nErosketaFactory = null;
	private ErosketaFactory(){
	}
	public static synchronized ErosketaFactory getErosketaFactory(){
		if(nErosketaFactory==null){nErosketaFactory = new ErosketaFactory();}
		return nErosketaFactory;
	}
	public Erosketa createErosketa(String pMota){
		ArrayList<Objektuak> lista= new ArrayList<Objektuak>();
		int prezioa=0;
		if(pMota=="ErosketaBomba"){ 
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Bomba"); 
			lista.add(o);
			prezioa=prezioa+100;
							}
		else if(pMota=="Misila"){
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misila"); 
			lista.add(o);
			prezioa=prezioa+200;
		}
		else if (pMota=="Misil Zuzendua"){
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil Zuzendua"); 
			lista.add(o);
			prezioa=prezioa+300;
			
		}
		else if (pMota=="Misil Zuzendua Pro"){
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil Zuzendua Pro"); 
			lista.add(o);
			prezioa=prezioa+300;
		}
		else if (pMota=="Radarra") {
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Radarra"); 
			lista.add(o);
			prezioa=prezioa+200;
		}
		else if (pMota=="Fragata"){ 
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Fragata"); 
			lista.add(o);
			prezioa=prezioa+100;
		}
		else if (pMota=="Itsapekoa") { 
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspekoa"); 
			lista.add(o);
			prezioa=prezioa+150;
		}
		else if (pMota=="Suntsitzailea") { 
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Suntsitzailea"); 
			lista.add(o);
			prezioa=prezioa+175;
		}
		else if (pMota=="HegazkinOntzia") { 
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("HegazkinOntzia"); 
			lista.add(o);
			prezioa=prezioa+250;
		}
		else if (pMota=="Itsasontzi Guztiak"){
			//1
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("HegazkinOntzia"); 
			lista.add(o);
			//2
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspekoa"); 
			for(int i=0;i<2;i++){
				lista.add(o);}
			//3
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Suntsitzailea"); 
			for(int i=0;i<3;i++){
				lista.add(o);}
			//4
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Fragata"); 
			for(int i=0;i<4;i++){
				lista.add(o);}
			prezioa=prezioa+1200;
		}
		else if(pMota=="x5Bomba"){
			Objektuak o = ObjektuakFactory.getObjektuakFactory().createObjektua("Bomba"); 
			for(int i=0;i<5;i++){
				lista.add(o);}
		}
		Erosketa e=new Erosketa(prezioa, pMota, lista);
		return e;
	}
}
