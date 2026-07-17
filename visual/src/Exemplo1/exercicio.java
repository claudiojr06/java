package Exemplo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class exercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNumero;
	private JTextField txtCadastroBanco;
	private JPasswordField pwdSenha;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exercicio frame = new exercicio();
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
	public exercicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(255, 255, 255));
		txtNome.setBackground(new Color(128, 0, 255));
		txtNome.setText("Nome:");
		txtNome.setBounds(10, 87, 377, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setForeground(new Color(255, 255, 255));
		txtNumero.setBackground(new Color(128, 0, 255));
		txtNumero.setText("Numero da Conta:");
		txtNumero.setBounds(10, 118, 377, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCadastroBanco = new JTextField();
		txtCadastroBanco.setForeground(new Color(255, 255, 255));
		txtCadastroBanco.setBackground(new Color(128, 0, 255));
		txtCadastroBanco.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCadastroBanco.setText("NUBANCO");
		txtCadastroBanco.setBounds(147, 11, 135, 50);
		contentPane.add(txtCadastroBanco);
		txtCadastroBanco.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar:");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setToolTipText("Cadastrar");
		btnNewButton.setBounds(162, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBackground(new Color(128, 0, 255));
		pwdSenha.setBounds(47, 154, 340, 20);
		contentPane.add(pwdSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBackground(new Color(128, 0, 255));
		txtSenha.setText("Senha:");
		txtSenha.setForeground(new Color(255, 255, 255));
		txtSenha.setBounds(10, 154, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

	}
}
