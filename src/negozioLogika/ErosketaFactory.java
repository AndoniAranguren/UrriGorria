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
		else if(pMota.equals("Bombax10")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Bomba",10);
			lista.add(o);
			prezioa=800;
		}
		else if(pMota.equals("Misil")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil"); 
			lista.add(o);
			prezioa=200;
		}
		else if(pMota.equals("Misilx5")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil",5);
			lista.add(o);
			prezioa=400;
		}
		else if (pMota.equals("Misil Zuzendua")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil Zuzendua"); 
			lista.add(o);
			prezioa=300;
			
		}
		else if (pMota.equals("Misil Zuz. Pro")){
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil Zuz. Pro"); 
			lista.add(o);
			prezioa=300;
		}
		else if (pMota.equals("Ezkutua")) {
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Ezkutua"); 
			lista.add(o);
			prezioa=300;
		}
		else if (pMota.equals("Radarra")) {
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Radarra"); 
			lista.add(o);
			prezioa=200;
		}
		else if (pMota.equals("DFragata")){ 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Fragata"); 
			lista.add(o);
			prezioa=100;
		}
		else if (pMota.equals("DItsaspekoa")) { 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspekoa"); 
			lista.add(o);
			prezioa=150;
		}
		else if (pMota.equals("DSuntsitzailea")) { 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("Suntsitzailea"); 
			lista.add(o);
			prezioa=175;
		}
		else if (pMota.equals("DHegazkinOntzia")) { 
			o = ObjektuakFactory.getObjektuakFactory().createObjektua("HegazkinOntzia"); 
			lista.add(o);
			prezioa=250;
		}
		return (new Erosketa(prezioa, pMota, lista));
	}
}
