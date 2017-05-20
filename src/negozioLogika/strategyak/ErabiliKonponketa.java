package negozioLogika.strategyak;

import negozioLogika.Mapa;

public class ErabiliKonponketa implements StrategyEkipoak {

	@Override
	public Mapa erabili(String pNork, Mapa pMapa, int pX, int pY, boolean pZer) {
		return pMapa.erabiliEkipo("Konponketa",pX, pY, pZer);
		
	}

}
