package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PantailaUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private TableroaUI tableroa1, tableroa2;
	private InbentarioaUI inbentarioa;
	private LogUI log;
	private JPanel tableroak, norabidea, itsasontziak;
	
	public PantailaUI(String jokalaria) {
		this.setLayout(new BorderLayout());
		this.setTableroak(jokalaria);
		this.setItsasontziak(jokalaria);
		log = new LogUI();
		this.add(tableroak, BorderLayout.CENTER);
		this.add(itsasontziak, BorderLayout.EAST);
		this.add(log, BorderLayout.WEST);
	}
	
	private void setTableroak(String jokalaria) {
		tableroak = new JPanel();
		tableroak.setLayout(new GridLayout(2, 1));
		tableroa1 = new TableroaUI(jokalaria, Color.YELLOW);
		tableroa2 = new TableroaUI(jokalaria, Color.WHITE);
		tableroak.add(tableroa1);
//		tableroak.add(a);
		tableroak.add(tableroa2);
	}
	
	private void setItsasontziak(String jokalaria) {
		itsasontziak = new JPanel();
		norabidea = new JPanel();
		JButton nora = new JButton(new ImageIcon(TableroaUI.class.getResource("/externals/flecha.png")));
		inbentarioa = new InbentarioaUI(jokalaria);
		itsasontziak.add(nora);
		itsasontziak.add(inbentarioa);
	}

}
