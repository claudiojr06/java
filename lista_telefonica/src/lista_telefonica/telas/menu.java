package lista_telefonica.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel eeeffd = new JLabel("MENU");
		eeeffd.setHorizontalAlignment(SwingConstants.CENTER);
		eeeffd.setBounds(10, 11, 414, 27);
		contentPane.add(eeeffd);
		
		JButton cadastrar = new JButton("Cadastrar Pessoa");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro cad = new cadastro();
				cad.setVisible(true);
			}
		});
		cadastrar.setBounds(168, 63, 134, 23);
		contentPane.add(cadastrar);
		
		JButton listar = new JButton("Listar Pessoa");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar lis = null;
				try {
					lis = new listar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lis.setVisible(true);
			}
		});
		listar.setBounds(168, 112, 134, 23);
		contentPane.add(listar);
		
		JButton editar = new JButton("Editar Pessoa");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar ed = null;
				try {
					ed = new editar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ed.setVisible(true);
			}
		});
		editar.setBounds(168, 166, 134, 23);
		contentPane.add(editar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(168, 212, 134, 23);
		contentPane.add(btnSair);

	}
}
