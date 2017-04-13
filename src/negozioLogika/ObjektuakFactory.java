package negozioLogika;
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
		if (pMota=="Bomba"){i = new Armak(					"Bomba",100,new ErasoSinple());}		
		else if (pMota=="Misil"){i = new Armak(				"Misil",200,new ErasoSinple());}
		else if (pMota=="Misil Zuzendua"){i = new Armak(	"Misil Zuzendua",100,new ErasoLineal());}
		else if (pMota=="Misil Zuzendua Pro"){i = new Armak("Misil Zuzendua Pro",100,new ErasoBikoitza());}
		//-------------------------------------
		//Ekipo--------------------------------
		else if (pMota=="Radarra") {i = new Ekipoak(		"Radarra", new ErabiliRadarra());
		}
		//-------------------------------------
		return i;
	}
}