package frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import negozioLogika.Partida;

public class InbentarioaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria = null;
	private JButton[] inbentario;
	ArrayList<String> inb = new ArrayList<>();
	
	public InbentarioaUI(String pIzena) {
		jokalaria=pIzena;
		inb = Partida.dendaEman(jokalaria);
		inbentario = new JButton[inb.size()];
		this.setLayout(new GridLayout(inb.size(), 1));
		this.inbentarioaHasieratu();
	}
	
	private void inbentarioaHasieratu() {
		for(int i=0; i<inb.size(); i++){
			inbentario[i] = new JButton();
			inbentario[i].setName(inb.get(i));
			inbentario[i].setText(inb.get(i));
			inbentario[i].addActionListener(this);
//			inbentario[i].setIcon(new ImageIcon(TableroaUI.class.getResource("/externals/ontzia.png")));
			this.add(inbentario[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
