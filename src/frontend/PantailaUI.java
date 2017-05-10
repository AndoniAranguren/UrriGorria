package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PantailaUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private TableroaUI tableroa;
	private InbentarioaUI inbentarioa;
	private JPanel tableroak;
	
	public PantailaUI(String jokalaria) {
		this.setLayout(new BorderLayout());
		this.setTableroak(jokalaria);
		inbentarioa = new InbentarioaUI(jokalaria);
		this.add(tableroak, BorderLayout.WEST);
		this.add(inbentarioa, BorderLayout.EAST);
	}
	
	private void setTableroak(String jokalaria) {
		tableroak = new JPanel();
		tableroak.setLayout(new GridLayout(2, 1));
		Color[] c = new Color[2];
		c[0] = Color.YELLOW;
		c[1] = Color.WHITE;
		for(int i=0; i<2; i++) {
			tableroa = new TableroaUI(jokalaria, c[i]);
			tableroak.add(tableroa);
		}
	}

}
