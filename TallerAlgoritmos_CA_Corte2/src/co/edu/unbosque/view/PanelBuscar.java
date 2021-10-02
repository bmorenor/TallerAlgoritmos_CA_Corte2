package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelBuscar extends JPanel {
	 CampoTexto campoTexto;
	private JButton botonBM;
	private JButton botonKMP;
	private JButton botonVolver;
	private JTable tabla;

	private DefaultTableModel mod;
	
	public PanelBuscar() {
		  setLayout(null);
		  
		  //Caracteristicas Tabla
		  
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

			tabla = new JTable(mod);
			

			JScrollPane scroll = new JScrollPane(tabla);
			TableColumnModel columnModel = tabla.getColumnModel();

			tabla.getTableHeader().setReorderingAllowed(false);
			tabla.getTableHeader().setResizingAllowed(false);

			//tabla.setDefaultRenderer(Object.class, miRender);
			scroll.setBounds(423, 200, 350, 350);

		  
		// campo texto valor de apuesta
			campoTexto = new CampoTexto();
			campoTexto.setBounds(169, 123, 425, 49);
		    //Caracteristicas del boton BM
		  botonBM = new JButton ();
		  botonBM.setBorderPainted(false);
		  botonBM.setContentAreaFilled(false);
		  botonBM.setBounds(623, 113, 208, 65);
		    
		  //Caracteristicas del boton KMP
		  botonKMP = new JButton ();
		  botonKMP.setBorderPainted(false);
		  botonKMP.setContentAreaFilled(false);
		  botonKMP.setBounds(865, 113, 120, 65);
		 

		  //Caracteristicas del boton Volver
		  botonVolver = new JButton ();
		  botonVolver.setBorderPainted(false);
		  botonVolver.setContentAreaFilled(false);
		  botonVolver.setBounds(93, 485, 65, 65);
		
		    
		    //Agregamos los botones al panel
		    add(botonBM);
		    add(botonKMP);
		    add(botonVolver);
		    add(campoTexto);
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
	
	
}