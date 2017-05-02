package negozioLogika;

import frontend.UrriGorriaUI;

public class UrriGorria {
	private static UrriGorria ug;
	private int partida;

	private UrriGorriaUI ui;

	private UrriGorria() 
	{
	}

	public void jokatu() {
		this.ui = new UrriGorriaUI();
	}

	public static UrriGorria getUrriGorria() {
		return ug == null ? (ug = new UrriGorria()) : ug;
	}
	
	public UrriGorriaUI getUi() {
		return ui;	
	}

	public void setPartida(int partida) {
		this.partida = partida;
	}
}
