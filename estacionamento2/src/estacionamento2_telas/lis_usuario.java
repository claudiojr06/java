package estacionamento2_telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.bd;


import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class lis_usuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField telefone;
	private JTextField endereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lis_usuario frame = new lis_usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public lis_usuario() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(38, 15, 60, 14);
		contentPane.add(lblCpf);
		
		JComboBox cpf = new JComboBox();
		cpf.setBounds(108, 11, 272, 22);
		contentPane.add(cpf);
		ResultSet rs=bd.select_usuario();
		while(rs.next()) {
			cpf.addItem(rs.getString("cpf"));
		}
		cpf.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indice = cpf.getSelectedIndex();
				System.out.println(indice);
				try {
					ResultSet rs = bd.select_usuario();
					for(int i =0;i<=indice;i++) {
						rs.next();
					}
					nome.setText(rs.getString("nome"));				
					telefone.setText(rs.getString("telefone"));
					endereco.setText(rs.getString("endereco"));
					
			}	
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(38, 57, 60, 14);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setEditable(false);
		nome.setColumns(10);
		nome.setBounds(118, 54, 262, 20);
		contentPane.add(nome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(38, 109, 60, 14);
		contentPane.add(lblTelefone);
		
		telefone = new JTextField();
		telefone.setEditable(false);
		telefone.setColumns(10);
		telefone.setBounds(118, 106, 262, 20);
		contentPane.add(telefone);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(179, 184, 89, 23);
		contentPane.add(sair);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(38, 148, 60, 14);
		contentPane.add(lblEndereo);
		
		endereco = new JTextField();
		endereco.setEditable(false);
		endereco.setColumns(10);
		endereco.setBounds(118, 145, 262, 20);
		contentPane.add(endereco);

	}

}
