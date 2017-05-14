package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PantailaUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private TableroaUI tableroa1, tableroa2;
	private DendaUI denda;
	private LogUI log;
	private InbentarioaUI inbentarioa;
	private JPanel tableroak, itsasontziak1, itsasontziak2;
	
	public PantailaUI(String jokalaria) {
		this.setLayout(new BorderLayout());
		this.setTableroak(jokalaria);
		this.setDenda(jokalaria);
		this.setNorabidea(jokalaria);
		this.setInbentarioa(jokalaria);
		this.add(tableroak, BorderLayout.CENTER);
		this.add(itsasontziak1, BorderLayout.WEST);
		this.add(log, BorderLayout.EAST);
//		this.add(itsasontziak2, BorderLayout.WEST);
	}
	
	private void setTableroak(String jokalaria) {
		tableroak = new JPanel();
		tableroak.setLayout(new GridLayout(2, 1));
		tableroa1 = new TableroaUI("Aurkaria", Color.RED);
		tableroa2 = new TableroaUI(jokalaria, Color.BLUE);
		tableroak.add(tableroa1);
		tableroak.add(tableroa2);
	}
	
	private void setDenda(String jokalaria) {
		itsasontziak1 = new JPanel();
		JButton nora1 = new JButton(new ImageIcon(TableroaUI.class.getResource("/externals/eki.png")));
		denda = new DendaUI(jokalaria);
		itsasontziak1.add(nora1);
		itsasontziak1.add(denda);
	}
	
	private void setInbentarioa(String jokalaria) {
		itsasontziak2 = new JPanel();
		JButton nora2 = new JButton(new ImageIcon(TableroaUI.class.getResource("/externals/eki.png")));
		inbentarioa = new InbentarioaUI(jokalaria);
		itsasontziak2.add(inbentarioa);
		itsasontziak2.add(nora2);
	}
	
	private void setNorabidea(String jokalaria) {
		log = new LogUI(jokalaria);
	}

}
