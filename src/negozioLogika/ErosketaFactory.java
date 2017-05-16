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
		if(pMota.equals("Bomba")){ 
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
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("HegazkinOntzia"); 
			lista.add(o);
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspekoa",2); 
			lista.add(o); 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Suntsitzailea",3); 
			lista.add(o);
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Fragata",4);
			lista.add(o);
			prezioa=1200;
		}
		else if(pMota.equals("Misilx5")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil",5); 
			prezioa=400;
		}
		return (new Erosketa(prezioa, pMota, lista));
	}
}
