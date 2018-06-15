package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;

public class Inicio extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	private void addic() {
		Formulario f=new Formulario();
		f.setVisible(true);
		this.setVisible(false);
	}
	private void mostrar() {
		Mostrar m=new Mostrar();
		m.setVisible(true);
		this.setVisible(false);
	}
	private void promo() {
		Promocion p=new Promocion();
		p.setVisible(true);
		this.setVisible(false);
	}
	private void diagrama() {
		Diagrama d=new Diagrama();
		d.setVisible(true);
		this.setVisible(false);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JLabel lblTiendaDeVido = new JLabel("Tienda de Video");
		lblTiendaDeVido.setForeground(Color.WHITE);
		lblTiendaDeVido.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblTiendaDeVido.setBounds(149, 11, 306, 61);
		contentPane.add(lblTiendaDeVido);
		
		JButton btnPromociones = new JButton("Promociones");
		btnPromociones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				promo();
			}

			
		});
		btnPromociones.setForeground(Color.WHITE);
		btnPromociones.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnPromociones.setOpaque(false);
		btnPromociones.setContentAreaFilled(false);
		btnPromociones.setIcon(new ImageIcon(Inicio.class.getResource("/img/resultado.png")));
		btnPromociones.setBounds(341, 228, 236, 119);
		contentPane.add(btnPromociones);
		
		JButton btnAdiconar = new JButton("Adiconar");
		btnAdiconar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				addic();
			}
		});			
		btnAdiconar.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnAdiconar.setForeground(Color.WHITE);
		btnAdiconar.setIcon(new ImageIcon(Inicio.class.getResource("/img/base3.png")));
		btnAdiconar.setOpaque(false);
		btnAdiconar.setContentAreaFilled(false);
		btnAdiconar.setBounds(40, 83, 236, 119);
		contentPane.add(btnAdiconar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addMouseListener(new MouseAdapter() {
						
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrar();
			}
			
		});
		btnMostrar.setForeground(Color.WHITE);
		btnMostrar.setFont(new Font("Sylfaen", Font.BOLD, 20));
		
		btnMostrar.setIcon(new ImageIcon(Inicio.class.getResource("/img/rollo.png")));
		btnMostrar.setOpaque(false);
		btnMostrar.setContentAreaFilled(false);
		btnMostrar.setBounds(341, 83, 236, 119);
		contentPane.add(btnMostrar);
		
		JButton btnVender = new JButton("Diagrama");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diagrama();
			}

			
		});
		btnVender.setForeground(Color.WHITE);
		btnVender.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnVender.setIcon(new ImageIcon(Inicio.class.getResource("/img/adiconar2.png")));
		btnVender.setOpaque(false);
		btnVender.setContentAreaFilled(false);
		btnVender.setBounds(40, 228, 250, 119);
		contentPane.add(btnVender);
		
		JLabel lblNombre = new JLabel("                           Desa\u00F1ado por Limber Alberto ");
		lblNombre.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblNombre.setBounds(10, 354, 604, 25);
		contentPane.add(lblNombre);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Script MT Bold", Font.PLAIN, 11));
		lblFondo.setIcon(new ImageIcon(Inicio.class.getResource("/img/fondo.jpg")));
		lblFondo.setBounds(0, 0, 624, 379);
		contentPane.add(lblFondo);
	}
}
