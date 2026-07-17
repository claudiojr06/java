package lista_telefonica.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lista_telefonica.funcoes.bd_lista;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField telefone;

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
		setBounds(100, 100, 450, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setBounds(10, 91, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		nome = new JTextField();
		nome.setBounds(66, 41, 255, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(66, 88, 255, 20);
		contentPane.add(telefone);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastro ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println();
				try {
					if (nome.getText().length() > 0 && telefone.getText().length() > 0) {
						bd_lista.insert_pessoa(nome.getText(), telefone.getText());
						dispose();
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		salvar.setFont(new Font("Stencil", Font.BOLD, 11));
		salvar.setBounds(66, 141, 95, 23);
		contentPane.add(salvar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(232, 141, 89, 23);
		contentPane.add(sair);

	}
}



//JButton Cadastrar = new JButton("Cadastrar");
//Cadastrar.addActionListener(new ActionListener() {
	//public void actionPerformed(ActionEvent e) {
		//System.out.println();
		//try {
			//if (placa.getText().length() > 0 && modelo.getText().length() > 0) {
			//	bd.insert_veiculo(placa.getText(), modelo.getText());
			//	dispose();
		//	}
		//} catch (SQLException e1) {
			
		//	e1.printStackTrace();
	//	}
//	}
//});
//Cadastrar.setFont(new Font("Stencil", Font.BOLD, 19));
//Cadastrar.setBounds(10, 86, 170, 35);
//contentPane.add(Cadastrar);

//JButton sair = new JButton("Sair");
//sair.setForeground(new Color(255, 0, 0));
//sair.addActionListener(new ActionListener() {
	//public void actionPerformed(ActionEvent e) {
		//dispose();
	//}




//