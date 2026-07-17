package empresa_funcionario_telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import empresa_funcionario_codigo.bd;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class listar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpf;
	private JTextField data;
	private JTextField funcao;

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
	 * @throws SQLException 
	 */
	public listar() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Listar Funcionario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nome Completo:");
		lblNewLabel.setBounds(10, 39, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel gffs = new JLabel("CPF:");
		gffs.setBounds(10, 77, 90, 14);
		contentPane.add(gffs);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(37, 74, 166, 20);
		contentPane.add(cpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(213, 77, 123, 14);
		contentPane.add(lblDataDeNascimento);
		
		data = new JTextField();
		data.setColumns(10);
		data.setBounds(333, 74, 91, 20);
		contentPane.add(data);
		
		JLabel lblFuno = new JLabel("Função:");
		lblFuno.setBounds(10, 130, 90, 14);
		contentPane.add(lblFuno);
		
		funcao = new JTextField();
		funcao.setColumns(10);
		funcao.setBounds(61, 127, 363, 20);
		contentPane.add(funcao);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBackground(Color.RED);
		sair.setBounds(10, 187, 414, 23);
		contentPane.add(sair);
		
		JComboBox nome = new JComboBox();
		nome.setBounds(110, 36, 287, 22);
		contentPane.add(nome);
		ResultSet rs= bd.select_funcionario();
		while(rs.next()) {
			nome.addItem(rs.getString("nome"));
		}
		nome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int indice =nome.getSelectedIndex();
				System.out.println(indice);
				try {
					ResultSet rs = bd.select_funcionario();
					if(indice==0) {
					for(int i =0;i<=indice;i++) {
						rs.next();
					}
					if (rs.getString("nome").equals(nome.getSelectedItem().toString()))
					cpf.setText(rs.getString("cpf"));
					data.setText(rs.getString("nascimento"));
					funcao.setText(rs.getString("funcao"));
					}
					else {
						cpf.setText("");
						data.setText("");
						funcao.setText("");
					}
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}}
		});
				}
				
			}
				
			
		

	
