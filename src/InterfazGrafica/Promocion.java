package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Codigo.Archivo_Pelicula;
import Codigo.Archivo_Promo;
import Codigo.Pelicula;
import Codigo.Promociones;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Promocion extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	private void inicio() {
		Inicio i=new Inicio();
		i.setVisible(true);
		this.setVisible(false);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Promocion frame = new Promocion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Promocion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPromociones = new JLabel("Promociones");
		lblPromociones.setBounds(315, 5, 231, 49);
		lblPromociones.setFont(new Font("Vivaldi", Font.PLAIN, 40));
		contentPane.add(lblPromociones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 832, 326);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"#", "codigo", "Nombre", "Duracion", "Idioma", "Fecha Estreno", "Tipo", "Precio", "Nro de Copias"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		table.getColumnModel().getColumn(2).setPreferredWidth(142);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(73);
		table.getColumnModel().getColumn(5).setPreferredWidth(62);
		table.getColumnModel().getColumn(7).setPreferredWidth(43);
		table.getColumnModel().getColumn(8).setPreferredWidth(30);
		scrollPane.setViewportView(table);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicio();
			}

			
		});
		btnInicio.setBounds(76, 59, 135, 57);
		btnInicio.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnInicio.setContentAreaFilled(false);
		btnInicio.setOpaque(false);
		btnInicio.setIcon(new ImageIcon(Promocion.class.getResource("/img/Principal.png")));
		contentPane.add(btnInicio);
		
		JButton btnGenerarPromociones = new JButton("Generar Promociones");
	btnGenerarPromociones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cerrar();
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
			}
			public void cerrar() throws ClassNotFoundException, IOException{
				Object [] opciones ={"Aceptar","Cancelar"};
				int eleccion = JOptionPane.showOptionDialog(rootPane,"Se eliminar las anteriores promciones desea continuar","Mensaje de Confirmacion",
				JOptionPane.WARNING_MESSAGE,
				JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
				if (eleccion == JOptionPane.YES_OPTION){
					Archivo_Pelicula a =new Archivo_Pelicula("Pelicula.dat");
					Archivo_Promo pro=new Archivo_Promo("Promociones.dat");
					pro.Adicionar(a.Listar());
				}else{
				}
			}
		});
		btnGenerarPromociones.setBounds(315, 59, 231, 57);
		btnGenerarPromociones.setOpaque(false);
		btnGenerarPromociones.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnGenerarPromociones.setContentAreaFilled(false);
		contentPane.add(btnGenerarPromociones);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).setNumRows(0);
				Archivo_Promo a=new Archivo_Promo("Promociones.dat");				
				try {
					Promociones prom =new Promociones();
					prom = a.Listar();
					Pelicula p[];
					System.out.println(prom.getProm12().length);
					p=prom.getProm1();
					mes(1);
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(2);
					p=prom.getProm2();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(3);
					p=prom.getProm3();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(4);
					p=prom.getProm4();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					p=prom.getProm5();					
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(6);
					p=prom.getProm6();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					p=prom.getProm7();					
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(8);
					p=prom.getProm8();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(9);
					p=prom.getProm9();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(10);
					p=prom.getProm10();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(11);
					p=prom.getProm11();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
					mes(12);
					p=prom.getProm12();
					for (int i=0;i<p.length;i++) {					
						int nroCols = table.getModel().getColumnCount();						
						Object [] fila =new Object[nroCols];
						fila[0]= (i+1);
						fila[1] = p[i].getCod();
						fila[2] = p[i].getNombre();
						fila[3] = p[i].getDuracion();
						fila[4] = p[i].getIdioma();
						fila[5] = p[i].getFechaEstr();
						fila[6] = tipo(p[i].getTipo());
						fila[7] = p[i].getPrecio();
						fila[8] = p[i].getNroCop();
						((DefaultTableModel)table.getModel()).addRow(fila);
					}
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			private void mes(int i) {
				int nroCols = table.getModel().getColumnCount();						
				Object [] fila;
				fila=new Object[nroCols];
				fila[0]= "";
				fila[1] = "";
				fila[2] = "";
				fila[3] = "";
				fila[4] = "";
				fila[5] = "";
				fila[6] ="";
				fila[7] = "";
				fila[8] = "";
				((DefaultTableModel)table.getModel()).addRow(fila);
				
				nroCols = table.getModel().getColumnCount();						
				fila =new Object[nroCols];
				fila[0]= "";
				fila[1] = "";
				fila[2] = "";
				fila[3] = "";
				fila[4] = NomMes(i);
				fila[5] = "";
				fila[6] ="";
				fila[7] = "";
				fila[8] = "";
				((DefaultTableModel)table.getModel()).addRow(fila);
				
				nroCols = table.getModel().getColumnCount();						
				fila =new Object[nroCols];
				fila[0]= "";
				fila[1] = "";
				fila[2] = "";
				fila[3] = "";
				fila[4] = "";
				fila[5] = "";
				fila[6] ="";
				fila[7] = "";
				fila[8] = "";
				((DefaultTableModel)table.getModel()).addRow(fila);
				
			}
			private String NomMes(int i) {
				switch(i) {
				case 1: return "ENERO";
				case 2: return "FEBRERO";
				case 3: return "MARZO";
				case 4: return "ABRIL";
				case 5: return "MAYO";
				case 6: return "JUNIO";
				case 7: return "JULIO";
				case 8: return "AGOSTO";
				case 9: return "SEPTIEMBRE";
				case 10: return "OCTUBRE";
				case 11: return "NOVIEMBRE";
				case 12: return "DICIEMBRE";
				}
				return null;
				
			}
			private String tipo(int tipo) {
				
				switch(tipo) {
				case 1: return ("  Infantiles");
				case 2: return ("  Navideños");
				case 3: return ("  Accion");
				case 4: return ("  Terror");
				case 5: return ("  Terror");
				case 6: return ("  Romance");
				}
				return null;
				
			}
		});
		btnMostrar.setBounds(606, 59, 155, 57);
		btnMostrar.setOpaque(false);
		btnMostrar.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnMostrar.setContentAreaFilled(false);
		contentPane.add(btnMostrar);
		
		JLabel lblTodasLasPromociones = new JLabel("Todas las promociones del a\u00F1o");
		lblTodasLasPromociones.setBounds(325, 109, 184, 33);
		contentPane.add(lblTodasLasPromociones);
		
		
	}
}
