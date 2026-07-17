package empresa_funcionario_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import empresa_funcionario_codigo.bd;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class cadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTextField data;
	private JLabel lblFuno;
	private JTextField funcao;
	private JButton cadastrar;
	private JButton sair;
	private JLabel lblNewLabel_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Completo:");
		lblNewLabel.setBounds(10, 36, 110, 14);
		contentPane.add(lblNewLabel);
		
		JLabel vvvv = new JLabel("CPF:");
		vvvv.setBounds(10, 74, 90, 14);
		contentPane.add(vvvv);
		
		nome = new JTextField();
		nome.setBounds(127, 33, 297, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(37, 71, 166, 20);
		contentPane.add(cpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(226, 74, 110, 14);
		contentPane.add(lblDataDeNascimento);
		
		data = new JTextField();
		data.setColumns(10);
		data.setBounds(333, 71, 91, 20);
		contentPane.add(data);
		
		lblFuno = new JLabel("Função:");
		lblFuno.setBounds(10, 127, 90, 14);
		contentPane.add(lblFuno);
		
		funcao = new JTextField();
		funcao.setColumns(10);
		funcao.setBounds(61, 124, 363, 20);
		contentPane.add(funcao);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.setForeground(new Color(255, 255, 255));
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bd.insert_funcionario(nome.getText(),cpf.getText(),data.getText(),funcao.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cadastrar.setBackground(new Color(0, 64, 0));
		cadastrar.setBounds(61, 180, 110, 23);
		contentPane.add(cadastrar);
		
		sair = new JButton("Sair");
		sair.setForeground(new Color(255, 255, 255));
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBackground(new Color(255, 0, 0));
		sair.setBounds(247, 180, 89, 23);
		contentPane.add(sair);
		
		lblNewLabel_1 = new JLabel("Cadastrar Funcionario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 8, 414, 14);
		contentPane.add(lblNewLabel_1);

	}
}
