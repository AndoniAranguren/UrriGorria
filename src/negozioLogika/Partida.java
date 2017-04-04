package negozioLogika;

public class Partida {
	private static Partida nPartida=null;
	private static Jokalariak[] jokalariLista;
	private static int maxJok=2;
	private int txanda;
	private int iraupena;
	private Partida(){
		jokalariLista = new Jokalaria[maxJok];
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
	public static void itsasontziaJarri(String pOntzi, int pX, int pY, char pNorabidea, String pJokalaria) {
		// TODO Auto-generated method stub
		jokalariLista[jokalariarenPosLortu(pJokalaria)].itsasontziaJarri(pOntzi, pX, pY, pNorabidea);
	}
	public static boolean kokatuDaiteke(int pX, int pY, int pLuzeera, char pNorabidea, String pJokalaria) {
		// TODO Auto-generated method stub
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].kokatuDaiteke(pX, pY, pLuzeera, pNorabidea);
	}
	public static void objektuaKendu(String pJokalaria, String pObjektua){
		jokalariLista[jokalariarenPosLortu(pJokalaria)].objektuaKendu(pObjektua);
	}
}
