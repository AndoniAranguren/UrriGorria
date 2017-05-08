package strategyak;

import negozioLogika.Mapa;

public interface StrategyEkipoak {
	public Mapa erabili(String pNork, Mapa pMapa,int pX, int pY, boolean pZer);
}