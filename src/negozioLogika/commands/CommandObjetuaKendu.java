package negozioLogika.commands;

import negozioLogika.Partida;

public class CommandObjetuaKendu {
	String jokalaria;
	String[] objektua;
	public void exekutatu(String pJokalaria, String[] pObjektua) {
		// TODO Auto-generated method stub
		jokalaria=pJokalaria;
		objektua=pObjektua;
		Partida.jokalariariObjektuakEman(jokalaria, objektua, false);
	}
}
