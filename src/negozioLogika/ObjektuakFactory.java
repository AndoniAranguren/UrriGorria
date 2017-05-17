package negozioLogika;

import strategyak.ErabiliRadarra;
import strategyak.ErasoBikoitza;
import strategyak.ErasoLineal;
import strategyak.ErasoSinple;

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
		else if (pMota.equals("Misil Zuzendua")){i = new Armak(		"Misil Zuzendua",pKop,100,new ErasoLineal());}
		else if (pMota.equals("Misil Zuz. Pro")){i = new Armak(	"Misil Zuz. Pro",pKop,100,new ErasoBikoitza());}
		
		//Ekipo--------------------------------
		else if (pMota.equals("Radarra")) {i = new Ekipoak(			"Radarra",pKop, new ErabiliRadarra());}
		else if (pMota.equals("Eskutua")) {i = new Ekipoak(			"Eskutua",pKop, new ErabiliRadarra());}
		
		//Itsasontziak-------------------------
		else if (pMota.equals("Fragata")){ i = new Itsasontzia(				"Fragata",pKop,1,100);}
		else if (pMota.equals("Itsaspekoa")) {i = new Itsasontzia(		"Itsaspekoa",pKop,2,200);}
		else if (pMota.equals("Suntsitzailea")) {i = new Itsasontzia(	"Suntsitzailea",pKop,3,300);}
		else if (pMota.equals("HegazkinOntzia")) { i = new Itsasontzia("HegazkinOntzia",pKop,4,400);}
		return i;
	}
}