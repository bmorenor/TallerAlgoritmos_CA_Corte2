package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelBuscar extends JPanel {
	
	CampoTexto campoTexto,campoTextoRepetidos;
	private JButton botonBM;
	private JButton botonKMP;
	private JButton botonVolver;
	private JTextArea tabla;
	private JRadioButton rbtnMayuscula,rbtnMinuscula,rbtnCombinada;

	private DefaultTableModel mod;

	public PanelBuscar() {
		setLayout(null);

		// Caracteristicas Tabla

		String[] cabezera = { "DATOS" };
		String datos[][] = {

		};

		mod = new DefaultTableModel(datos, cabezera) {
			public boolean isCellEditable(int filas, int columnas) {
				if (columnas == 7) {
					return true;
				} else {
					return false;
				}
			}

		};

//			tabla = new JTable(mod);

		tabla = new JTextArea();

		tabla.setBounds(350, 200, 500, 350);

		JScrollPane scroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(350, 200, 500, 350);
		tabla.setFont(new Font("Consolas", 0, 16));
		tabla.setEditable(false);

//			TableColumnModel columnModel = tabla.getColumnModel();

//			tabla.getTableHeader().setReorderingAllowed(false);
//			tabla.getTableHeader().setResizingAllowed(false);

		// tabla.setDefaultRenderer(Object.class, miRender);
//			texto.setBounds(423, 200, 350, 350);

		// campo texto Busqueda
		campoTexto = new CampoTexto();
		campoTexto.isEditable();
		campoTexto.setBounds(169, 123, 425, 49);

		// Caracteristicas del boton BM
		botonBM = new JButton();
		botonBM.setBorderPainted(false);
		botonBM.setContentAreaFilled(false);
		botonBM.setBounds(623, 113, 208, 65);

		// Caracteristicas del boton KMP
		botonKMP = new JButton();
		botonKMP.setBorderPainted(false);
		botonKMP.setContentAreaFilled(false);
		botonKMP.setBounds(865, 113, 120, 65);

		// Caracteristicas del boton Volver
		botonVolver = new JButton();
		botonVolver.setBorderPainted(false);
		botonVolver.setContentAreaFilled(false);
		botonVolver.setBounds(93, 485, 65, 65);

		// Caracteristicas del boton numero de veces que se repite
		campoTextoRepetidos = new CampoTexto();
		campoTextoRepetidos.setEditable(false);
		campoTextoRepetidos.setBounds(42, 266, 100, 50);
		
		// Caracteristicas de los radioboton Mayuscula
		rbtnMayuscula = new JRadioButton();
		rbtnMayuscula.setBorderPainted(false);
		rbtnMayuscula.setContentAreaFilled(false);
		
		rbtnMayuscula.setBounds(26, 344, 15, 10);
		// Caracteristicas de los radioboton Minuscula
		rbtnMinuscula = new JRadioButton();
		rbtnMinuscula.setBorderPainted(false);
		rbtnMinuscula.setContentAreaFilled(false);
		rbtnMinuscula.setBounds(26, 384, 15, 10);
		// Caracteristicas de los radioboton Combinadas
		rbtnCombinada = new JRadioButton();
		rbtnCombinada.setBorderPainted(false);
		rbtnCombinada.setContentAreaFilled(false);
		rbtnCombinada.setBounds(26, 424, 15, 10);

		// Agregamos los botones al panel
		add(botonBM);
		add(botonKMP);
		add(botonVolver);
		add(campoTexto);
		add(campoTextoRepetidos);
		add(rbtnMayuscula);
		add(rbtnMinuscula);
		add(rbtnCombinada);

		add(scroll);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Image fondo = new ImageIcon(getClass().getResource("/Imagenes/PanelBusqueda.jpg")).getImage();
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

	}

	public CampoTexto getCampoTexto() {
		return campoTexto;
	}

	public void setCampoTexto(CampoTexto campoTexto) {
		this.campoTexto = campoTexto;
	}

	public JButton getBotonBM() {
		return botonBM;
	}

	public void setBotonBM(JButton botonBM) {
		this.botonBM = botonBM;
	}

	public JButton getBotonKMP() {
		return botonKMP;
	}

	public void setBotonKMP(JButton botonKMP) {
		this.botonKMP = botonKMP;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}

//	public JTable getTabla() {
//		return tabla;
//	}
//
//
//	public void setTabla(JTable tabla) {
//		this.tabla = tabla;
//	}

	public DefaultTableModel getMod() {
		return mod;
	}

	public void setMod(DefaultTableModel mod) {
		this.mod = mod;
	}

	public JTextArea getTabla() {
		return tabla;
	}

	public void setTabla(JTextArea tabla) {
		this.tabla = tabla;
	}

}
