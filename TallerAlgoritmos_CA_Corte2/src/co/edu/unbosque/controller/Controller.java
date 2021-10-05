package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.Highlighter;


import co.edu.unbosque.model.OperacionArchivo;
import co.edu.unbosque.view.PanelBuscar;
import co.edu.unbosque.view.PanelOpciones;
import co.edu.unbosque.view.PanelPrincipal;
import co.edu.unbosque.view.VentanaPrincipal;

/**
 * Clase Controller
 * 
 * @author Brayan Moreno Andres Nuñez Miguel Sierra Sergio Gomez
 * 
 */
public class Controller implements ActionListener {

	private OperacionArchivo operacionArchivo;

	private VentanaPrincipal ventanaPrincipal;
	private PanelPrincipal panelPrincipal;
	private PanelOpciones panelOpciones;
	private PanelBuscar panelBuscar;

	/**
	 * Constructor del controller inicialización de variables
	 */
	public Controller() {
		operacionArchivo = new OperacionArchivo();
		ventanaPrincipal = new VentanaPrincipal();
		panelPrincipal = new PanelPrincipal();
		panelOpciones = new PanelOpciones();
		panelBuscar = new PanelBuscar();
	
		listener(this);
	}

	/**
	 * Metodo para obtener los eventos de los botones
	 * 
	 * @param escuchador
	 */
	private void listener(ActionListener escuchador) {
		// Boton volver
		panelBuscar.getBotonVolver().addActionListener(escuchador);
		panelBuscar.getBotonBM().addActionListener(escuchador);
		panelBuscar.getBotonKMP().addActionListener(escuchador);
		// Ventana Principal
		ventanaPrincipal.getBotonOpciones().addActionListener(escuchador);
		// Panel Opciones
		panelOpciones.getBotonElegirArchivo().addActionListener(escuchador);
		panelOpciones.getBotonBuscar().addActionListener(escuchador);

	}
	/**
	 * Metodo para ejecutar la logica de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object botonPulsado = e.getSource();

		if (botonPulsado == ventanaPrincipal.getBotonOpciones()) {
			ventanaPrincipal.setContentPane(panelOpciones);
			ventanaPrincipal.validate();
		}
		if (botonPulsado == panelOpciones.getBotonElegirArchivo()) {
			JFileChooser selectorArchivos = new JFileChooser();
			selectorArchivos.showOpenDialog(selectorArchivos);

			try {
				String patch = selectorArchivos.getSelectedFile().getAbsolutePath();
				String contenido = operacionArchivo.leerArchivo(patch);
//				panelBuscar.getTabla()
				panelBuscar.getTabla().setText(contenido);
			} catch (Exception error) {
				// TODO: handle exception
				System.out.println(error);
			}

		}

		if (botonPulsado == panelOpciones.getBotonBuscar()) {
			ventanaPrincipal.setContentPane(panelBuscar);
			ventanaPrincipal.validate();
		}

		if (botonPulsado == panelBuscar.getBotonVolver()) {
			ventanaPrincipal.setContentPane(panelOpciones);
			ventanaPrincipal.validate();
		}
		if (botonPulsado == panelBuscar.getBotonKMP()) {
			
			Highlighter h = panelBuscar.getTabla().getHighlighter();
			h.removeAllHighlights();
			String contendio =  panelBuscar.getTabla().getText();
			String cadenaBuscar = panelBuscar.getCampoTexto().getText();
			
			
			
			for(int j = 0; j < contendio.length(); j++) {
				
			}
			
			JOptionPane.showMessageDialog(null, "holap");
		}
		if (botonPulsado == panelBuscar.getBotonBM()) {
			JOptionPane.showMessageDialog(null, "holawas");
		}

	}

}
