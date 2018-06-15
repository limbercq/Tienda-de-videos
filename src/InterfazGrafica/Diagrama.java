package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Diagrama extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private void inicio() {
		Inicio i=new Inicio();
		i.setVisible(true);
		this.dispose();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diagrama frame = new Diagrama();
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
	public Diagrama() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicio();
			}

			
		});
		btnInicio.setIcon(new ImageIcon(Diagrama.class.getResource("/img/Principal.png")));
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(new Font("Sylfaen", Font.BOLD, 20));
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBounds(10, 574, 152, 87);
		contentPane.add(btnInicio);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(Diagrama.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Sylfaen", Font.BOLD, 20));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBounds(622, 563, 152, 87);
		contentPane.add(btnCerrar);
		
		JLabel diagrama = new JLabel("");
		diagrama.setIcon(new ImageIcon(Diagrama.class.getResource("/img/Main2.png")));
		diagrama.setBounds(20, 11, 764, 661);
		contentPane.add(diagrama);
		
		JLabel lblNewLabel = new JLabel("Diagrama Uml");
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblNewLabel.setBounds(179, 117, 381, 93);
		contentPane.add(lblNewLabel);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Diagrama.class.getResource("/img/fondo.jpg")));
		fondo.setBounds(0, 0, 794, 672);
		contentPane.add(fondo);
	}
}
