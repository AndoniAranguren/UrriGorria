package negozioLogika;

public class Partida {
	private static Partida nPartida=null;
	private Jokalaria[] jokalariak;
	private static int maxJok=2;
	private int txanda;
	private int iraupena;
	private Partida(){
		jokalariak = new Jokalaria[maxJok];
		iraupena=0;
	}
	public static synchronized Partida getPartida(){
		if(nPartida==null){ nPartida = new Partida();}
		return nPartida;
	}
	public void partidaJokatu(){}
	public void txandaAldatu(){}
	
}
