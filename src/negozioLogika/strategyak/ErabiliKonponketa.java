package negozioLogika.strategyak;

import negozioLogika.Mapa;

public class ErabiliKonponketa implements StrategyEkipoak {

	@Override
	public void erabili(String pNork, Mapa pMapa, int pX, int pY, boolean pZer) {
		pMapa.erabiliEkipo("Konponketa",pX, pY, pZer);
		
	}

}
