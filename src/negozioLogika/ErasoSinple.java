package negozioLogika;

public class ErasoSinple implements StrategyArmak{
	public ErasoSinple(){
	}
	public Mapa erasoEgin(String pNork,Mapa pMapa, int pX, int pY, char pNorabide, int pIndarra, boolean pZer){
		pMapa.erasoSinpleaJaso(pNork, pX, pY, pIndarra, pZer);
		return pMapa;
	}
}
