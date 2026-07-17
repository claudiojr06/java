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

public class depositar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					depositar frame = new depositar();
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
	public depositar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 277);
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
		
		JLabel lblDepositar = new JLabel("Depositar");
		lblDepositar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositar.setForeground(Color.WHITE);
		lblDepositar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblDepositar.setBounds(10, 0, 414, 37);
		contentPane_1.add(lblDepositar);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 85, 137, 14);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNumeroDaConta = new JLabel("Numero da Conta:");
		lblNumeroDaConta.setForeground(new Color(255, 255, 255));
		lblNumeroDaConta.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNumeroDaConta.setBounds(10, 44, 118, 14);
		contentPane_1.add(lblNumeroDaConta);
		
		saldo = new JTextField();
		saldo.setEditable(false);
		saldo.setColumns(10);
		saldo.setBounds(127, 126, 202, 20);
		contentPane_1.add(saldo);
		
		JComboBox box = new JComboBox();
		box.setBounds(127, 40, 202, 22);
		contentPane_1.add(box);
		
		controller.List(box);
		
		nome = new JTextField();
		nome.setEditable(false);
		nome.setColumns(10);
		nome.setBounds(127, 83, 202, 20);
		contentPane_1.add(nome);
		
		JButton depositar = new JButton("Depositar");
		depositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mov(Integer.parseInt(box.getSelectedItem().toString()),Integer.parseInt(quantidade.getText()), true);
			}
		});
		depositar.setBackground(Color.GREEN);
		depositar.setBounds(108, 207, 101, 23);
		contentPane_1.add(depositar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					menu m = new menu();
					m.setVisible(true);
					dispose();

			}
		});
		sair.setBackground(Color.RED);
		sair.setBounds(240, 207, 89, 23);
		contentPane_1.add(sair);
		
		
		JLabel fvffdsf = new JLabel("Saldo:");
		fvffdsf.setForeground(new Color(255, 255, 255));
		fvffdsf.setFont(new Font("Tahoma", Font.ITALIC, 13));
		fvffdsf.setBounds(10, 128, 107, 14);
		contentPane_1.add(fvffdsf);
		
		JLabel lblDepositar_1 = new JLabel("Depositar:");
		lblDepositar_1.setForeground(new Color(255, 255, 255));
		lblDepositar_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblDepositar_1.setBounds(10, 170, 107, 14);
		contentPane_1.add(lblDepositar_1);
		
		quantidade = new JTextField();
		quantidade.setColumns(10);
		quantidade.setBounds(127, 168, 202, 20);
		contentPane_1.add(quantidade);
		
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.LL(box, nome, saldo);
			}
		});

	}
}
