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
import Codigo.Pelicula;

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
		
		JLabel lblMostrar = new JLabel("Mostrar");
		lblMostrar.setFont(new Font("Vivaldi", Font.PLAIN, 40));
		lblMostrar.setBounds(305, 11, 179, 27);
		contentPane.add(lblMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(32, 71, 747, 336);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setOpaque(false);
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
		
		JButton btnClientes = new JButton("  Clientes");
		btnClientes.setOpaque(false);
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBounds(198, 421, 128, 50);
		contentPane.add(btnClientes);
		
		JButton btnTodo = new JButton("  Todo");
		btnTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Archivo_Pelicula a =new Archivo_Pelicula("Pelicula.dat");
				try {
					Pelicula p[]= new Pelicula[a.Listar().length];
					p=a.Listar();
					System.out.println("Tamaño   "+p.length);
					// resetea las filas
					((DefaultTableModel)table.getModel()).setNumRows(0);
					
					for (int i=0;i<p.length;i++) {
						p[i].mostrar();
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
		btnTodo.setOpaque(false);
		btnTodo.setContentAreaFilled(false);
		btnTodo.setBounds(648, 421, 128, 50);
		contentPane.add(btnTodo);
		
		JButton btnPromociones = new JButton("  Promociones");
		btnPromociones.setOpaque(false);
		btnPromociones.setContentAreaFilled(false);
		btnPromociones.setBounds(510, 421, 128, 50);
		contentPane.add(btnPromociones);
		
		JButton btnMasVendidos = new JButton("Mas vendidos");
		btnMasVendidos.setOpaque(false);
		btnMasVendidos.setContentAreaFilled(false);
		btnMasVendidos.setBounds(352, 421, 128, 50);
		contentPane.add(btnMasVendidos);
	}
}
