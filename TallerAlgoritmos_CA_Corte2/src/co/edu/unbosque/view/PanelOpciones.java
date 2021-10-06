package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Clase para la vista del panel Opciones
 * @author Brayan Moreno Andres Nuñez Miguel Sierra Sergio Gomez
 *
 */
public class PanelOpciones extends JPanel{
	/**
	 * Se declaran los componentes
	 */
	 private JButton botonElegirArchivo;
	  private JButton botonBuscar;
	  
	    /**
	     * Constructor principal de la  clase
	     */
	    public PanelOpciones() {
	    setLayout(null);
	    /**
	     * Caracteristicas del boton ElegirArchivo
	     */
	    botonElegirArchivo = new JButton ();
	    botonElegirArchivo.setBorderPainted(false);
	    botonElegirArchivo.setContentAreaFilled(false);
	    botonElegirArchivo.setBounds(435, 225, 247, 65);
	    
	  /**
	   * Caracteristicas del boton buscar
	   */
	    botonBuscar = new JButton ();
	    botonBuscar.setBorderPainted(false);
	    botonBuscar.setContentAreaFilled(false);
	    botonBuscar.setBounds(435, 360, 247, 65);
	 
	
	    
	    /**
	     * Agregamos los componentes al panel
	     */
	    
	    add(botonBuscar);
	    add(botonElegirArchivo);
	    
	    }
	    /**
	     * Metodo para pintar el panel con la imagen
	     */
   
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Image fondo = new ImageIcon(getClass().getResource("/Imagenes/PanelOpciones.jpg")).getImage();
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

	}
	/**
	 *  Setters y getters de los componentes
	 */
/**
 *
 * @return
 */
	public JButton getBotonElegirArchivo() {
		return botonElegirArchivo;
	}
/**
 * 
 * @param botonElegirArchivo
 */
	public void setBotonElegirArchivo(JButton botonElegirArchivo) {
		this.botonElegirArchivo = botonElegirArchivo;
	}
/**
 * 
 * @return
 */
	public JButton getBotonBuscar() {
		return botonBuscar;
	}
/**
 * 
 * @param botonBuscar
 */
	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}
}
