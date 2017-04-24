package frontend;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import negozioLogika.interfaces.UGKonstanteak;

public class OntziakAukeratu1 extends JPanel implements UGKonstanteak {
	
	private static final long serialVersionUID = 1L;
	private JPanel tableroa, txt;

	public OntziakAukeratu1() {
		this.setLayout(new BorderLayout());
		tableroa = new TableroaUI();
		this.add(tableroa, BorderLayout.CENTER);
		//txt = new TXT1();
		//this.add(txt, BorderLayout.NORTH);
	}
}
