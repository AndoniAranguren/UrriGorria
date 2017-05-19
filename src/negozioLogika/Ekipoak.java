package negozioLogika;

import negozioLogika.strategyak.StrategyEkipoak;

public class Ekipoak extends Objektuak {
	
	private StrategyEkipoak portaera;
	
	public Ekipoak(String pIzena, int pKop, StrategyEkipoak pPortaera){
		super(pIzena, pKop,1);
		portaera=pPortaera;
	}
	public Mapa aktibatu(String pNork, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer) {
		return portaera.erabili(pNork, pMapa, pX, pY, pZer);
	}
}
