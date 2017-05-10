package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
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
	private static final int zut = Mapa.zut;
	private static final int erren = Mapa.erren;
	private JPanel pTableroa= new JPanel(), pInbentarioa= new JPanel();
	ArrayList<String> inb = new ArrayList<>();
	
	public TableroaUI(String pIzena) {
		jokalaria=pIzena;
		this.setLayout(new GridLayout(zut, erren));
//		inb = Partida.dendaEman(jokalaria);
//		inbentario = new JButton[inb.size()];
//		pInbentarioa.setLayout(new GridLayout(inb.size(), 1));
		
		tableroa = new JButton[zut][erren];
//		pTableroa.setLayout(new GridLayout(zut, erren));
		
//		this.inbentarioaHasieratu();
		this.tableroaHasieratu();
//		this.add(pInbentarioa, BorderLayout.PAGE_END);
	}
	
	private void inbentarioaHasieratu() {
		for(int i=0; i<inb.size(); i++){
			inbentario[i] = new JButton();
			inbentario[i].setName(inb.get(i));
			inbentario[i].setText(inb.get(i));
			inbentario[i].addActionListener(this);
			inbentario[i].setIcon(new ImageIcon(TableroaUI.class.getResource("/externals/ontzia.png")));
			pInbentarioa.add(inbentario[i]);
		}
	}
	
	private void tableroaHasieratu() {
		for(int i=0; i<zut; i++){
			for(int j=0; j<erren; j++){
				tableroa[i][j] = new JButton();
				tableroa[i][j].setName(i + "-" + j);
				tableroa[i][j].addActionListener(this);
				tableroa[i][j].setIcon(new ImageIcon(TableroaUI.class.getResource("/externals/ura.png")));	
				this.add(tableroa[i][j]);
			}
		}
	}
	
	private Image iconScaled(String icon) {
		Dimension size = tableroa[0][0].getSize();
		int height = (int) size.getHeight();
		System.out.println(height);
		int width = (int) size.getWidth();
		ImageIcon icona = new ImageIcon(TableroaUI.class.getResource(icon));
		Image imga = icona.getImage();
		Image imgb = imga.getScaledInstance(width, height, java.awt.Image.SCALE_FAST);
		return imgb;
	}
	
	private void tableroaEguneratu(){
		Partida.getPartida();
		String aux="/externals/ura.png";
		String[][] mapa=Partida.mapaInterpretatu(jokalaria, jokalaria);
		for(int i=0; i<zut; i++){
			for(int j=0; j<erren; j++){
				if(mapa[i][j].equals("Ura")) aux="/externals/ura.png";
				else if(mapa[i][j].equals("Itsasontzi")) aux="/externals/ontzia.png";
				tableroa[i][j].setIcon(new ImageIcon(TableroaUI.class.getResource(aux)));
				pTableroa.add(tableroa[i][j]);
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
