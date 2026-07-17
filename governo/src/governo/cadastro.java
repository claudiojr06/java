package governo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

//import alunos_informatica.dados;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro frame = new cadastro();
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
	public cadastro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel na = new JLabel("Nome:");
		na.setBounds(10, 11, 46, 14);
		contentPane.add(na);
		
		nome = new JTextField();
		nome.setBounds(10, 38, 414, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(10, 120, 46, 14);
		contentPane.add(lblNewLabel);
		
		MaskFormatter mask=null;
		try {
			mask=new MaskFormatter("###.###.###-##");
			mask.setPlaceholderCharacter('_');
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField cpf = new JFormattedTextField(mask);
		cpf.setBounds(20, 145, 404, 20);
		contentPane.add(cpf);

		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
					bd_gov.insert_cadastro(nome.getText(),cpf.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		cadastrar.setBounds(70, 227, 114, 23);
		contentPane.add(cadastrar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(246, 227, 89, 23);
		contentPane.add(sair);
		
	
	}
}
