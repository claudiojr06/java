package governo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import hospital_telas.convenio;

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
		
		JButton cadastrar = new JButton("cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro cad = new cadastro();
				cad.setVisible(true);
			}
		});
		cadastrar.setBounds(169, 40, 115, 23);
		contentPane.add(cadastrar);
		
		JButton buscar = new JButton("buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar bus = null;
				try {
					bus = new buscar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bus.setVisible(true);
			}
		});
		buscar.setBounds(169, 102, 115, 23);
		contentPane.add(buscar);
		
		JButton listar = new JButton("listar");
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
		listar.setBounds(169, 170, 115, 23);
		contentPane.add(listar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(169, 227, 115, 23);
		contentPane.add(sair);

	}
}
