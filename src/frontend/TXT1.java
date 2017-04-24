package frontend;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import negozioLogika.interfaces.UGKonstanteak;

public class TXT1 extends JPanel implements UGKonstanteak {
	
	private static final long serialVersionUID = 1L;

	public TXT1() {
		this.setLayout(new GridLayout(4, 3));
		JLabel txt = new JLabel(TXT_1);
		JLabel txt1 = new JLabel(TXT_1_1);
		JLabel txt2 = new JLabel(TXT_1_2);
		JLabel txt3 = new JLabel(TXT_1_3);
		this.add(txt, 0);
		this.add(txt1, 1);
		this.add(txt2, 2);
		this.add(txt3, 3);
	}
}
