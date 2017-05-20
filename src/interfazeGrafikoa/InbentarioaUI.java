package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interfazeGrafikoa.properties.Hizkuntza;

public class InbentarioaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria=null;
	private JScrollPane  scroll;
	private JPanel inbentarioa;
	private ArrayList<String> inb = new ArrayList<>();
	private int fasea;
	private Hizkuntza h;
	private boolean itsasontziGuztiakIpinita;


	public InbentarioaUI(String pIzena, int pFasea, String hizkuntza) {
		h = new Hizkuntza(hizkuntza);
		jokalaria=pIzena;
		fasea=pFasea;
		inb = UrriGorriaUI.getUrriGorriaUI().inbentarioaEman(jokalaria);
		this.setLayout(new BorderLayout());
		inbentarioa=new JPanel();
		inbentarioa.setLayout(new GridLayout(inb.size(), 1));
		this.setBorder(BorderFactory.createTitledBorder(h.getProperty("inbentarioa")));
		inbentarioaAktualizatu();

		scroll.setPreferredSize(new java.awt.Dimension(UrriGorriaUI.getLeihoaW()/4,UrriGorriaUI.getLeihoaH()/3));
		this.add(scroll, BorderLayout.CENTER);
	}
	public void inbentarioaAktualizatu(){
		JButton[] inbButton = new JButton[inb.size()];
		itsasontziGuztiakIpinita=true;
		for(int i=0; i<inb.size(); i++){
			inbButton[i] = new JButton();
			inbButton[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			String izena=inb.get(i);
			inbButton[i].setName(izena.split(":")[1]);
			inbButton[i].setText(h.getProperty(izena.split(":")[1]) + ":"+izena.split(":")[2]);
			inbButton[i].addActionListener(this);
			if(Integer.parseInt(izena.split(":")[0])!=fasea||Integer.parseInt(izena.split(": ")[1])<1){
				inbButton[i].setEnabled(false);
			}else if((UrriGorriaUI.getUrriGorriaUI().getObjektua().equals(inb.get(i).split(":")[1]))){
				inbButton[i].setBackground(new Color(175, 255, 175));
			}
			if(itsasontziGuztiakIpinita&&Integer.parseInt(izena.split(":")[0])==0)//itsasontzia izatea
				itsasontziGuztiakIpinita=Integer.parseInt(izena.split(": ")[1])<=0;//kop 0 izatea
			inbentarioa.add(inbButton[i]);
		}
		scroll=new JScrollPane(inbentarioa);
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