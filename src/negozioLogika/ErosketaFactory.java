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
		Objektuak o;
		if(pMota.equals("ErosketaBomba")){ 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Bomba"); 
			lista.add(o);
			prezioa=100;
		}
		else if(pMota.equals("Misil")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil"); 
			lista.add(o);
			prezioa=200;
		}
		else if (pMota.equals("Misil Zuzendua")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil Zuzendua"); 
			lista.add(o);
			prezioa=300;
			
		}
		else if (pMota.equals("Misil Zuzendua Pro")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil Zuzendua Pro"); 
			lista.add(o);
			prezioa=300;
		}
		else if (pMota.equals("Radarra")) {
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Radarra"); 
			lista.add(o);
			prezioa=200;
		}
		else if (pMota.equals("Fragata")){ 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Fragata"); 
			lista.add(o);
			prezioa=100;
		}
		else if (pMota.equals("Itsaspekoa")) { 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspekoa"); 
			lista.add(o);
			prezioa=150;
		}
		else if (pMota.equals("Suntsitzailea")) { 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Suntsitzailea"); 
			lista.add(o);
			prezioa=175;
		}
		else if (pMota.equals("HegazkinOntzia")) { 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("HegazkinOntzia"); 
			lista.add(o);
			prezioa=250;
		}
		else if (pMota.equals("Itsasontzi Guztiak")){
			//1
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("HegazkinOntzia"); 
			lista.add(o);
			//2
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspekoa"); 
			for(int i=0;i<2;i++) 	lista.add(o); 
			//3
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Suntsitzailea"); 
			for(int i=0;i<3;i++) 	lista.add(o);
			//4
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Fragata"); 
			for(int i=0;i<4;i++)	lista.add(o);
			prezioa=1200;
		}
		else if(pMota.equals("x5Bomba")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Bomba"); 
			for(int i=0;i<5;i++){
				lista.add(o);}
			prezioa=400;
		}
		return (new Erosketa(prezioa, pMota, lista));
	}
}
