package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class CampoTexto extends JTextField {
	/**
	 * Metodo encargado de insertar un campo donde se va a ingresar el texto
	 */
	Image fondo = new ImageIcon(getClass().getResource("/Imagenes/CampoTexto.png")).getImage();
	float porcentajeTamanoLetra;
	/**
	 * Metodo encargado de posicionar el campo texto
	 */
	public CampoTexto() {
		setBounds(0, 0, 300, 30);
		setOpaque(false);
		this.porcentajeTamanoLetra = 0.5f;
	}
	/**
	 * Metodo encargado de regular el tamano de la letra
	 * @param porcentajeTama�oLetra
	 */
	public CampoTexto(float porcentajeTamanoLetra) {
		setBounds(0, 0, 300, 30);
		setOpaque(false);
		this.porcentajeTamanoLetra = porcentajeTamanoLetra;
	}
	/**
	 * Metodo encargado de pintar el componente
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
		super.paintComponent(g);
		int width = this.getWidth();
		int height = this.getHeight();
		setBorder(BorderFactory.createEmptyBorder(0, (int) (width * 0.05), 0, (int) (width * 0.05)));
		setFont(new Font(getFont().getFontName(), getFont().getStyle(), (int) (height * porcentajeTamanoLetra)));

	}

}
