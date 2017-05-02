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
		Objektuak i=null;
		//Armak--------------------------------
		if (pMota=="Bomba"){i = new Armak(						"Bomba",100,new ErasoSinple());}		
		else if (pMota=="Misil"){i = new Armak(					"Misil",200,new ErasoSinple());}
		else if (pMota=="Misil Zuzendua"){i = new Armak(		"Misil Zuzendua",100,new ErasoLineal());}
		else if (pMota=="Misil Zuzendua Pro"){i = new Armak(	"Misil Zuzendua Pro",100,new ErasoBikoitza());}
		
		//Ekipo--------------------------------
		else if (pMota=="Radarra") {i = new Ekipoak(			"Radarra", new ErabiliRadarra());}
		else if (pMota=="Eskutua") {i = new Ekipoak(			"Eskutua", new ErabiliRadarra());}
		
		//Itsasontziak-------------------------
		if (pMota=="Fragata"){ i = new Itsasontzia(				"Fragata",1,100);}
		else if (pMota=="Itsapekoa") {i = new Itsasontzia(		"Itsapekoa",2,200);}
		else if (pMota=="Suntsitzailea") {i = new Itsasontzia(	"Suntsitzailea",3,300);}
		else if (pMota=="HegazkinOntzia") { i = new Itsasontzia("HegazkinOntzia",4,400);}
		return i;
	}
}