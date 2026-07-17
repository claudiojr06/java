package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		JButton cadastro = new JButton("Cadastro de Paciente");
		cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cad = new Cadastro();
				cad.setVisible(true);
			}
		});
		cadastro.setBounds(10, 51, 414, 23);
		contentPane.add(cadastro);
		
		JButton consulta = new JButton("Consulta de paciente");
		consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta con = new consulta();
				con.setVisible(true);
			}
		});
		consulta.setBounds(10, 170, 414, 23);
		contentPane.add(consulta);
		
		JButton lista = new JButton("Lista de Paciente");
		lista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar lis = new listar();
				lis.setVisible(true);
			
			}
		});
		lista.setBounds(10, 111, 414, 23);
		contentPane.add(lista);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(174, 227, 89, 23);
		contentPane.add(sair);

	}
}
