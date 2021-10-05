package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
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
	private static String contenido;
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
				String path = selectorArchivos.getSelectedFile().getAbsolutePath();
//				System.out.println(path.contains("txt"));

				if (validarFormato(path)) {

					contenido = operacionArchivo.leerArchivo(path);
					if (contenido.equals("")) {
						JOptionPane.showMessageDialog(null, "El archivo que escogió no tiene contenido");
						ventanaPrincipal.setContentPane(panelOpciones);
						ventanaPrincipal.validate();
					}
					panelBuscar.getTabla().setText(contenido);

				} else {
					ventanaPrincipal.mostrarError("Por favor revisar que el\narchivo escogido sea valido");
				}
//				panelBuscar.getTabla()

			} catch (Exception error) {
				// TODO: handle exception
				System.out.println(error);
			}

		}

		if (botonPulsado == panelOpciones.getBotonBuscar()) {

			try {

				if (!contenido.equals(null)) {

					ventanaPrincipal.setContentPane(panelBuscar);
					ventanaPrincipal.validate();

				} else {
					ventanaPrincipal.mostrarError("Por favor revisar que el\narchivo escogido sea valido");
					ventanaPrincipal.setContentPane(panelOpciones);
				}

			} catch (Exception a) {
				ventanaPrincipal.mostrarError("Por favor revisar que el\narchivo escogido sea valido");
				a.getSuppressed();

			}

		}

		if (botonPulsado == panelBuscar.getBotonVolver()) {
			ventanaPrincipal.setContentPane(panelOpciones);
			ventanaPrincipal.validate();
		}
		if (botonPulsado == panelBuscar.getBotonKMP()) {

			String cadenaBuscar = panelBuscar.getCampoTexto().getText();
			palabrasResaltadas(panelBuscar.getTabla(), cadenaBuscar, Color.YELLOW);

//			Highlighter h = panelBuscar.getTabla().getHighlighter();
//			h.removeAllHighlights();
//			String contendio = panelBuscar.getTabla().getText();
//			String cadenaBuscar = panelBuscar.getCampoTexto().getText();
//
//			for (int j = 0; j < contendio.length(); j++) {
//
//				
//				
//				char ch = contendio.charAt(j);
//				if(cadenaBuscar.indexOf(ch) >=0) {
//					try {
//						h.addHighlight(j, j+1, DefaultHighlighter.DefaultPainter);
//					}catch(BadLocationException ex) {
//						
//					}
//				}
//				
//			}

		}
		if (botonPulsado == panelBuscar.getBotonBM()) {
			String cadenaBuscar = panelBuscar.getCampoTexto().getText();
			palabrasResaltadas(panelBuscar.getTabla(), cadenaBuscar, Color.cyan);
		}

	}

	public static boolean validarFormato(String path) {
		;
		boolean respuesta = false;
		if (path.contains("txt") || path.contains("csv") || path.contains("properties") || path.contains("dat")) {
			respuesta = true;
		}

		return respuesta;
	}

	public void palabrasResaltadas(JTextArea area1, String texto, Color color) {
		if (texto.length() >= 1) {
			DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(
					color);
			Highlighter h = area1.getHighlighter();
			h.removeAllHighlights();
			String text = area1.getText();
			String caracteres = texto;
			Pattern p = Pattern.compile("(?i)" + caracteres);
			Matcher m = p.matcher(text);
			while (m.find()) {
				try {
					h.addHighlight(m.start(), m.end(), highlightPainter);
				} catch (BadLocationException ex) {
//                    Logger.getLogger(color.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} else {
			JOptionPane.showMessageDialog(area1, "la palabra a buscar no puede ser vacia");
		}
	}

}
