package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import interfazeGrafikoa.externals.Irudiak;
import interfazeGrafikoa.properties.Hizkuntza;

public class OntziakKokatuUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private TableroaUI jok_tableroa;
	private InbentarioaUI inb;
	private JPanel top;
	private Hizkuntza h;

	public OntziakKokatuUI(String pJokalaria, String hizkuntza) {
		this.h = new Hizkuntza(hizkuntza);
		this.setLayout(new BorderLayout());
		jok_tableroa = new TableroaUI(pJokalaria, hizkuntza);
		this.add(jok_tableroa, BorderLayout.CENTER);
		top= new JPanel();
		inb = new InbentarioaUI(pJokalaria, hizkuntza);
		
		this.add(inb, BorderLayout.WEST);
		this.add(top,BorderLayout.PAGE_START);
		
		JButton nora = new JButton((Irudiak.getIrudiak().norabideaLortu()));
		JButton atzera = new JButton(h.getProperty("atzera"));
		JButton itsasontziakIpini = new JButton(h.getProperty("itsasontziakIpini"));
		nora.setName("Norabidea");
		nora.addActionListener(this);
		atzera.setName("Atzera");
		atzera.addActionListener(this);
		itsasontziakIpini.setName("Itsasontziak Ipini");
		itsasontziakIpini.addActionListener(this);

		top.add(itsasontziakIpini);
		top.add(nora);
		top.add(atzera);
		

		JButton jarraitu = new JButton(h.getProperty("jarraitu"));
		jarraitu.setName("Jarraitu");
		jarraitu.addActionListener(this);
		
		this.add(jarraitu, BorderLayout.EAST);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getName().equals("Jarraitu")){
			if(inb.itsasontziGuztiakKokaturik())
				UrriGorriaUI.getUrriGorriaUI().faseaAldatu();
		}
		if(((JButton)e.getSource()).getName().equals("Norabidea")){
			UrriGorriaUI.getUrriGorriaUI().norabideaAldatu();
		}
		if(((JButton)e.getSource()).getName().equals("Itsasontziak Ipini")){
			UrriGorriaUI.getUrriGorriaUI().itsasontziakIpini();
		}
		if(((JButton) e.getSource()).getName().equals("Atzera")){
			UrriGorriaUI.getUrriGorriaUI().komandoaAtzera();
		}
	}
}
