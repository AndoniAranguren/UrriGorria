package strategyak;

import negozioLogika.Mapa;

public class ErasoLineal implements StrategyArmak{
	public ErasoLineal(){
	}
	public Mapa eraso(String pNork,Mapa pMapa, int pX, int pY, char pNorabide, int pIndarra, boolean pZer){
		int ind=0;
		ErasoSinple er=new ErasoSinple();
		if(pNorabide=='N'||pNorabide=='S'){
			while(er.konprobatu(pMapa, ind, pY)){
				er.eraso(pNork,pMapa, ind, pY, pNorabide, pIndarra, pZer);
				ind++;
			}
		}
		else{
			while(er.konprobatu(pMapa, pX, ind)){
				er.eraso(pNork,pMapa, pX, ind,pNorabide, pIndarra, pZer);
				ind++;
			}
		}
		return pMapa;
	}

}
