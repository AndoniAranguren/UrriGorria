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

import negozioLogika.Itsasontzia;
import negozioLogika.Mapa;
import negozioLogika.ObjektuakFactory;
import negozioLogika.Partida;
import negozioLogika.commands.CommandItsasontziaIpini;

public class TableroaUI extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private String jokalaria;
	private JButton[][] tableroa;
	private static final int zut = Mapa.zut;
	private static final int erren = Mapa.erren;
	
	public TableroaUI(String pIzena, Color c) {
		jokalaria=pIzena;
		this.setLayout(new GridLayout(zut, erren));
		this.setBorder(new TitledBorder(new LineBorder(c), pIzena + "ren tableroa", 1, 2, null, c));
		tableroa = new JButton[zut][erren];
		this.tableroaHasieratu();
//		this.setSize(1, 1);
	}
	
	private void tableroaHasieratu() {
		for(int i=0; i<zut; i++){
			for(int j=0; j<erren; j++){
				tableroa[i][j] = new JButton(new ImageIcon(TableroaUI.class.getResource("/externals/ura.png")));
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
		String[][] mapa=Partida.mapaInterpretatu(jokalaria, jokalaria);
		for(int i=0; i<zut; i++){
			for(int j=0; j<erren; j++){
				if(mapa[i][j].equals("Itsasontzi")) aux="/externals/ontzia.png";
				else aux="/externals/ura.png";
				tableroa[i][j].setBorderPainted(false);
				tableroa[i][j].setIcon((new ImageIcon(TableroaUI.class.getResource(aux))));
				this.add(tableroa[i][j]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		JButton botoia = (JButton) e.getSource();
//		int x = Integer.parseInt(botoia.getName().substring(0,1));
//		int y = Integer.parseInt(botoia.getName().substring(2));
//		//botoia.setEnabled(false);
//		new CommandItsasontziaIpini(jokalaria,(Itsasontzia)ObjektuakFactory.getObjektuakFactory().createObjektua("Itsaspeko"), x, y, 'N');
//		tableroaEguneratu();
		JButton botoia = (JButton) e.getSource();
		int x = Integer.parseInt(botoia.getName().substring(0,1));
		int y = Integer.parseInt(botoia.getName().substring(2));
		//botoia.setEnabled(false);
		if(UrriGorriaUI.getUrriGorriaUI().objektuaEman()!="Ezer"){
			char norabidea;
			switch (UrriGorriaUI.getUrriGorriaUI().norabideaLortu()){
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
			info[0]=UrriGorriaUI.getUrriGorriaUI().objektuaEman();
			info[1]=(""+x);
			info[2]=(""+y);
			info[3]=(""+norabidea);
			System.out.println(info[0]+ info[1] + info[2] + info[3]);
			UrriGorriaUI.getUrriGorriaUI().objektuaErabili(jokalaria,info);
			UrriGorriaUI.getUrriGorriaUI().objektuaAldatu("Ezer");
			tableroaEguneratu();
			UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
		}
	}
}
