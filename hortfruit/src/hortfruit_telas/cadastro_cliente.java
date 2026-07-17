package hortfruit_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import hortifruit_bd.bd;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class cadastro_cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTextField telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro_cliente frame = new cadastro_cliente();
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
	public cadastro_cliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCliente.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblCadastrarCliente.setBounds(10, 11, 414, 40);
		contentPane.add(lblCadastrarCliente);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(81, 70, 82, 29);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(179, 75, 148, 20);
		contentPane.add(nome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf.setBounds(81, 110, 108, 29);
		contentPane.add(lblCpf);
		MaskFormatter cp=null;
		try {
			cp=new MaskFormatter("###.###.###-##");
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField cpf = new JFormattedTextField(cp);
		cpf.setBounds(90, 76, 334, 20);
		contentPane.add(cpf);
		
		cpf.setColumns(10);
		cpf.setBounds(179, 115, 148, 20);
		contentPane.add(cpf);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bd.insert_cliente(nome.getText(),cpf.getText(),telefone.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		cadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		cadastrar.setBounds(72, 221, 117, 29);
		contentPane.add(cadastrar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setForeground(new Color(255, 0, 0));
		sair.setFont(new Font("Arial", Font.BOLD, 12));
		sair.setBounds(238, 221, 117, 29);
		contentPane.add(sair);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 15));
		lblTelefone.setBounds(81, 141, 108, 29);
		contentPane.add(lblTelefone);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(179, 146, 148, 20);
		contentPane.add(telefone);

	}

}
