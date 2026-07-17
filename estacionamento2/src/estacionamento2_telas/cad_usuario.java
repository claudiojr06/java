package estacionamento2_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import codigo.bd;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class cad_usuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField endereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cad_usuario frame = new cad_usuario();
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
	public cad_usuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(20, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		nome = new JTextField();
		nome.setBounds(90, 33, 334, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setBounds(20, 79, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		MaskFormatter cp=null;
		try {
			cp=new MaskFormatter("###.###.###-##");
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField cpf = new JFormattedTextField(cp);
		cpf.setBounds(90, 76, 334, 20);
		contentPane.add(cpf);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1_1.setBounds(20, 132, 46, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		MaskFormatter tel=null;
		try {
			tel=new MaskFormatter("(##)########");
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField telefone = new JFormattedTextField(tel);
		telefone.setBounds(90, 129, 334, 20);
		contentPane.add(telefone);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Endereço:");
		lblNewLabel_1_1_2.setBounds(20, 176, 60, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		endereco = new JTextField();
		endereco.setColumns(10);
		endereco.setBounds(90, 173, 334, 20);
		contentPane.add(endereco);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cpf.getText().contains(" ")) {
					  JOptionPane.showMessageDialog(null,
				                "CPF deve conter 11 números!");}
				else {
					
					
					if (telefone.getText().contains(" ")) {
						  JOptionPane.showMessageDialog(null,
					                "telefone deve conter 11 números!");}
					else {
				
				try {
					bd.insert_usuario(nome.getText(),cpf.getText(),telefone.getText(),endereco.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}}
			
			}
		});
				
			{
			
			

			cadastrar.setBounds(107, 227, 109, 23);
		contentPane.add(cadastrar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(280, 227, 89, 23);
		contentPane.add(sair);

	}
			
	
			
	
}}
