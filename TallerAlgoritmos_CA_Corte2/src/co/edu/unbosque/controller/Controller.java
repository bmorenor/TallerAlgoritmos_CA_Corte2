package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import co.edu.unbosque.view.PanelBuscar;
import co.edu.unbosque.view.PanelOpciones;
import co.edu.unbosque.view.PanelPrincipal;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	private PanelPrincipal panelPrincipal;
	private PanelOpciones panelOpciones;
	private PanelBuscar panelBuscar;

	public Controller() {
		ventanaPrincipal = new VentanaPrincipal();
		panelPrincipal = new PanelPrincipal();
		panelOpciones = new PanelOpciones();
		panelBuscar= new PanelBuscar();


		listenerPanelOpciones(this);
		listenerVentanaPrincipal(this);
		listenerPanelBuscar(this);
	}

	private void listenerPanelBuscar(ActionListener escuchador) {
		panelBuscar.getBotonVolver().addActionListener(escuchador);
		
	}

	private void listenerVentanaPrincipal(ActionListener escuchador) {
		ventanaPrincipal.getBotonOpciones().addActionListener(escuchador);
		
	}

	private void listenerPanelOpciones(ActionListener escuchador) {
		panelOpciones.getBotonElegirArchivo().addActionListener(escuchador);
		panelOpciones.getBotonBuscar().addActionListener(escuchador);

	}

//	private void listenerPanelPrincipal(ActionListener escuchador) {
//
//		panelPrincipal.getBotonOpciones().addActionListener(escuchador);
//		panelPrincipal.getBotonOpciones().getActionListeners();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
			Object botonPulsado = e.getSource();
		
		if (botonPulsado==ventanaPrincipal.getBotonOpciones()) {
			ventanaPrincipal.setContentPane(panelOpciones);
			ventanaPrincipal.validate();
		}
		if (botonPulsado==panelOpciones.getBotonElegirArchivo()) {
			JFileChooser selectorArchivos = new JFileChooser();
			selectorArchivos.showOpenDialog(selectorArchivos);
			
		}
		
		if (botonPulsado==panelOpciones.getBotonBuscar()) {
			ventanaPrincipal.setContentPane(panelBuscar);
			ventanaPrincipal.validate();
		}
		
		if (botonPulsado==panelBuscar.getBotonVolver()) {
			ventanaPrincipal.setContentPane(panelOpciones);
			ventanaPrincipal.validate();
		}

	}



}
