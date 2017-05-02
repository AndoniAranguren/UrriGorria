package negozioLogika;

import java.util.ArrayList;

public class Partida {
	private static Partida nPartida=null;
	
	private static Jokalariak[] jokalariLista;
	private static int maxJok=2;

	private boolean jokatzenJarraitu;
	private static int[] egoera= new int[2];
	//fasea=egoera[0];
	//txanda=egoera[1];
	//iraupena=egoera[2];
	
	private Partida(){
		jokalariLista = new Jokalaria[maxJok-1];
		egoera[2]=0;
	}	
	public static synchronized Partida getPartida(){
		if(nPartida==null){ nPartida = new Partida();}
		return nPartida;
	}
	
	public void partidaJokatu(){
		while(jokatzenJarraitu){
			//TODO
		}
	}
	private static int jokalariarenPosLortu(String pJ) {
		int ind =0;
		Boolean aurkituta=false;
		while(!aurkituta && ind<=(maxJok-1)){
			if(jokalariLista[ind].izenHauDu(pJ)) aurkituta=true;
			else ind++;
		}
		return ind;
	}
	public static String norenTxandaDa() {
		return jokalariLista[egoera[1]].izenaLortu();
	}
	public static int[] egoeraLortu() {
		//fasea=egoera[0];
		//txanda=egoera[1];
		//iraupena=egoera[2];
		return egoera;
	}
	public static boolean kokatuDaiteke( String pJokalaria, int pX, int pY, char pNorabidea, int pLuzeera) {
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].kokatuDaiteke( pX, pY, pNorabidea, pLuzeera);
	}
	public static boolean jokalariakObjektuakDitu(String pJokalari, ArrayList<Objektuak> pObjektuak) {
		return jokalariLista[jokalariarenPosLortu(pJokalari)].objektuakDitu(pObjektuak);
	}
	public static boolean jokalariaBizirikDago(String pNor) {
		return jokalariLista[jokalariarenPosLortu(pNor)].jokalariaBizirikDago();
	}
	public static ArrayList<Objektuak> dendakIzakinakDitu(String pJokalaria, Erosketa pErosketa) {
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].dendakIzakinakDitu(pErosketa);
	}
	public String[][] mapaInterpretatu(String pNork,String pNori){
		return jokalariLista[jokalariarenPosLortu(pNori)].mapaInterpretatu(pNork);
	}
	public static Itsasontzia itsasontziaJarri(String pJokalaria, Itsasontzia pOntzi, int pX, int pY, char pNorabidea, boolean pZer) {
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].itsasontziaJarri(pOntzi, pX, pY, pNorabidea, pZer);
	}
	public static void jokalariariErasotu(String pJokalari,String pNori, Objektuak pObjektua, int pX, int pY,char pNorabide, boolean pZer) {
		jokalariLista[jokalariarenPosLortu(pNori)].jokalariariErasotu(pJokalari,pObjektua,pX,pY,pNorabide,pZer);
	}
	public static void jokalariariDiruaEman(String pJokalaria, int pPrezioa, boolean pZer) {
		jokalariLista[jokalariarenPosLortu(pJokalaria)].jokalariariDiruaEman(pPrezioa, pZer);
	}
	public static void dendariObjektuakEman(String pJokalaria, ArrayList<Objektuak> pObjektuak, boolean pZer) {
		jokalariLista[jokalariarenPosLortu(pJokalaria)].dendariObjektuakEman(pObjektuak, pZer);
	}
	public static void jokalariariObjektuakEman(String pJokalaria, ArrayList<Objektuak> pObjektuak, boolean pZer) {
		jokalariLista[jokalariarenPosLortu(pJokalaria)].jokalariariObjektuakEman(pObjektuak, pZer);
	}
	public static boolean jokalariakDiruaDu(String pJokalaria, int pPrezioa) {
		return jokalariLista[jokalariarenPosLortu(pJokalaria)].jokalariakDiruaDu(pPrezioa);
	}
}
