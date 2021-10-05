package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {
	private JButton botonOpciones;
	public VentanaPrincipal() {
		PanelPrincipal fondo = new PanelPrincipal();
		fondo.setLayout(null);
		
		botonOpciones = new JButton ();
		botonOpciones.setBorderPainted(false);
		botonOpciones.setContentAreaFilled(false);
		botonOpciones.setSize(1130, 636);
		/**
		 * Se inicializan los componentes 
		 * <b>pre</b>Se debe indicar nombre  y tipo
		 * <b>post</b>Se inicializan los componentes para su buen usos<br>
		 * @param componentes dependen de cual se use
		 */
	
	
		setSize(1130, 636);
	
		setContentPane(fondo);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(botonOpciones);
	}
	public JButton getBotonOpciones() {
		return botonOpciones;
	}
	public void setBotonOpciones(JButton botonOpciones) {
		this.botonOpciones = botonOpciones;
	}
	 public void mostrarError(String mensaje) {
	        JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	    }

		/**
		 * Este metodo permite mostrar un mensaje informativo en el programa
		 * <b>pre</b> inicializar vista principal<br>
		 * <b>post</b> Se devuelve un mensaje  <br>
		 * @param mensaje Este es un string donde se almcena el mensaje que se quiere mostrar al usuario
		 */
	 public void mostrarMensaje(String mensaje) {
	        JOptionPane.showMessageDialog(null, mensaje);
	    }   
	
	
}
