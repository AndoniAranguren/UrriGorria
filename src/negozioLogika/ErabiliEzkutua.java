package negozioLogika;

public class ErabiliEzkutua implements StrategyEkipoak{//, String pNori?????

	public boolean erabili(Mapa pMapa, String pNork,int pX, int pY) {
		return pMapa.ezkutuaJarri(pNork,pX,pY);
	}
}
