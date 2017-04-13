package negozioLogika;

public class ErasoBikoitza implements StrategyArmak{
	public ErasoBikoitza(){
	}
	public Mapa eraso(String pNork,Mapa pMapa, int pX, int pY, char pNorabide, int pIndarra, boolean pZer){
		ErasoLineal er=new ErasoLineal();
		pMapa=er.eraso(pNork, pMapa, pX, pY, 'N', pIndarra, pZer);
		pMapa=er.eraso(pNork, pMapa, pX, pY, 'E', pIndarra, pZer);
		
		return pMapa;
	}

}
