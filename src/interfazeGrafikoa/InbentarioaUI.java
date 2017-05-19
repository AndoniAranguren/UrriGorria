package interfazeGrafikoa;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import interfazeGrafikoa.properties.Hizkuntza;

public class InbentarioaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria=null;
	private JButton[] inbentarioa;
	private ArrayList<String> inb = new ArrayList<>();
	private int fasea;
	private Hizkuntza h;
	private boolean itsasontziGuztiakIpinita;


	public InbentarioaUI(String pIzena, int pFasea, String hizkuntza) {
		h = new Hizkuntza(hizkuntza);
		jokalaria=pIzena;
		fasea=pFasea;
		inb = UrriGorriaUI.getUrriGorriaUI().inbentarioaEman(jokalaria);
		this.setLayout(new GridLayout(inb.size(), 1));
		this.setBorder(BorderFactory.createTitledBorder(h.getProperty("inbentarioa")));
		this.inbentarioaAktualizatu();
	}
	public void inbentarioaAktualizatu(){
		inbentarioa = new JButton[inb.size()];
		itsasontziGuztiakIpinita=true;
		for(int i=0; i<inb.size(); i++){
			inbentarioa[i] = new JButton();
			inbentarioa[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			String izena=inb.get(i);
			inbentarioa[i].setName(izena.split(":")[1]);
			inbentarioa[i].setText(h.getProperty(izena.split(":")[1]) + ":"+izena.split(":")[2]);
			inbentarioa[i].addActionListener(this);
			if(Integer.parseInt(izena.split(":")[0])!=fasea||Integer.parseInt(izena.split(": ")[1])<1){
				inbentarioa[i].setEnabled(false);
			}else if((UrriGorriaUI.getObjektua().equals(inb.get(i).split(":")[1]))){
				inbentarioa[i].setBackground(new Color(175, 255, 175));
			}
			if(itsasontziGuztiakIpinita&&Integer.parseInt(izena.split(":")[0])==0)//itsasontzia izatea
				itsasontziGuztiakIpinita=Integer.parseInt(izena.split(": ")[1])<=0;//kop 0 izatea
			this.add(inbentarioa[i]);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String sourceText=(String)((JButton)e.getSource()).getName();
		UrriGorriaUI.getUrriGorriaUI().objektuaAldatu((sourceText));
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();		
	}
	public boolean itsasontziGuztiakKokaturik() {
		return itsasontziGuztiakIpinita;
	}
}