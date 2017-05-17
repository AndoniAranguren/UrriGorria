package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PantailaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private TableroaUI tableroa1,jok_tableroa;
	private DendaUI denda;
	private LogUI log;
	private InbentarioaUI inbentarioa;
	private int[] egoera;
	private String jokalaria;
	private JPanel tableroak, dendaP, inbentarioaP,dendaInbP,logP,top;
	
	public PantailaUI(String pJokalaria, int[] pEgoera) {
		jokalaria=pJokalaria;
		egoera=pEgoera;
		
		pantailaAktualizatu();
	}
	
	private void pantailaAktualizatu() {
		this.setLayout(new BorderLayout());
		this.setTableroak();
		this.setLoga();
		this.setDendaInbP();
		this.setTop();

		this.add(dendaInbP,BorderLayout.WEST);
		this.add(tableroak, BorderLayout.CENTER);
		this.add(logP, BorderLayout.EAST);
		this.add(top,BorderLayout.PAGE_START);
	}
	private void setTop() {
		top= new JPanel();
		String titulua=""+egoera[0];
		switch (egoera[0]){
		case 0: titulua="Erosi fasea";
			break;
		case 1: titulua="Ekipo fasea";
			break;
		case 2: titulua="Eraso fasea";
			break;
		}
		JButton tituluaJ = new JButton(titulua);
		top.setBorder(new TitledBorder(new LineBorder(Color.CYAN),"Iraupena: ("+egoera[2]+") "+UrriGorriaUI.norenTxandaDaIzena()));
		JButton nora2 = new JButton(new ImageIcon(TableroaUI.class.getResource(norabideaLortu())));
		JButton atzera = new JButton("Atzera");

		tituluaJ.setToolTipText("Txanda pasatu");
		tituluaJ.setName("Txanda pasatu");
		nora2.setName("Norabidea");
		atzera.setName("Atzera");
		tituluaJ.addActionListener(this);
		nora2.addActionListener(this);
		atzera.addActionListener(this);
		top.setPreferredSize(new Dimension(UrriGorriaUI.getLeihoaW(),UrriGorriaUI.getLeihoaH()*12/100));
		top.add(tituluaJ, BorderLayout.WEST);
		top.add(nora2);
		top.add(atzera);
	}

	private String norabideaLortu() {
		String irudi;
		switch (UrriGorriaUI.norabideaLortu()){
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

	private void setDendaInbP(){
		dendaInbP=new JPanel();
		dendaInbP.setLayout(new GridLayout(2, 1));
		
        
		dendaP = new JPanel();
		denda = new DendaUI(jokalaria,(egoera[0]==0? true:false));
		dendaP.add(denda);
		
		inbentarioaP = new JPanel();
		inbentarioa = new InbentarioaUI(jokalaria,egoera[0]);
		inbentarioaP.add(inbentarioa);
		
		if(egoera[0]!=0){
			inbentarioaP.setEnabled(false);
		}

		dendaInbP.add(dendaP);
		dendaInbP.add(inbentarioaP);
	}
	private void setTableroak() {
		tableroak = new JPanel();
		tableroak.setLayout(new GridLayout(2, 1));
		jok_tableroa = new TableroaUI(jokalaria, Color.RED);
		tableroa1 = new TableroaUI(UrriGorriaUI.getAurkaria(), Color.RED);
		tableroak.add(tableroa1);
		tableroak.add(jok_tableroa);
	}
	

	private void setLoga() {
		logP = new JPanel();
		log = new LogUI(jokalaria);
		logP.add(log);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((Component) e.getSource()).getName().equals("Atzera")){
			UrriGorriaUI.getUrriGorriaUI().komandoaAtzera();
		}
		if(((Component) e.getSource()).getName().equals("Norabidea")){
			UrriGorriaUI.getUrriGorriaUI().norabideaAldatu();
		}
		if(((Component) e.getSource()).getName().equals("Txanda pasatu")){
			UrriGorriaUI.getUrriGorriaUI().komandoaEgikaritu(jokalaria, "CommandTxandaPasa", new String[3]);
		}
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
	}

}