package frontend;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarra extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenu hizkuntza;
	private JMenuItem hizkuntza1, hizkuntza2, hizkuntza3;
	
	public MenuBarra() {
		this.hizkuntzaEraiki();
	}
	
	private void hizkuntzaEraiki() {
		hizkuntza = new JMenu("Hizkuntza");
		hizkuntza1 = new JMenuItem("Euskera");
		hizkuntza1.addActionListener(gureAE -> this.hizkuntzaAldatu("euskera"));
		hizkuntza2 = new JMenuItem("Gaztelera");
		hizkuntza2.addActionListener(gureAE -> this.hizkuntzaAldatu("gaztelera"));
		hizkuntza3 = new JMenuItem("Ingelesa");
		hizkuntza3.addActionListener(gureAE -> this.hizkuntzaAldatu("ingelesa"));
		hizkuntza.add(hizkuntza1);
		hizkuntza.add(hizkuntza2);
		hizkuntza.add(hizkuntza3);
		this.add(hizkuntza);
	}
	
	private void hizkuntzaAldatu(String hiz) {

	}

}
