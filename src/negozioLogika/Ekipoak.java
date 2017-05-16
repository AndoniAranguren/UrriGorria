package negozioLogika;

import strategyak.StrategyEkipoak;

public class Ekipoak extends Objektuak {
	
	private StrategyEkipoak portaera;
	
	public Ekipoak(String pIzena, int pKop, StrategyEkipoak pPortaera){
		super(pIzena, pKop);
		portaera=pPortaera;
	}
	public void erabili(String pNori, Mapa pMapa, int pX, int pY, boolean pZer) {
		portaera.erabili(pNori, pMapa, pX, pY, pZer);
	}

}
