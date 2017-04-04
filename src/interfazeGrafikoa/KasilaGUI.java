package interfazeGrafikoa;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KasilaGUI extends JButton implements MouseListener{

	private int kx;
	private int ky;
	
	public KasilaGUI(int x, int y){
		
		kx = x;
		ky = y;
		addMouseListener(this);
		setIcon(new ImageIcon(KasilaGUI.class.getResource("/baliabideak/bluel.png")));
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		LeihoaGUI.getLehioa().getTableroa().ontziakKokatu(this, kx, ky);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
