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
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(10, 25, 90, 14);
		contentPane.add(lblUsurio);
		
		usuario = new JTextField();
		usuario.setColumns(10);
		usuario.setBounds(77, 22, 334, 20);
		contentPane.add(usuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 63, 54, 14);
		contentPane.add(lblSenha);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(77, 60, 334, 20);
		contentPane.add(senha);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs=bd.select_login();
					while(rs.next()) {
					if (rs.getString("usuario").equals(usuario.getText())&& rs.getString("senha").equals(senha.getText())){
			menu m=new menu();
			m.setVisible(true);
				setVisible(false);
		}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		login.setBackground(new Color(0, 128, 0));
		login.setBounds(47, 172, 148, 23);
		contentPane.add(login);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
							bd.insert_login(usuario.getText(), senha.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
				}
			}
		});
		cadastrar.setBackground(new Color(0, 0, 128));
		cadastrar.setBounds(263, 172, 148, 23);
		contentPane.add(cadastrar);

	}

}
