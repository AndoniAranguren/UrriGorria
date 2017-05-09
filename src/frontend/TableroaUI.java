package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import negozioLogika.Itsasontzia;
import negozioLogika.Mapa;
import negozioLogika.ObjektuakFactory;
import negozioLogika.Partida;
import negozioLogika.commands.CommandItsasontziaIpini;
import negozioLogika.interfaces.UGKonstanteak;

public class TableroaUI extends JPanel implements UGKonstanteak, ActionListener {
	private static final long serialVersionUID = 1L;
	private String jokalaria;
	private JButton[][] tableroa;
	private JButton[] inbentario;
	private static final int tamaina = Mapa.tamaina;
	private JPanel pMapa= new JPanel(), pInbentarioa= new JPanel();
	
	public TableroaUI(String pIzena) {
		jokalaria=pIzena;
		ArrayList<String> inb=Partida.dendaEman(jokalaria);
		
//		pInbentarioa.setLayout(new BoxLayout(pInbentarioa,BoxLayout.Y_AXIS));
		pInbentarioa.setLayout(new GridLayout(inb.size(), 1));
		pMapa.setLayout(new GridLayout(tamaina, tamaina));
//		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		tableroa = new JButton[tamaina][tamaina];
		inbentario = new JButton[inb.size()];
		
		for(int i=0; i<inb.size(); i++){
			inbentario[i] = new JButton();
			inbentario[i].setName(inb.get(i));
			inbentario[i].setText(inb.get(i));
			inbentario[i].addActionListener(this);
			inbentario[i].setIcon(new ImageIcon(TableroaUI.class.getResource("/externals/ontzia.png")));
			pInbentarioa.add(inbentario[i]);
		}
		for(int i=0; i<tamaina; i++){
			for(int j=0; j<tamaina; j++){
				tableroa[i][j] = new JButton();
				tableroa[i][j].setName(i + "-" + j);
				tableroa[i][j].addActionListener(this);
				tableroa[i][j].setIcon(new ImageIcon(TableroaUI.class.getResource("/externals/ura.png")));
				pMapa.add(tableroa[i][j]);
			}
		}
		this.add(pMapa, BorderLayout.PAGE_START);
		this.add(pInbentarioa, BorderLayout.PAGE_END);
	}
	private void tableroaEguneratu(){
		Partida.getPartida();
		String aux="/externals/ura.png";
		String[][] mapa=Partida.mapaInterpretatu(jokalaria, jokalaria);
		for(int i=0; i<tamaina; i++){
			for(int j=0; j<tamaina; j++){
				if(mapa[i][j].equals("Ura")) aux="/externals/ura.png";
				else if(mapa[i][j].equals("Itsasontzi")) aux="/externals/ontzia.png";
				tableroa[i][j].setIcon(new ImageIcon(TableroaUI.class.getResource(aux)));
				pMapa.add(tableroa[i][j]);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botoia = (JButton) e.getSource();
		int x = Integer.parseInt(botoia.getName().substring(0,1));
		int y = Integer.parseInt(botoia.getName().substring(2));
		//botoia.setEnabled(false);
		new CommandItsasontziaIpini(jokalaria,(Itsasontzia)ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspeko"), x, y, 'N');
		tableroaEguneratu();
	}

}
