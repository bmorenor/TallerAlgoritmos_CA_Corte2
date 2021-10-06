package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Clase para la vista del panel principal
 *@author Brayan Moreno Andres Nuñez Miguel Sierra Sergio Gomez
 */
public class PanelPrincipal extends JPanel {
	/**
	 * Constructor principal de la clase
	 */
	public PanelPrincipal() {

	}

	/**
	 * Metodo para pintar el panel con el gif de inicio
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Image fondo = new ImageIcon(getClass().getResource("/Imagenes/FondoPrincipal.gif")).getImage();
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

	}

}
