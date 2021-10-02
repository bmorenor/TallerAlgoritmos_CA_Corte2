package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	public PanelPrincipal(){

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Image fondo = new ImageIcon(getClass().getResource("/Imagenes/FondoPrincipal.gif")).getImage();
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

	}


}
