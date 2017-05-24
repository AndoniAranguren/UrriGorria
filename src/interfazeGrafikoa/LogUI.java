package interfazeGrafikoa;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.text.html.parser.Parser; //<br> a jartzeko, hau da bi lerroko JButtonak

import interfazeGrafikoa.properties.Hizkuntza;

@SuppressWarnings("unused")
public class LogUI extends JPanel{

	private static final long serialVersionUID = 1L;
	private String jokalaria=null;
	private JButton[] BattleLoga;
	private ArrayList<String> loga = new ArrayList<>();
	private Hizkuntza h;
	private int komandoKop;
	private final int zenbatKomandoErakutsi=14;


	public LogUI(String pIzena, String hizkuntza) {
		h = new Hizkuntza(hizkuntza);
		jokalaria=pIzena;
		loga = UrriGorriaUI.getUrriGorriaUI().logaEman(jokalaria);
		komandoKop=-1;
		this.setLayout(new GridLayout(zenbatKomandoErakutsi, 1));
		this.setBorder(BorderFactory.createTitledBorder("Log:"));
		this.setPreferredSize(new Dimension(UrriGorriaUI.getLeihoaH()/3, UrriGorriaUI.getLeihoaH()*75/100));
		this.logaAktualizatu();
	}
	public void logaAktualizatu(){
		BattleLoga = new JButton[loga.size()];
		int i=(loga.size()-zenbatKomandoErakutsi <0 ? 0 : loga.size()-zenbatKomandoErakutsi);
		
		while(i<loga.size()){
			
			String[] info=loga.get(i).split("#")[0].split("'");
			
			String izena=h.getIzena(info[1]);
			
			String[] komInfo=loga.get(i).split("#")[1].split("'");
			String komIzena=h.getProperty(komInfo[0]);
			


				
			
			if(!komInfo[0].equals("CommandItsasontziaIpini")){
				java.awt.Color c=UrriGorriaUI.getUrriGorriaUI().getKolorea(info[1]);
				String obj=komInfo[1];
				if(obj.contains("x")){
						System.out.println("badakuka" +obj);
						obj=(h.getProperty(obj.split("x")[0]).concat("x"+obj.split("x")[1]));
				}else
					obj=h.getProperty(obj);
				obj=(!komInfo[1].equals("Ezer")?" ("+obj+")" :" ");
				
				BattleLoga[i] = new JButton();
				BattleLoga[i].setBackground(c);
				BattleLoga[i].setForeground(UrriGorriaUI.getUrriGorriaUI().getKolorKontraste(c));
				BattleLoga[i].setName(komandoKop+"");
				BattleLoga[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
				
				BattleLoga[i].setText("<html>("+info[0]+") "+izena+"<br>"+komIzena+obj +"</html>");
				BattleLoga[i].addActionListener(e->
					UrriGorriaUI.getUrriGorriaUI().komandoaAtzera(komandoKop-Integer.parseInt((
								(Component) e.getSource()).getName())));
				komandoKop++;
				this.add(BattleLoga[i]);
			}
			i++;
		}
	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		int zenbatgarrena=);
//		
//	}
}
