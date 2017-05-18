package negozioLogika;

import java.util.ArrayList;

import strategyak.*;

public class ObjektuakFactory {

	private static ObjektuakFactory nObjektuakFactory = null;
	private ObjektuakFactory(){}
	public static ObjektuakFactory getObjektuakFactory(){
		if(nObjektuakFactory==null){ nObjektuakFactory = new ObjektuakFactory();}
		return nObjektuakFactory;
	}
	public Objektuak createObjektua(String pMota){
		return createObjektua(pMota,1);
	}
	public Objektuak createObjektua(String pMota,int pKop){
		Objektuak i=null;
		//Armak--------------------------------
		if (pMota.equals("Bomba")){i = new Armak(						"Bomba",pKop,100,new ErasoSinple());}		
		else if (pMota.equals("Misil")){i = new Armak(					"Misil",pKop,200,new ErasoSinple());}
		else if (pMota.equals("MisilZuzendua")){i = new Armak(		"MisilZuzendua",pKop,100,new ErasoLineal());}
		else if (pMota.equals("MisilZuz.Pro")){i = new Armak(	"MisilZuz.Pro",pKop,100,new ErasoBikoitza());}
		
		//Ekipo--------------------------------
		else if (pMota.equals("Radarra")) {i = new Ekipoak(			"Radarra",pKop, new ErabiliRadarra());}
		else if (pMota.equals("Ezkutua")) {i = new Ekipoak(			"Ezkutua",pKop, new ErabiliEzkutua());}
		
		//Itsasontziak-------------------------
		else if (pMota.equals("Fragata")){ i = new Itsasontzia(			"Fragata",pKop,1,100);}
		else if (pMota.equals("Suntsitzailea")) {i = new Itsasontzia(	"Suntsitzailea",pKop,2,200);}
		else if (pMota.equals("Itsaspekoa")) {i = new Itsasontzia(		"Itsaspekoa",pKop,3,300);}
		else if (pMota.equals("HegazkinOntzia")) { i = new Itsasontzia(	"HegazkinOntzia",pKop,4,400);}
		return i;
	}
	public ArrayList<Objektuak> objektuGuztiak(boolean pZ){//true=Jokalaria false=denda
		ArrayList<Objektuak> lista= new ArrayList<Objektuak>();
		Objektuak o;
		
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("Bomba",pZ?			50:100); 
		lista.add(o);
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("Misil",pZ?			10:40); 
		lista.add(o); 
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("MisilZuzendua",pZ?	1:4); 
		lista.add(o);
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("MisilZuz.Pro",pZ?	0:2); 
		lista.add(o);
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("Radarra",pZ?			4:10);
		lista.add(o);
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("Ezkutua",pZ?			3:4);
		lista.add(o);
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("HegazkinOntzia",pZ?	1:0); 
		lista.add(o);
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspekoa",pZ?		2:0); 
		lista.add(o); 
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("Suntsitzailea",pZ?	3:0); 
		lista.add(o);
		o = ObjektuakFactory.getObjektuakFactory().createObjektua("Fragata",pZ?			4:0);
		lista.add(o);
		
		return lista;
	}
}