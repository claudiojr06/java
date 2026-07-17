package clinica_testetelas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class cad_paciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField nome;
	private JFormattedTextField cpf;
	private JFormattedTextField telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cad_paciente frame = new cad_paciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public cad_paciente() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		nome = new JFormattedTextField();
		nome.setBounds(83, 55, 192, 20);
		contentPane.add(nome);
		nome.setColumns(10);;
		
		
		
		JLabel lblCadastrarPaciente = new JLabel("CADASTRAR PACIENTE");
		lblCadastrarPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarPaciente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastrarPaciente.setBounds(10, 0, 399, 44);
		contentPane.add(lblCadastrarPaciente);
		
		JLabel noezin = new JLabel("NOME:");
		noezin.setFont(new Font("Tahoma", Font.BOLD, 11));
		noezin.setBounds(20, 46, 84, 44);
		contentPane.add(noezin);
		
		
		JLabel textfield = new JLabel("CPF:");
		textfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		textfield.setBounds(20, 88, 68, 44);
		contentPane.add(textfield);
		MaskFormatter cp=null;
		try {
			cp=new MaskFormatter("###.###.###-##");
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		cpf = new JFormattedTextField(cp);
		cpf.setColumns(10);
		cpf.setBounds(83, 100, 192, 20);
		contentPane.add(cpf);
		
		JLabel vtvt = new JLabel("TELEFONE:");
		vtvt.setFont(new Font("Tahoma", Font.BOLD, 11));
		vtvt.setBounds(20, 127, 68, 50);
		contentPane.add(vtvt);
		MaskFormatter cp1 = new MaskFormatter("(##)#########");
		
		telefone = new JFormattedTextField(cp1);
		telefone.setColumns(10);
		telefone.setBounds(83, 143, 192, 20);
		contentPane.add(telefone);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!nome.getText().matches("^[a-zA-Z ]*$")) {
					  JOptionPane.showMessageDialog(null,
				                "nome não deve conter numero!");}
				
				if (cpf.getText().contains(" ")) {
					  JOptionPane.showMessageDialog(null,
				                "CPF deve conter 11 números!");}
			
					
					
					if (telefone.getText().contains(" ")) {
						  JOptionPane.showMessageDialog(null,
					                "telefone deve conter 11 números!");}
				
					else {
				
				try {
					bd.bd.insert_paciente (nome.getText(),cpf.getText(),telefone.getText());
					
					 JOptionPane.showMessageDialog(null, 
							 "Cadastro Realizado");
					 dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					}}
					
					
				});
		cadastrar.setBounds(47, 227, 104, 23);
		contentPane.add(cadastrar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setForeground(new Color(255, 0, 0));
		sair.setBounds(206, 227, 89, 23);
		contentPane.add(sair);

	}
}
