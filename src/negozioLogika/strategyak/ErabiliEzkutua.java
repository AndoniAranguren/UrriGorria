package negozioLogika.strategyak;

import negozioLogika.Mapa;

public class ErabiliEzkutua implements StrategyEkipoak{

	public void erabili(String pNork, Mapa pMapa,int pX, int pY, boolean pZer) {
		pMapa.erabiliEkipo("Ezkutua",pX, pY, pZer);
	}

}
