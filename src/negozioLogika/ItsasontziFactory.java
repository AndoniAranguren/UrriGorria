package negozioLogika;

public class ItsasontziFactory {
	private static ItsasontziFactory nItsasontziFactory = null;
	private ItsasontziFactory(){}
	public static ItsasontziFactory getItsasontziFactory(){
		if(nItsasontziFactory==null){ nItsasontziFactory = new ItsasontziFactory();}
		return nItsasontziFactory;
	}
	public Itsasontzia createItsasontzia(String mota){
		Itsasontzia i=null;
		if (mota=="Fragata"){ i = new Fragata();}
		if (mota=="Itsapekoa") {i = new Itsaspekoa();}
		if (mota=="Suntsitzailea") {i = new Suntsitzailea();}
		if (mota=="HegazkinOntzia") { i = new HegazkinOntzia();}
		return i;
	}
}
