package negozioLogika;

public class ErasoSinple implements StrategyArmak{
	private int indarra;
	public ErasoSinple(int pIndarra){
		this.indarra=pIndarra;
	}
	public void eraso(int x, int y, String nork, String nori, int indarra) {
		Partida.getPartida().erasoaJaso(x, y, nork, nori, indarra);
	}

}
