package negozioLogika;

import strategyak.StrategyEkipoak;

public class Ekipoak extends Objektuak {
	
	private StrategyEkipoak portaera;
	
	public Ekipoak(String pIzena, StrategyEkipoak pPortaera){
		super(pIzena);
		portaera=pPortaera;
	}

	public Mapa erabili(String pNork, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer) {
		// TODO Auto-generated method stub
		return portaera.erabili(pNork, pMapa, pX, pY, pNorabide, pZer);
	}

}
