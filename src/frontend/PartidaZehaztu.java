package frontend;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PartidaZehaztu extends JPanel{

	private static final long serialVersionUID = 1L;
	private JRadioButton ia, bijokalari, erreza, zaila;
	private ButtonGroup norekin, zailtasuna;
	private JButton sartu;
	private JPanel panel;
	
	public PartidaZehaztu() {
		this.setLayout(new BorderLayout());
		ia = new JRadioButton("Makinaren aurka");
		bijokalari = new JRadioButton("Bi jokalari");
		erreza = new JRadioButton("Erreza");
		zaila = new JRadioButton("Zaila");
		sartu = new JButton("Partida hasi");
		panel.add(bijokalari);
		//panel.add(ia);
		//panel.add(erreza);
		//panel.add(zaila);
		//panel.add(sartu);
		this.add(panel, BorderLayout.CENTER);
	}
}
