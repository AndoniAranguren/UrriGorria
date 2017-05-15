package frontend;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class OntziakKokatuUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private TableroaUI tableroa;

	public OntziakKokatuUI(String jokalaria, Color c) {
		this.setLayout(new BorderLayout());
		tableroa = new TableroaUI(jokalaria, c);
		this.add(tableroa, BorderLayout.CENTER);
	}
}
