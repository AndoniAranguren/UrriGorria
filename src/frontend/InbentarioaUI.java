package frontend;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import negozioLogika.Partida;

public class InbentarioaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria=null;
	private JButton[] inbentarioa;
	private ArrayList<String> inb = new ArrayList<>();


	public InbentarioaUI(String pIzena) {
		jokalaria=pIzena;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder("Inbentarioa:"));
		this.inbentarioaAktualizatu();
	}
	public void inbentarioaAktualizatu(){
		inb = Partida.inbentarioaEman(jokalaria);
		inbentarioa = new JButton[inb.size()];
		for(int i=0; i<inb.size(); i++){
			inbentarioa[i] = new JButton();
			inbentarioa[i].setName(inb.get(i));
			inbentarioa[i].setText(inb.get(i));
			inbentarioa[i].addActionListener(this);
//			if(Integer.parseInt(inb.get(i).split(": ")[1])<1){
//				inbentarioa[i].setEnabled(false);
//			}else if((UrriGorriaUI.getUrriGorriaUI().objektuaEman().equals(inb.get(i).split(": ")[0]))){
//				inbentarioa[i].setBackground(new Color(255, 175, 175));
//			}
			this.add(inbentarioa[i]);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String sourceText=(String)((JButton)e.getSource()).getText();
		UrriGorriaUI.getUrriGorriaUI().objektuaAldatu((sourceText.split(":")[0]));
//		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();		
	}
}