package negozioLogika;

import frontend.UrriGorriaUI;

public class UrriGorria {
	private int partida;
	private static UrriGorria ug;

	private UrriGorria() {

	}

	public void jokatu() {
		new UrriGorriaUI();
	}

	public static UrriGorria getUrriGorria() {
		return ug == null ? (ug = new UrriGorria()) : ug;
	}

	public void setPartida(int partida) {
		this.partida = partida;
	}
}
