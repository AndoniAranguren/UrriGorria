package negozioLogika.strategyak;

import negozioLogika.Mapa;

public class ErabiliEzkutua implements StrategyEkipoak{

	public Mapa erabili(String pNork, Mapa pMapa,int pX, int pY, boolean pZer) {
		pMapa.ezkutuaJarri(pNork, pX, pY, pZer);
		return pMapa;
	}

}
