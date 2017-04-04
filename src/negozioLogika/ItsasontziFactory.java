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
	public int luzeeraLortu(String mota){
		int i=0;
		if (mota=="Fragata"){ i = 1;}
		if (mota=="Itsapekoa") {i =2;}
		if (mota=="Suntsitzailea") {i =3;}
		if (mota=="HegazkinOntzia") { i =4;}
		return i;
	}
	public int prezioaLortu(String mota){
		int i=0;
		if (mota=="Fragata"){i = 100;}
		if (mota=="Itsapekoa") {i =200;}
		if (mota=="Suntsitzailea") {i =300;}
		if (mota=="HegazkinOntzia") { i =400;}
		return i;
	}
}
