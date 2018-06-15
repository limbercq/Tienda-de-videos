package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codigo.Archivo_Pelicula;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDuracion;
	private JTextField textIdioma;
	private JTextField textPrecio;
	private JTextField textFecha;
	private JTextField textNro;
	private JTextField textCodigo;
	JButton btnInicio = new JButton("  Inicio");
	JButton btnAtras = new JButton("  Atras");
	JComboBox comboTipo = new JComboBox();
	private void mouseClicked1(MouseEvent e) {
		Inicio i=new Inicio();
		i.setVisible(true);
		this.setVisible(false);
	}
	private void Limpiar() {
		textFecha.setText("");
		textNombre.setText("");
		textDuracion.setText("");
		textPrecio.setText("");
		textIdioma.setText("");
		textNro.setText("");
		textCodigo.setText("");
		comboTipo.setSelectedIndex(0);
		
	}		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws ClassNotFoundException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitulo = new JLabel("Agregar Pelicula");
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(new Font("Vivaldi", Font.PLAIN, 36));
		lbTitulo.setBounds(269, 11, 341, 57);
		contentPane.add(lbTitulo);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblNombre.setBounds(43, 79, 92, 19);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblPrecio.setBounds(43, 252, 81, 19);
		contentPane.add(lblPrecio);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		textNombre.setBackground(Color.BLACK);
		textNombre.setForeground(Color.WHITE);
		textNombre.setOpaque(false);
		textNombre.setBounds(145, 79, 262, 27);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel label = new JLabel("Duracion");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Vivaldi", Font.BOLD, 25));
		label.setBounds(43, 134, 92, 19);
		contentPane.add(label);
		
		JLabel lblFechaDeEstreno = new JLabel("Fecha de estreno");
		lblFechaDeEstreno.setForeground(Color.WHITE);
		lblFechaDeEstreno.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblFechaDeEstreno.setBounds(444, 134, 162, 19);
		contentPane.add(lblFechaDeEstreno);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setForeground(Color.WHITE);
		lblIdioma.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblIdioma.setBounds(43, 194, 81, 19);
		contentPane.add(lblIdioma);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblTipo.setBounds(444, 252, 81, 19);
		contentPane.add(lblTipo);
		
		JLabel lblNroDeCopias = new JLabel("Nro de Copias");
		lblNroDeCopias.setForeground(Color.WHITE);
		lblNroDeCopias.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblNroDeCopias.setBounds(444, 194, 150, 19);
		contentPane.add(lblNroDeCopias);
		
		textDuracion = new JTextField();
		textDuracion.setFont(new Font("Tahoma", Font.BOLD, 15));
		textDuracion.setDisabledTextColor(Color.WHITE);
		textDuracion.setForeground(Color.WHITE);
		textDuracion.setOpaque(false);
		textDuracion.setColumns(10);
		textDuracion.setBounds(145, 134, 196, 27);
		contentPane.add(textDuracion);
		
		textIdioma = new JTextField();
		textIdioma.setFont(new Font("Tahoma", Font.BOLD, 15));
		textIdioma.setForeground(Color.WHITE);
		textIdioma.setOpaque(false);
		textIdioma.setColumns(10);
		textIdioma.setBounds(145, 194, 262, 27);
		contentPane.add(textIdioma);
		
		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPrecio.setForeground(Color.WHITE);
		textPrecio.setOpaque(false);
		textPrecio.setColumns(10);
		textPrecio.setBounds(145, 252, 196, 27);
		contentPane.add(textPrecio);
		
		textFecha = new JTextField();
		textFecha.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFecha.setForeground(Color.WHITE);
		textFecha.setOpaque(false);
		textFecha.setColumns(10);
		textFecha.setBounds(629, 134, 162, 27);
		contentPane.add(textFecha);
		
		textNro = new JTextField();
		textNro.setFont(new Font("Tahoma", Font.BOLD, 15));
		textNro.setForeground(Color.WHITE);
		textNro.setOpaque(false);
		textNro.setColumns(10);
		textNro.setBounds(629, 194, 116, 27);
		contentPane.add(textNro);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		textCodigo.setOpaque(false);
		textCodigo.setForeground(Color.WHITE);
		textCodigo.setColumns(10);
		textCodigo.setBounds(629, 82, 162, 27);
		contentPane.add(textCodigo);
		
		
		comboTipo.setOpaque(false);
		comboTipo.setForeground(Color.BLACK);
		comboTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboTipo.setBounds(622, 237, 169, 34);
		contentPane.add(comboTipo);
		comboTipo.addItem(" Seleccione");
		comboTipo.addItem(" Infantiles");
		comboTipo.addItem("	Navideños");
		comboTipo.addItem(" Accion");
		comboTipo.addItem(" XXX");
		comboTipo.addItem(" Terror");
		comboTipo.addItem(" Romance");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClicked1(e);
			}
		});
		
		
		btnAtras.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		
		btnAtras.setIcon(new ImageIcon(Formulario.class.getResource("/img/atras.png")));
		btnAtras.setOpaque(false);
		btnAtras.setBounds(49, 317, 156, 80);
		contentPane.add(btnAtras);
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClicked1(e);
			}
		});
		
		
		
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		btnInicio.setIcon(new ImageIcon(Formulario.class.getResource("/img/Principal.png")));
		btnInicio.setOpaque(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setBounds(255, 317, 162, 80);
		contentPane.add(btnInicio);
		
		JButton btnGuardar = new JButton("  Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			String vect[]=new String[7];			
			public void actionPerformed(ActionEvent e) {
				if(!Comprobacion()) {					
					if(validar()) {
//					Archivo
						Archivo_Pelicula a =new Archivo_Pelicula("Pelicula.dat");
												
						try {
							a.Adicionar(vect, comboTipo.getSelectedIndex());
							JOptionPane.showMessageDialog(null, "Se guardo correctamente", "\tExito", 3);
							a.Listar();
							Limpiar();
						} catch (ClassNotFoundException | IOException e2) {
							
							System.out.println("mal arch Pel");
						}						
						
					}else 
						JOptionPane.showMessageDialog(null, "Los campos Duracion, Precio, Nro de Copias Tienen que ser numeros", "\tError", 0);
					
				}else 
					JOptionPane.showMessageDialog(null, "Todos los campos Tienen que ser llenados", "\tError", 0);
				
				
				//
			}			
			private boolean validar() {
				boolean sw=true;
				for(int i=4;i<7;i++) {				
					if(isNumericInt(vect[i])==false | isNumericDoub(vect[i])==false) 
						sw=false;						
				}
				return sw;
			}

			private boolean Comprobacion() {				
				vect[0]=textNombre.getText();
				vect[1]=textIdioma.getText();
				vect[2]=textFecha.getText();
				vect[3]=textCodigo.getText();
				vect[4]=textPrecio.getText();				
				vect[5]=textDuracion.getText();
				vect[6]=textNro.getText();
				boolean sw=false;
				for(int i=0;i<7;i++) {
					if(vect[i].equals(""))
						sw=true;
				}
				if(comboTipo.getSelectedIndex()==0)
					sw=true;
				return sw;
			}
			private boolean isNumericInt(String cad){
				try {
					Integer.parseInt(cad);					
					return true;
				} catch (NumberFormatException nfe){
					return false;
				}
			}
			private boolean isNumericDoub(String cad){
				try {
					Double.parseDouble(cad);					
					return true;
				} catch (NumberFormatException nfe){
					return false;
				}
			}
			
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		btnGuardar.setIcon(new ImageIcon(Formulario.class.getResource("/img/guardar.png")));
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setBounds(622, 325, 169, 64);
		contentPane.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("  Limpiar");
		btnLimpiar.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setIcon(new ImageIcon(Formulario.class.getResource("/img/limpiar.png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiar();
			}

			
		});
		btnLimpiar.setOpaque(false);
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.setBounds(444, 333, 166, 48);
		contentPane.add(btnLimpiar);
		
		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setForeground(Color.WHITE);
		lblMinutos.setFont(new Font("Vivaldi", Font.BOLD, 20));
		lblMinutos.setBounds(342, 140, 92, 19);
		contentPane.add(lblMinutos);
		
		JLabel lblBs = new JLabel("Bs.");
		lblBs.setForeground(Color.WHITE);
		lblBs.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblBs.setBounds(351, 260, 66, 19);
		contentPane.add(lblBs);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblCodigo.setBounds(433, 85, 162, 19);
		contentPane.add(lblCodigo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setForeground(Color.BLACK);
		lblFondo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblFondo.setIcon(new ImageIcon(Formulario.class.getResource("/img/fondo.jpg")));
		lblFondo.setBounds(0, 0, 855, 417);
		contentPane.add(lblFondo);
	}
}
