package negozioLogika.commands;

import negozioLogika.Partida;

public class CommandObjetuaKendu {
	String jokalaria;
	String ontzia;
	public void exekutatu(String pJokalaria, String pOntzia) {
		// TODO Auto-generated method stub
		jokalaria=pJokalaria;
		ontzia=pOntzia;
		Partida.objektuaKendu(jokalaria, ontzia);
	}
}
