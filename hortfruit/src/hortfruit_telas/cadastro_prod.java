package hortfruit_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hortifruit_bd.bd;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class cadastro_prod extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField preco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro_prod frame = new cadastro_prod();
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
	public cadastro_prod() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 216);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(46, 49, 82, 29);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setBounds(145, 54, 132, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setFont(new Font("Arial", Font.BOLD, 15));
		lblPreo.setBounds(46, 85, 108, 29);
		contentPane.add(lblPreo);
		
		preco = new JTextField();
		preco.setColumns(10);
		preco.setBounds(145, 90, 132, 20);
		contentPane.add(preco);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setFont(new Font("Arial", Font.BOLD, 12));
		sair.setBounds(160, 125, 117, 29);
		contentPane.add(sair);
		
		JButton cadastro = new JButton("Cadastro");
		cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bd.insert_produto(nome.getText(),Float.parseFloat(preco.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		cadastro.setFont(new Font("Arial", Font.BOLD, 12));
		cadastro.setBounds(31, 125, 117, 29);
		contentPane.add(cadastro);
		
		JLabel Produtos = new JLabel("Produtos");
		Produtos.setHorizontalAlignment(SwingConstants.CENTER);
		Produtos.setFont(new Font("Arial Black", Font.PLAIN, 17));
		Produtos.setBounds(60, 3, 188, 40);
		contentPane.add(Produtos);

	}
}
