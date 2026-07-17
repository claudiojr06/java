package empresa_funcionario_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.Color;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cadastrar = new JButton("Cadastrar Funcionários");
		cadastrar.setForeground(new Color(255, 255, 255));
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar cad = new cadastrar();
				cad.setVisible(true);
			}
		});
		cadastrar.setBackground(new Color(0, 0, 128));
		cadastrar.setBounds(130, 36, 171, 23);
		contentPane.add(cadastrar);
		
		JButton listar = new JButton("Listar Funcionarios");
		listar.setForeground(new Color(255, 255, 255));
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
		listar.setBackground(new Color(0, 0, 128));
		listar.setBounds(130, 116, 171, 23);
		contentPane.add(listar);
		
		JButton demitir = new JButton("Demitir Funcionarios");
		demitir.setForeground(new Color(255, 255, 255));
		demitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demitir dem = new demitir();
				dem.setVisible(true);
			}
		});
		demitir.setBackground(new Color(0, 0, 128));
		demitir.setBounds(130, 197, 171, 23);
		contentPane.add(demitir);

	}
}
