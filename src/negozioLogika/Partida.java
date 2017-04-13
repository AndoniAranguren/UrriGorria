package negozioLogika;

public class Partida {
	private static Partida nPartida=null;
	
	private static Jokalariak[] jokalariLista;
	private static int maxJok=2;
	
	private static int fasea,txanda,iraupena=0;
	
	private Partida(){
		jokalariLista = new Jokalaria[maxJok-1];
		iraupena=0;
	}
	
	public static synchronized Partida getPartida(){
		if(nPartida==null){ nPartida = new Partida();}
		return nPartida;
	}
	public void partidaJokatu(){}
	public void txandaAldatu(){}
	private static int jokalariarenPosLortu(String pJ) {
		// TODO Auto-generated method stub
		int ind =0;
		Boolean aurkituta=false;
		while(!aurkituta && ind<=(maxJok-1)){
			if(jokalariLista[ind].izenHauDu(pJ)) aurkituta=true;
			else ind++;
		}
		return ind;
	}
	public static int[] egoeraLortu() {
		// TODO Auto-generated method stub
		int[] egoera = new int[2];			//Komandoeta informazioa sartzeko gehienbat
		egoera[0]=txanda;
		egoera[1]=fasea;
		egoera[2]=iraupena;
		return egoera;
	}
	public static Itsasontzia itsasontziaJarri(String pJokalaria, Itsasontzia pOntzi, int pX, int pY, char pNorabidea, boolean pZer) {
		// TODO Auto-generated method stub
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].itsasontziaJarri(pOntzi, pX, pY, pNorabidea, pZer);
	}
	public static boolean kokatuDaiteke( String pJokalaria, int pX, int pY, char pNorabidea, int pLuzeera) {
		// TODO Auto-generated method stub
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].kokatuDaiteke( pX, pY, pNorabidea, pLuzeera);
	}
	public static int jokalariakDiruaDu(String pJokalaria, String pErosketa) {
		// TODO Auto-generated method stub
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].jokalariakDiruaDu(pJokalaria,pErosketa);
	}
	public static String[] dendakIzakinakDitu(String pJokalaria, String pErosketa) {
		// TODO Auto-generated method stub
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].dendakIzakinakDitu(pErosketa);
	}

	public static void jokalariariDiruaEman(String pJokalaria, int pPrezioa, boolean pZer) {
		// TODO Auto-generated method stub
		jokalariLista[jokalariarenPosLortu(pJokalaria)].jokalariariDiruaEman(pPrezioa, pZer);
	}

	public static void dendariObjektuakEman(String pJokalaria, Objektuak[] pObjektuak, boolean pZer) {
		// TODO Auto-generated method stub
		jokalariLista[jokalariarenPosLortu(pJokalaria)].dendariObjektuakEman(pObjektuak, pZer);
	}

	public static void jokalariariObjektuakEman(String pJokalaria, Objektuak[] pObjektuak, boolean pZer) {
		// TODO Auto-generated method stub
		jokalariLista[jokalariarenPosLortu(pJokalaria)].jokalariariObjektuakEman(pObjektuak, pZer);
	}

	public static String norenTxandaDa() {
		// TODO Auto-generated method stub
		return jokalariLista[txanda].izenaLortu();
	}

	public static boolean jokalariakObjektuakDitu(String pJokalari, Objektuak[] pObjektuak) {
		// TODO Auto-generated method stub
		return jokalariLista[jokalariarenPosLortu(pJokalari)].objektuakDitu(pObjektuak);
	}

	public static void jokalariariErasoEgin(String pJokalari,String pNori, Armak pArma, int pX, int pY,char pNorabide, boolean pZer) {
		// TODO Auto-generated method stub
		jokalariLista[jokalariarenPosLortu(pNori)].erasoaJaso(pJokalari,pArma,pX,pY,pNorabide,pZer);
	}
}
