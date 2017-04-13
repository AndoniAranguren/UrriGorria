package negozioLogika;

public class ItsasontziFactory {
	private static ItsasontziFactory nItsasontziFactory = null;
	private ItsasontziFactory(){}
	public static ItsasontziFactory getItsasontziFactory(){
		if(nItsasontziFactory==null){ nItsasontziFactory = new ItsasontziFactory();}
		return nItsasontziFactory;
	}
	public Itsasontzia createItsasontzia(String pMota){
		Itsasontzia i=null;
		if (pMota=="Fragata"){ i = new Itsasontzia(				"Fragata",1,100);}
		else if (pMota=="Itsapekoa") {i = new Itsasontzia(		"Itsapekoa",2,200);}
		else if (pMota=="Suntsitzailea") {i = new Itsasontzia(	"Suntsitzailea",3,300);}
		else if (pMota=="HegazkinOntzia") { i = new Itsasontzia("HegazkinOntzia",4,400);}
		return i;
	}
}
