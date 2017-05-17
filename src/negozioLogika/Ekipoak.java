package negozioLogika;

import strategyak.StrategyEkipoak;

public class Ekipoak extends Objektuak {
	
	private StrategyEkipoak portaera;
	
	public Ekipoak(String pIzena, int pKop, StrategyEkipoak pPortaera){
		super(pIzena, pKop,1);
		portaera=pPortaera;
	}
	public void erabili(String pNori, Mapa pMapa, int pX, int pY, boolean pZer) {
		portaera.erabili(pNori, pMapa, pX, pY, pZer);
	}
	public Mapa aktibatu(String pNork, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer) {
		return portaera.erabili(pNork, pMapa, pX, pY, pZer);
	}

}
