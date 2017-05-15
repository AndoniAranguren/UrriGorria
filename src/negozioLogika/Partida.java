package negozioLogika;

import java.util.ArrayList;

import frontend.UrriGorriaUI;
import negozioLogika.commands.CommandErosketaEgin;
import negozioLogika.commands.CommandItsasontziaIpini;
import negozioLogika.commands.CommandObjektuaErabili;

public class Partida {
	private static Partida nPartida=null;
	
	private static ArrayList<Jokalariak> jokalariLista;
	private static int maxJok=0;

	private static int[] egoera= new int[3];
	private UrriGorriaUI ui;
	//fasea=egoera[0];
	//txanda=egoera[1];
	//iraupena=egoera[2];
	
	private Partida(){
		jokalariLista = new ArrayList<Jokalariak>();
		egoera[2]=0;
		egoera[1]=0;
		egoera[0]=-1;
	}	
	public static synchronized Partida getPartida(){
		if(nPartida==null){ nPartida = new Partida();}
		return nPartida;
	}
	
	public void partidaJokatu(){
		this.ui = new UrriGorriaUI();
	}
	
	public UrriGorriaUI getUi() {
		return ui;
	}
	
	private static int jokalariarenPosLortu(String pJ) {
		int ind =0;
		Boolean aurkituta=false;
		while(!aurkituta && ind<(maxJok-1)){
			if(jokalariLista.get(ind).izenHauDu(pJ)) aurkituta=true;
			else ind++;
		}
		return ind;
	}
	public static String norenTxandaDa() {
		return jokalariLista.get(egoera[1]).izenaLortu();
	}
	public static int[] egoeraLortu() {
		//fasea=egoera[0];
		//txanda=egoera[1];
		//iraupena=egoera[2];
		return egoera;
	}
	public static boolean kokatuDaiteke( String pJokalaria, int pX, int pY, char pNorabidea, int pLuzeera) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria))
				.kokatuDaiteke( pX, pY, pNorabidea, pLuzeera);
	}
	public static boolean jokalariakObjektuakNahikoakDitu(String pJokalari, ArrayList<Objektuak> pObjektuak) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalari)).objektuakNahikoakDitu(pObjektuak);
	}
	public static boolean jokalariaBizirikDago(String pNor) {
		return jokalariLista.get(jokalariarenPosLortu(pNor)).jokalariaBizirikDago();
	}
	public static ArrayList<Objektuak> dendakIzakinakDitu(String pJokalaria, Erosketa pErosketa) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).dendakIzakinakDitu(pErosketa);
	}
	public static String[][] mapaInterpretatu(String pNork,String pNori){
		return jokalariLista.get(jokalariarenPosLortu(pNori)).mapaInterpretatu(pNork);
	}
	public static Itsasontzia itsasontziaJarri(String pJokalaria, Itsasontzia pOntzi, int pX, int pY, char pNorabidea, boolean pZer) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).itsasontziaJarri(pOntzi, pX, pY, pNorabidea, pZer);
	}
	public static void jokalariariErasotu(String pJokalari,String pNori, Objektuak pObjektua, int pX, int pY,char pNorabide, boolean pZer) {
		jokalariLista.get(jokalariarenPosLortu(pNori)).jokalariariErasotu(pJokalari,pObjektua,pX,pY,pNorabide,pZer);
	}
	public static void jokalariariDiruaEman(String pJokalaria, int pPrezioa, boolean pZer) {
		jokalariLista.get(jokalariarenPosLortu(pJokalaria)).jokalariariDiruaEman(pPrezioa, pZer);
	}
	public static void dendariObjektuakEman(String pJokalaria, ArrayList<Objektuak> pObjektuak, boolean pZer) {
		jokalariLista.get(jokalariarenPosLortu(pJokalaria)).dendariObjektuakEman(pObjektuak, pZer);
	}
	public static void jokalariariObjektuakEman(String pJokalaria, ArrayList<Objektuak> pObjektuak, boolean pZer) {
		jokalariLista.get(jokalariarenPosLortu(pJokalaria)).jokalariariObjektuakEman(pObjektuak, pZer);
	}
	public static boolean jokalariakDiruaDu(String pJokalaria, int pPrezioa) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).jokalariakDiruaDu(pPrezioa);
	}
	public void partidaZehaztu(String pInfo) {
		maxJok++;
		jokalariLista.add(new Jokalaria("1.Jokalaria"));
		maxJok++;
		if(pInfo.equals("BI_JOKALARI")){
			jokalariLista.add(new Jokalaria("2.Jokalaria"));
		}else if(pInfo.equals("MAKINAREN_AURKA_ERREZA")){
			jokalariLista.add(new CPU("1.CPU", 1));
		}else if(pInfo.equals("MAKINAREN_AURKA_ZAILA")){
			jokalariLista.add(new CPU("1.CPU", 2));
		}
	}
	public static ArrayList<String> inbentarioaEman(String pJokalaria) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).inbentarioaEman();
	}
	public static ArrayList<String> dendaEman(String pJokalaria) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).dendaEman();
	}
	public ArrayList<String> logaEman(String pJokalaria) {
		return Battlelog.BattlelogaLortu().logaEman();
	}
	public void komandoaEgikaritu(String pJokalaria, String pKomandoa, String[] pInfo) {
		if(pJokalaria==norenTxandaDa()){
			System.out.println("Zure txanda da");
			switch (pKomandoa){
				case "CommandErosketaEgin":
					Erosketa e=ErosketaFactory.getErosketaFactory().createErosketa(pInfo[0]);
					CommandErosketaEgin kEros= new CommandErosketaEgin(pJokalaria,e);
					kEros.exekutatu();
					break;
				case "CommandObjektuaErabili":
					Objektuak ob=ObjektuakFactory.getObjektuakFactory().createObjektua(pInfo[0]);
					CommandObjektuaErabili kObj= new CommandObjektuaErabili(pJokalaria,ob,Integer.parseInt(pInfo[1]),
							Integer.parseInt(pInfo[2]),pInfo[3].charAt(0));
					kObj.exekutatu();
					break;
				case "CommandItsasontziaIpini":
					Itsasontzia its=(Itsasontzia)ObjektuakFactory.getObjektuakFactory().createObjektua(pInfo[0]);
					CommandItsasontziaIpini kIts= new CommandItsasontziaIpini(pJokalaria,its,Integer.parseInt(pInfo[1]),
							Integer.parseInt(pInfo[2]),pInfo[3].charAt(0));
					kIts.exekutatu();
					break;
			}
		}else System.out.println("Ez da zure txanda");
		System.out.println(pJokalaria);
		System.out.println(norenTxandaDa());
	}
	public void komandoaAtzera() {
		Battlelog.BattlelogaLortu().komandoaAtzera();
	}
	public void jokalariakObjektuaErabili(String pNori, String[] pInfo) {
		jokalariLista.get(jokalariarenPosLortu(norenTxandaDa())).objektuaErabili(pNori,pInfo);
		
	}
}
