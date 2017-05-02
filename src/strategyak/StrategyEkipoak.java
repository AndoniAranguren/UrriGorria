package strategyak;

import negozioLogika.Mapa;

public interface StrategyEkipoak {//, String pNori????
	public Mapa erabili(String pNork, Mapa pMapa,int pX, int pY, char pNorabide, boolean pZer);
}