package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Codigo.Archivo_Pelicula;
import Codigo.Archivo_Promo;
import Codigo.Pelicula;
import Codigo.Promociones;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mostrar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	private  void inic() {
		Inicio i=new Inicio();
		i.setVisible(true);
		this.dispose();
	}
	private void diagrama() {
		Diagrama d=new Diagrama();
		d.setVisible(true);
		this.setVisible(false);
		
	}
	private String tipo(int tipo) {
		
		switch(tipo) {
		case 1: return ("  Infantiles");
		case 2: return ("  Navideños");
		case 3: return ("  Accion");
		case 4: return ("  XXX");
		case 5: return ("  Terror");
		case 6: return ("  Romance");
		}
		return null;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mostrar frame = new Mostrar();
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
	public Mostrar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMostrar = new JLabel("        Mostrar");
		lblMostrar.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblMostrar.setBounds(264, 11, 387, 40);
		contentPane.add(lblMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(32, 71, 747, 336);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"#", "codigo", "Nombre", "Duracion", "Idioma", "Fecha Estreno", "Tipo", "Precio", "Nro de Copias"
			}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		table.getColumnModel().getColumn(2).setPreferredWidth(142);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(73);
		table.getColumnModel().getColumn(5).setPreferredWidth(62);
		table.getColumnModel().getColumn(7).setPreferredWidth(43);
		table.getColumnModel().getColumn(8).setPreferredWidth(30);
		scrollPane.setViewportView(table);
		
		JButton btnInicio = new JButton("  Inicio");
		btnInicio.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 inic();
			}
		});
		btnInicio.setOpaque(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setIcon(new ImageIcon(Mostrar.class.getResource("/img/Principal.png")));
		btnInicio.setBounds(32, 421, 128, 50);
		contentPane.add(btnInicio);
		
		JButton btnDiagrama = new JButton(" Diagrama");
		btnDiagrama.setIcon(new ImageIcon(Mostrar.class.getResource("/img/mostrar.png")));
		btnDiagrama.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnDiagrama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diagrama();
			}
		});
		btnDiagrama.setOpaque(false);
		btnDiagrama.setContentAreaFilled(false);
		btnDiagrama.setBounds(198, 421, 144, 50);
		contentPane.add(btnDiagrama);
		
		JButton btnTodo = new JButton("  Todo");
		btnTodo.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnTodo.setIcon(new ImageIcon(Mostrar.class.getResource("/img/mostrar 1.png")));
		btnTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMostrar.setText("Todas Las Peliculas");
				scrollPane.setVisible(true);				
				Archivo_Pelicula a =new Archivo_Pelicula("Pelicula.dat");
				try {
					Pelicula p[]= new Pelicula[a.Listar().length];
					p=a.Listar();					
					// resetea las filas
					((DefaultTableModel)table.getModel()).setNumRows(0);
					
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
				} catch (ClassNotFoundException | IOException e) {
					System.out.println("entro exp");
					
				} 				
				 
			}

			
		});
		
		btnTodo.setOpaque(false);
		btnTodo.setContentAreaFilled(false);
		btnTodo.setBounds(648, 421, 128, 50);
		contentPane.add(btnTodo);
		
		JButton btnPromociones = new JButton("  Promociones");
		btnPromociones.setIcon(new ImageIcon(Mostrar.class.getResource("/img/mostrar.png")));
		btnPromociones.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnPromociones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(true);
				lblMostrar.setText("Promociones por meses ");
				((DefaultTableModel)table.getModel()).setNumRows(0);
				Archivo_Promo a=new Archivo_Promo("Promociones.dat");				
				try {
					Promociones prom =new Promociones();
					prom = a.Listar();
					Pelicula p[];					
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
				case 4: return ("  XXX");
				case 5: return ("  Terror");
				case 6: return ("  Romance");
				}
				return null;
				
			}
		});
		btnPromociones.setOpaque(false);
		btnPromociones.setContentAreaFilled(false);
		btnPromociones.setBounds(510, 421, 154, 50);
		contentPane.add(btnPromociones);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnCerrar.setIcon(new ImageIcon(Mostrar.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBounds(352, 421, 128, 50);
		contentPane.add(btnCerrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Mostrar.class.getResource("/img/fondo.jpg")));
		lblFondo.setBounds(0, 0, 827, 491);
		contentPane.add(lblFondo);
	}
}
