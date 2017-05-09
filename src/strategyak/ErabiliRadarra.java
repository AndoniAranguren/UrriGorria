package strategyak;

import negozioLogika.Mapa;
import negozioLogika.Partida;

public class ErabiliRadarra implements StrategyEkipoak{//pX eta pY RND() rekin etorri behar dira
	public Mapa erabili(String pNork, Mapa pMapa,int pX, int pY, boolean pZer) {
		pMapa.radarraErabili(pNork, pX,pY,pZer);
		return pMapa;
	}
}
