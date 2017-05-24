package negozioLogika.strategyak;

import negozioLogika.Mapa;

public class ErasoBikoitza implements StrategyArmak{
	public ErasoBikoitza(){
	}
	public void eraso(String pNork,Mapa pMapa, int pX, int pY, char pNorabide, int pIndarra, boolean pZer){
		ErasoLineal er=new ErasoLineal();
		er.eraso(pNork, pMapa, pX, pY, 'N', pIndarra, pZer);
		er.eraso(pNork, pMapa, pX, pY, 'E', pIndarra, pZer);
	}

}
