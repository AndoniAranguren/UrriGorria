package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PantailaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private TableroaUI tableroa1, tableroa2;
	private DendaUI denda;
	private LogUI log;
	private InbentarioaUI inbentarioa;
	private JPanel tableroak, dendaP, inbentarioaP,dendaInbP,logP,top;
	
	public PantailaUI(String jokalaria) {
		this.setLayout(new BorderLayout());
		this.setTableroak(jokalaria);
		this.setLoga(jokalaria);
		this.setDendaInbP(jokalaria);
		this.setTop();

		
		this.add(dendaInbP,BorderLayout.WEST);
		this.add(tableroak, BorderLayout.CENTER);
		this.add(logP, BorderLayout.EAST);
		this.add(top,BorderLayout.PAGE_START);
	}
	
	private void setTop() {
		top= new JPanel();
		JButton nora2 = new JButton(new ImageIcon(TableroaUI.class.getResource(norabideaLortu())));
		JButton atzera = new JButton("Atzera");
		nora2.setName("Norabidea");
		atzera.setName("Atzera");
		nora2.addActionListener(this);
		atzera.addActionListener(this);
		top.add(nora2);
		top.add(atzera);
	}

	private String norabideaLortu() {
		String irudi;
		switch (UrriGorriaUI.getUrriGorriaUI().norabideaLortu()){
			case 0: irudi="/externals/eki.png";
				break;
			case 1: irudi="/externals/hego.png";
				break;
			case 2: irudi="/externals/mend.png";
				break;
			case 3: irudi="/externals/ipar.png";
				break;
			default: irudi="/externals/eki.png";
				break;
		}
		return irudi;
	}

	private void setDendaInbP(String jokalaria){
		dendaInbP=new JPanel();
		dendaInbP.setLayout(new GridLayout(3, 1));
		
		dendaP = new JPanel();
		denda = new DendaUI(jokalaria);
		dendaP.add(denda);
		
		inbentarioaP = new JPanel();
		inbentarioa = new InbentarioaUI(jokalaria);
		inbentarioaP.add(inbentarioa);
		

		dendaInbP.add(dendaP, BorderLayout.NORTH);
		dendaInbP.add(inbentarioaP, BorderLayout.SOUTH);
	}
	private void setTableroak(String jokalaria) {
		tableroak = new JPanel();
		tableroak.setLayout(new GridLayout(2, 1));
		tableroa1 = new TableroaUI("Aurkaria", Color.RED);
		tableroa2 = new TableroaUI(jokalaria, Color.BLUE);
		tableroak.add(tableroa1);
		tableroak.add(tableroa2);
	}
	
	private void setLoga(String jokalaria) {
		logP = new JPanel();
		log = new LogUI(jokalaria);
		logP.add(log);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if((String)((JButton)e.getSource()).getName()=="Atzera"){
			UrriGorriaUI.getUrriGorriaUI().komandoaAtzera();
		}
		if((String)((JButton)e.getSource()).getName()=="Norabidea"){
			UrriGorriaUI.getUrriGorriaUI().norabideaAldatu();
		}
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
	}

}
