package frontend;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import negozioLogika.Partida;

public class InbentarioaUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> inb = new ArrayList<>();
	private JButton[] inbentarioa;

	public InbentarioaUI(String jokalaria) {
		ArrayList<String> inb = Partida.inbentarioaEman(jokalaria);
		inbentarioa = new JButton[inb.size()];
		this.setLayout(new GridLayout(inb.size(), 1));
		for(int i=0; i<inb.size(); i++){
			inbentarioa[i] = new JButton(inb.get(i));
			inbentarioa[i].setName(inb.get(i));
			this.add(inbentarioa[i]);
		}
	}
}