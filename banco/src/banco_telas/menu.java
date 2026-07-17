package banco_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 209);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 70, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NuLiso");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 37);
		contentPane.add(lblNewLabel);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setBackground(new Color(0, 255, 0));
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadastrar cad = new cadastrar();
				cad.setVisible(true);
				dispose();
			}
		});
		cadastrar.setBounds(95, 51, 101, 23);
		contentPane.add(cadastrar);
		
		JButton movimentar = new JButton("Movimentar");
		movimentar.setBackground(new Color(0, 255, 0));
		movimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movimentar mov = new movimentar();
				mov.setVisible(true);	
				dispose();
			}
		});
		movimentar.setBounds(236, 51, 101, 23);
		contentPane.add(movimentar);
		
		JButton listar = new JButton("Listar");
		listar.setBackground(new Color(0, 255, 0));
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar lis = new listar();
				lis.setVisible(true);
				dispose();
			}
		});
		listar.setBounds(177, 95, 89, 23);
		contentPane.add(listar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBackground(new Color(255, 0, 0));
		sair.setBounds(177, 136, 89, 23);
		contentPane.add(sair);

	}
}
