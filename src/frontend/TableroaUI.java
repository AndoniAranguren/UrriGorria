package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import negozioLogika.Mapa;
import negozioLogika.Partida;
import properties.Hizkuntza;

public class TableroaUI extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private String jokalaria;
	private JButton[][] tableroa;
	String[][] mapa;
	private Hizkuntza h;
	
	public TableroaUI(String pIzena, Color c, String hizkuntza) {
		h = new Hizkuntza(hizkuntza);
		jokalaria=pIzena;
		mapa=UrriGorriaUI.mapaInterpretatu(pIzena);
		this.setLayout(new GridLayout(mapa.length, mapa[0].length));
		this.setBorder(new TitledBorder(new LineBorder(c), h.getProperty(pIzena) + " " + h.getProperty("tableroa"), 1, 2, null, c));
		tableroa = new JButton[mapa.length][mapa[0].length];
		this.tableroaHasieratu();
	}
	
	private void tableroaHasieratu() {
		for(int i=0; i<mapa.length; i++){
			for(int j=0; j<mapa[0].length; j++){
				tableroa[i][j] = new JButton(new ImageIcon(TableroaUI.class.getResource("/externals/ezezaguna.png")));
				tableroa[i][j].setBorderPainted(false);
				tableroa[i][j].setName(i + "-" + j);
				tableroa[i][j].addActionListener(this);
				this.add(tableroa[i][j]);
			}
		}
		tableroaEguneratu();
	}
	
	private void tableroaEguneratu(){
		Partida.getPartida();
		String aux="/externals/ura.png";
		for(int i=0; i<mapa.length; i++){
			for(int j=0; j<mapa[1].length; j++){
				if(mapa[i][j].equals("Itsasontzi")) aux="/externals/ontzia.png";
				else if(mapa[i][j].equals("Ura")) aux="/externals/ura.png";
				else if(mapa[i][j].equals("Ezezaguna"))aux="/externals/ezezaguna.png";
				else if(mapa[i][j].equals("Suntzituta"))aux="/externals/red.png";
				tableroa[i][j].setBorderPainted(false);
				tableroa[i][j].setIcon((new ImageIcon(TableroaUI.class.getResource(aux))));
				this.add(tableroa[i][j]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton botoia = (JButton) e.getSource();
		int x = Integer.parseInt(botoia.getName().substring(0,1));
		int y = Integer.parseInt(botoia.getName().substring(2));
		if(UrriGorriaUI.getObjektua()!="Ezer"){
			char norabidea;
			switch (UrriGorriaUI.norabideaLortu()){
				case 0: norabidea='E';
					break;
				case 1: norabidea='S';
					break;
				case 2: norabidea='W';
					break;
				case 3: norabidea='N';
					break;
				default: norabidea='E';
					break;
			}
			String[] info= new String[4];
			info[0]=UrriGorriaUI.getObjektua();
			info[1]=(""+x);
			info[2]=(""+y);
			info[3]=(""+norabidea);
			UrriGorriaUI.getUrriGorriaUI().objektuaErabili(jokalaria,info);
			UrriGorriaUI.getUrriGorriaUI().objektuaAldatu("Ezer");
			tableroaEguneratu();
			UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
		}
	}
}
