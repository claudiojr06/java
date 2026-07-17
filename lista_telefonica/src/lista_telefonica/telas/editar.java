package lista_telefonica.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lista_telefonica.funcoes.bd_lista;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class editar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editar frame = new editar();
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
	public editar() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Pessoa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(66, 36, 46, 22);
		contentPane.add(lblNewLabel_1);
		
		JComboBox nome = new JComboBox();
		nome.setBounds(131, 36, 236, 22);
		contentPane.add(nome);
		nome.addItem("");
		ResultSet rs=bd_lista.select_pessoa();
		while(rs.next()) {
			
					
			nome.addItem(rs.getString("nome"));
		}
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs;
				try {
					rs = bd_lista.select_pessoa();
					while(rs.next()){
						if(rs.getString("nome").equals(nome.getSelectedItem())) {
							telefone.setText(rs.getString("telefone"));
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		buscar.setBounds(193, 72, 89, 23);
		contentPane.add(buscar);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setBounds(37, 127, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(131, 124, 236, 20);
		contentPane.add(telefone);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(193, 212, 89, 23);
		contentPane.add(sair);
		
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs;
				try {
					rs = bd_lista.select_pessoa();
					while(rs.next()) {
						if(rs.getString("nome").equals(nome.getSelectedItem())) {
							bd_lista.update_pessoa(rs.getInt("idpessoa"),telefone.getText());
						}
						}
				}catch(SQLException e1) {
					e1.printStackTrace();
				
				}
			dispose();
			}
		});
		salvar.setBounds(193, 155, 89, 23);
		contentPane.add(salvar);

		}
	}


