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

public class listar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField saldo;
	private JTextField nome;
	private JTextField depo;
	private JTextField saque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listar frame = new listar();
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
	public listar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1_1 = new JPanel();
		contentPane_1_1.setLayout(null);
		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1_1.setBackground(new Color(173, 70, 185));
		contentPane_1_1.setBounds(0, 0, 434, 261);
		contentPane.add(contentPane_1_1);
		
		JLabel lblListarConta = new JLabel("Listar Conta");
		lblListarConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarConta.setForeground(Color.WHITE);
		lblListarConta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblListarConta.setBounds(10, 0, 414, 37);
		contentPane_1_1.add(lblListarConta);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 85, 137, 14);
		contentPane_1_1.add(lblNewLabel_1);
		
		JLabel lblNumeroDaConta_1 = new JLabel("Numero da Conta:");
		lblNumeroDaConta_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNumeroDaConta_1.setBounds(10, 44, 118, 14);
		contentPane_1_1.add(lblNumeroDaConta_1);
		
		saldo = new JTextField();
		saldo.setEditable(false);
		saldo.setColumns(10);
		saldo.setBounds(127, 126, 202, 20);
		contentPane_1_1.add(saldo);
		
		nome = new JTextField();
		nome.setEditable(false);
		nome.setColumns(10);
		nome.setBounds(127, 83, 202, 20);
		contentPane_1_1.add(nome);
		
		JButton sair_1 = new JButton("Sair");
		sair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu m = new menu();
				m.setVisible(true);
				dispose();
			}
		});
		sair_1.setBackground(Color.RED);
		sair_1.setBounds(175, 210, 89, 23);
		contentPane_1_1.add(sair_1);
		
		JLabel sadasdasd = new JLabel("Depositos");
		sadasdasd.setFont(new Font("Tahoma", Font.ITALIC, 13));
		sadasdasd.setBounds(10, 170, 107, 14);
		contentPane_1_1.add(sadasdasd);

		depo = new JTextField();
		depo.setEditable(false);
		depo.setColumns(10);
		depo.setBounds(83, 168, 79, 20);
		contentPane_1_1.add(depo);
		
		saque = new JTextField();
		saque.setEditable(false);
		saque.setColumns(10);
		saque.setBounds(294, 168, 107, 20);
		contentPane_1_1.add(saque);
		
		JComboBox box = new JComboBox();
		box.setBounds(127, 40, 202, 22);
		contentPane_1_1.add(box);
		controller.List(box);
		
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.Lmov(box, nome, saldo, saque, depo);
				
			}
		});
		
		JLabel fvffdsf_1 = new JLabel("Saldo:");
		fvffdsf_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		fvffdsf_1.setBounds(10, 128, 107, 14);
		contentPane_1_1.add(fvffdsf_1);
		
		
		
		
		JLabel lblSaques = new JLabel("Saques");
		lblSaques.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblSaques.setBounds(209, 171, 107, 14);
		contentPane_1_1.add(lblSaques);

	}
}
