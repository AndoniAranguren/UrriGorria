package frontend;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InbentarioaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria=null;
	private JButton[] inbentarioa;
	private ArrayList<String> inb = new ArrayList<>();
	private int fasea;


	public InbentarioaUI(String pIzena, int pFasea) {
		jokalaria=pIzena;
		fasea=pFasea;
		inb = UrriGorriaUI.getUrriGorriaUI().inbentarioaEman(jokalaria);
		this.setLayout(new GridLayout(inb.size(), 1));
		this.setBorder(BorderFactory.createTitledBorder("Inbentarioa:"));
		this.inbentarioaAktualizatu();
	}
	public void inbentarioaAktualizatu(){
		inbentarioa = new JButton[inb.size()];
		for(int i=0; i<inb.size(); i++){
			inbentarioa[i] = new JButton();
			inbentarioa[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			String izena=inb.get(i);
			inbentarioa[i].setName(izena.split(":")[1]);
			inbentarioa[i].setText(izena.split(":")[1].concat(":"+izena.split(":")[2]));
			inbentarioa[i].addActionListener(this);
			if(Integer.parseInt(izena.split(":")[0])!=fasea||Integer.parseInt(izena.split(": ")[1])<1){
				inbentarioa[i].setEnabled(false);
			}else if((UrriGorriaUI.getObjektua().equals(inb.get(i).split(":")[1]))){
				inbentarioa[i].setBackground(new Color(175, 255, 175));
			}
			this.add(inbentarioa[i]);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String sourceText=(String)((JButton)e.getSource()).getName();
		UrriGorriaUI.getUrriGorriaUI().objektuaAldatu((sourceText));
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();		
	}
}