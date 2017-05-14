package frontend;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import negozioLogika.interfaces.UGKonstanteak;

public class UrriGorriaUI extends JFrame implements UGKonstanteak {
	
	private static final long serialVersionUID = 1L;
	private JPanel oraingoa;
	private static UrriGorriaUI ui;

	public UrriGorriaUI() {
		this.setTitle(IZENBURUA);
		oraingoa = new PartidaZehaztuUI();
		this.add(oraingoa);	
		setBounds(550, 350, 300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static UrriGorriaUI getUrriGorriaUI() {
		return ui == null ? (ui = new UrriGorriaUI()) : ui;
	}
	
	
	public void panelaAldatu(JPanel jartzeko) {
		this.remove(oraingoa);
		oraingoa = jartzeko;
		this.add(oraingoa);
		setMinimumSize(new Dimension(825, 825));
		this.revalidate();
		this.repaint();
	}	
}