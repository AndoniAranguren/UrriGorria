package frontend;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TableroaGUI extends JPanel {
	
	private KasilaGUI[][] kasilak = new KasilaGUI[10][10];
	private int kontF = 0;
	private int kontS = 0;
	private int kontI = 0;
	private int kontH = 0;
	
	public TableroaGUI() {
		
		tableroaEraiki();
	}

	private void tableroaEraiki(){
		setLayout(new GridLayout(10, 10));
		for(int x=0; x<10; x++){
			for(int y=0; y<10; y++){
				KasilaGUI k = new KasilaGUI(x,y);
				kasilak[x][y] = k;
				add(k);
			}
		}
	}

	public void ontziakKokatu(KasilaGUI k, int x, int y){
		
		String ontzia = UrriGorriaUI.getLehioa().getOntzia().ontziaBueltatu();
		String norabidea = UrriGorriaUI.getLehioa().getOntzia().norabideaBueltatu();
		if(ontzia.equals("fragata") && kontF<4){
			k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/silver.png")));
			kontF++;
		}else if(ontzia.equals("suntsitzailea") && kontS<3){
			if(norabidea.equals("horizontala")){	
				try{
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/silver.png")));
					kasilak[x][y+1].setIcon(new ImageIcon(kasilak[x][y+1].getClass().getResource("/baliabideak/silver.png")));
					kontS++;
				}catch(IndexOutOfBoundsException e){
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/bluel.png")));
				}				
			} else{
				try{
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/silver.png")));
					kasilak[x+1][y].setIcon(new ImageIcon(kasilak[x+1][y].getClass().getResource("/baliabideak/silver.png")));
					kontS++;
				}catch(IndexOutOfBoundsException e){
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/bluel.png")));
				}
			}
			System.out.println(kontS);
		}else if(ontzia.equals("itsaspekoa") && kontI<2){
			if(norabidea.equals("horizontala")){				
				try{
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/silver.png")));
					kasilak[x][y+1].setIcon(new ImageIcon(kasilak[x][y+1].getClass().getResource("/baliabideak/silver.png")));
					kasilak[x][y+2].setIcon(new ImageIcon(kasilak[x][y+2].getClass().getResource("/baliabideak/silver.png")));
					kontI++;
				}catch(IndexOutOfBoundsException e){
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/bluel.png")));
					try{	
						kasilak[x][y+1].setIcon(new ImageIcon(kasilak[x][y+1].getClass().getResource("/baliabideak/bluel.png")));
					}catch(IndexOutOfBoundsException ex){}
				}
			} else{
				try{
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/silver.png")));
					kasilak[x+1][y].setIcon(new ImageIcon(kasilak[x+1][y].getClass().getResource("/baliabideak/silver.png")));
					kasilak[x+2][y].setIcon(new ImageIcon(kasilak[x+2][y].getClass().getResource("/baliabideak/silver.png")));
					kontI++;
				}catch(IndexOutOfBoundsException e){
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/bluel.png")));
					try{
						kasilak[x+1][y].setIcon(new ImageIcon(kasilak[x+1][y].getClass().getResource("/baliabideak/bluel.png")));
					}catch(IndexOutOfBoundsException ex){}
				}
			}
		}else if(ontzia.equals("hegazkinOntzia") && kontH<1){
			if(norabidea.equals("horizontala")){				
				try{
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/silver.png")));
					kasilak[x][y+1].setIcon(new ImageIcon(kasilak[x][y+1].getClass().getResource("/baliabideak/silver.png")));
					kasilak[x][y+2].setIcon(new ImageIcon(kasilak[x][y+2].getClass().getResource("/baliabideak/silver.png")));
					kasilak[x][y+3].setIcon(new ImageIcon(kasilak[x][y+3].getClass().getResource("/baliabideak/silver.png")));
					kontH++;
				}catch(IndexOutOfBoundsException e){
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/bluel.png")));
					try{
						kasilak[x][y+1].setIcon(new ImageIcon(kasilak[x][y+1].getClass().getResource("/baliabideak/bluel.png")));
					}catch(IndexOutOfBoundsException ex){}
					try{
						kasilak[x][y+2].setIcon(new ImageIcon(kasilak[x][y+2].getClass().getResource("/baliabideak/bluel.png")));
					}catch(IndexOutOfBoundsException ex){}
				}
			} else{
				try{
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/silver.png")));
					kasilak[x+1][y].setIcon(new ImageIcon(kasilak[x+1][y].getClass().getResource("/baliabideak/silver.png")));
					kasilak[x+2][y].setIcon(new ImageIcon(kasilak[x+2][y].getClass().getResource("/baliabideak/silver.png")));
					kasilak[x+3][y].setIcon(new ImageIcon(kasilak[x+3][y].getClass().getResource("/baliabideak/silver.png")));
					kontH++;
				}catch(IndexOutOfBoundsException e){
					k.setIcon(new ImageIcon(k.getClass().getResource("/baliabideak/bluel.png")));
					try{
						kasilak[x+1][y].setIcon(new ImageIcon(kasilak[x+1][y].getClass().getResource("/baliabideak/bluel.png")));
					}catch(IndexOutOfBoundsException ex){}
					try{
						kasilak[x+2][y].setIcon(new ImageIcon(kasilak[x+2][y].getClass().getResource("/baliabideak/bluel.png")));
					}catch(IndexOutOfBoundsException ex){}
				}
			}
		}
	}
}
