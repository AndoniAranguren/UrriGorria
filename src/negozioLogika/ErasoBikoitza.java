package negozioLogika;

public class ErasoBikoitza implements StrategyArmak{
	public ErasoBikoitza(){
	}
	public Mapa erasoEgin(String pNork,Mapa pMapa, int pX, int pY, char pNorabide, int pIndarra, boolean pZer){
		ErasoLineal er=new ErasoLineal();
		pMapa=er.erasoEgin(pNork, pMapa, pX, pY, 'N', pIndarra, pZer);
		pMapa=er.erasoEgin(pNork, pMapa, pX, pY, 'E', pIndarra, pZer);
		
		return pMapa;
	}

}
