package frontend;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import negozioLogika.interfaces.UGKonstanteak;

public class UrriGorriaUI extends JFrame implements UGKonstanteak {
	
	private static final long serialVersionUID = 1L;
	//private static UrriGorriaUI nLeihoa = null;
	//private TableroaGUI tableroa = new TableroaGUI();
	//private ItsasontziaGUI ontzia = new ItsasontziaGUI();
	private JPanel oraingoa;

	public UrriGorriaUI() {
		this.setTitle(IZENBURUA);
		oraingoa = new PartidaZehaztu();
		this.add(oraingoa);	
		setBounds(550, 350, 300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void panelaAldatu(JPanel jartzeko) {
		this.remove(oraingoa);
		oraingoa = jartzeko;
		this.add(oraingoa);
		setBounds(500, 200, 475, 475);
		this.revalidate();
		this.repaint();
	}
	
}
