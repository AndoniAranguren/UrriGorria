package negozioLogika;
public class ObjektuakFactory {

	private static ObjektuakFactory nObjektuakFactory = null;
	private ObjektuakFactory(){}
	public static ObjektuakFactory getObjektuakFactory(){
		if(nObjektuakFactory==null){ nObjektuakFactory = new ObjektuakFactory();}
		return nObjektuakFactory;
	}
	public Objektuak createObjektua(String mota){
		Objektuak i=null;
		if (mota=="Bomba"){ i = new Bomba(mota);}
		if (mota=="Radarra") {i = new Radarra(mota);}

		return i;
	}
}