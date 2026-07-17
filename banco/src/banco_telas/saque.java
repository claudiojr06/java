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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class saque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField saldo;
	private JTextField nome;
	private JTextField quantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saque frame = new saque();
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
	public saque() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(216, 10, 1, 1);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(173, 70, 185));
		contentPane.add(contentPane_1);
		
		JLabel lblDepositar = new JLabel("Depositar");
		lblDepositar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositar.setForeground(Color.WHITE);
		lblDepositar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblDepositar.setBounds(10, 0, 414, 37);
		contentPane_1.add(lblDepositar);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 85, 137, 14);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNumeroDaConta = new JLabel("Numero da Conta:");
		lblNumeroDaConta.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNumeroDaConta.setBounds(10, 44, 118, 14);
		contentPane_1.add(lblNumeroDaConta);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(127, 126, 202, 20);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 83, 202, 20);
		contentPane_1.add(textField_1);
		
		JButton depositar = new JButton("Depositar");
		depositar.setBackground(Color.GREEN);
		depositar.setBounds(108, 207, 101, 23);
		contentPane_1.add(depositar);
		
		JButton sair = new JButton("Sair");
		sair.setBackground(Color.RED);
		sair.setBounds(240, 207, 89, 23);
		contentPane_1.add(sair);
		
		JComboBox numero_conta = new JComboBox();
		numero_conta.setBounds(127, 40, 202, 22);
		contentPane_1.add(numero_conta);
		
		JLabel fvffdsf = new JLabel("Saldo:");
		fvffdsf.setFont(new Font("Tahoma", Font.ITALIC, 13));
		fvffdsf.setBounds(10, 128, 107, 14);
		contentPane_1.add(fvffdsf);
		
		JLabel lblDepositar_1 = new JLabel("Depositar:");
		lblDepositar_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblDepositar_1.setBounds(10, 170, 107, 14);
		contentPane_1.add(lblDepositar_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 168, 202, 20);
		contentPane_1.add(textField_2);
		
		JPanel contentPane_1_1 = new JPanel();
		contentPane_1_1.setLayout(null);
		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1_1.setBackground(new Color(173, 70, 185));
		contentPane_1_1.setBounds(0, 0, 434, 261);
		contentPane.add(contentPane_1_1);
		
		JLabel s = new JLabel("Sacar");
		s.setHorizontalAlignment(SwingConstants.CENTER);
		s.setForeground(Color.WHITE);
		s.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		s.setBounds(10, 0, 414, 37);
		contentPane_1_1.add(s);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 85, 137, 14);
		contentPane_1_1.add(lblNewLabel_1);
		
		JLabel lblNumeroDaConta_1 = new JLabel("Numero da Conta:");
		lblNumeroDaConta_1.setForeground(new Color(255, 255, 255));
		lblNumeroDaConta_1.setBackground(new Color(255, 255, 255));
		lblNumeroDaConta_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNumeroDaConta_1.setBounds(10, 44, 118, 14);
		contentPane_1_1.add(lblNumeroDaConta_1);
		
		saldo = new JTextField();
		saldo.setEditable(false);
		saldo.setColumns(10);
		saldo.setBounds(127, 126, 202, 20);
		contentPane_1_1.add(saldo);
		
		JComboBox box = new JComboBox();
		box.setBounds(127, 40, 202, 22);
		contentPane_1_1.add(box);
		
		controller.List(box);
		
		nome = new JTextField();
		nome.setEditable(false);
		nome.setColumns(10);
		nome.setBounds(127, 83, 202, 20);
		contentPane_1_1.add(nome);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.mov(Integer.parseInt(box.getSelectedItem().toString()),Integer.parseInt(quantidade.getText()), false);
			}
		});
		btnSacar.setBackground(Color.GREEN);
		btnSacar.setBounds(108, 207, 101, 23);
		contentPane_1_1.add(btnSacar);
		
		JButton sair_1 = new JButton("Sair");
		sair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu m = new menu();
				m.setVisible(true);
				dispose();
			}
		});
		sair_1.setBackground(Color.RED);
		sair_1.setBounds(240, 207, 89, 23);
		contentPane_1_1.add(sair_1);
		
		
		
		JLabel fvffdsf_1 = new JLabel("Saldo:");
		fvffdsf_1.setForeground(new Color(255, 255, 255));
		fvffdsf_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		fvffdsf_1.setBounds(10, 128, 107, 14);
		contentPane_1_1.add(fvffdsf_1);
		
		JLabel dsdas = new JLabel("Sacar:");
		dsdas.setForeground(new Color(255, 255, 255));
		dsdas.setFont(new Font("Tahoma", Font.ITALIC, 13));
		dsdas.setBounds(10, 170, 107, 14);
		contentPane_1_1.add(dsdas);
		
		quantidade = new JTextField();
		quantidade.setColumns(10);
		quantidade.setBounds(127, 168, 202, 20);
		contentPane_1_1.add(quantidade);
		
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.LL(box, nome, saldo);
			}
		});

	}

}
