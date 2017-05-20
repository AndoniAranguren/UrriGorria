package interfazeGrafikoa;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfazeGrafikoa.externals.Irudiak;
import interfazeGrafikoa.properties.*;

public class TableroaUI extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private String jokalaria;
	private JButton[][] tableroa;
	private String[][] mapa;
	private Hizkuntza h;
	
	public TableroaUI(String pIzena, String hizkuntza) {
		h = new Hizkuntza(hizkuntza);
		jokalaria=pIzena;
		String izena=h.getIzena(jokalaria);
		mapa=UrriGorriaUI.mapaInterpretatu(pIzena);
		this.setLayout(new GridLayout(mapa.length, mapa[0].length));
		this.setPreferredSize(new java.awt.Dimension(UrriGorriaUI.getLeihoaW()/2,UrriGorriaUI.getLeihoaW()/2));

		java.awt.Color c=UrriGorriaUI.getUrriGorriaUI().getKolorea(pIzena);
		
		this.setBorder(new TitledBorder(new LineBorder(c), izena+h.getProperty("tableroa"), 1, 2, null, c));
		tableroa = new JButton[mapa.length][mapa[0].length];
		this.tableroaHasieratu();
	}
	
	private void tableroaHasieratu() {
		for(int i=0; i<mapa.length; i++){
			for(int j=0; j<mapa[0].length; j++){
				tableroa[i][j] = new JButton(Irudiak.getIrudiak().imaginaLortu("ezezaguna.png"));
				tableroa[i][j].setBorderPainted(false);
				tableroa[i][j].setName(i + "-" + j);
				tableroa[i][j].addActionListener(this);
				this.add(tableroa[i][j]);
			}
		}
		tableroaEguneratu();
	}
	
	private void tableroaEguneratu(){
		String aux="ezezaguna.png";
		for(int i=0; i<mapa.length; i++){
			for(int j=0; j<mapa[1].length; j++){
				if(mapa[i][j].equals("Itsasontzi")) aux="ontzia.png";
				else if(mapa[i][j].equals("Ura")) aux="ura.png";
				else if(mapa[i][j].equals("Ezezaguna"))aux="ezezaguna.png";
				else if(mapa[i][j].equals("Suntzituta"))aux="ondoratuta.png";
				else if(mapa[i][j].equals("Ukituta"))aux="red.png";
				else if(mapa[i][j].equals("Ezkutua"))aux="ezkutua.png";
				
				tableroa[i][j].setBorderPainted(false);
				tableroa[i][j].setIcon((Irudiak.getIrudiak().imaginaLortu(aux)));
				this.add(tableroa[i][j]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton botoia = (JButton) e.getSource();
		int x = Integer.parseInt(botoia.getName().substring(0,1));
		int y = Integer.parseInt(botoia.getName().substring(2));
		if(UrriGorriaUI.getUrriGorriaUI().getObjektua()!="Ezer"){
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
			info[0]=UrriGorriaUI.getUrriGorriaUI().getObjektua();
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
