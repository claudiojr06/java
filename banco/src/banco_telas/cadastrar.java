package banco_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import codigo.controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numero;
	private JTextField nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrar frame = new cadastrar();
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
	public cadastrar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(173, 70, 185));
		contentPane_1.setBounds(0, 0, 434, 261);
		contentPane.add(contentPane_1);
		
		JLabel lblCadastrarPessoa = new JLabel("Cadastrar Pessoa");
		lblCadastrarPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarPessoa.setForeground(Color.WHITE);
		lblCadastrarPessoa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblCadastrarPessoa.setBounds(10, 11, 414, 37);
		contentPane_1.add(lblCadastrarPessoa);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBounds(20, 59, 137, 14);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNumeroDaConta = new JLabel("Numero da Conta:");
		lblNumeroDaConta.setForeground(new Color(255, 255, 255));
		lblNumeroDaConta.setBounds(20, 102, 118, 14);
		contentPane_1.add(lblNumeroDaConta);
		
		numero = new JTextField();
		numero.setBounds(127, 99, 189, 20);
		contentPane_1.add(numero);
		numero.setColumns(10);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(127, 57, 189, 20);
		contentPane_1.add(nome);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controller.cadUse(nome.getText(), Integer.parseInt(numero.getText())) == true ) {
					menu m = new menu();
					m.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(116, 155, 101, 23);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu m = new menu();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(227, 155, 89, 23);
		contentPane_1.add(btnNewButton_1);

	}
}
