package governo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class listar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lis_cpf;

	public static void addcadastro()throws SQLException {
		ResultSet rs=bd_gov.select_cadastro();
		

	}
	
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cpf = new JLabel("CPF:");
		cpf.setBounds(49, 107, 46, 14);
		contentPane.add(cpf);
		
		JComboBox lis_nomes = new JComboBox();
		lis_nomes.setBounds(124, 33, 185, 22);
		contentPane.add(lis_nomes);
		ResultSet rs=bd_gov.select_cadastro();
		while(rs.next()) {
			lis_nomes.addItem(rs.getString("nome"));
		}
		lis_nomes.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indice = lis_nomes.getSelectedIndex();
				System.out.println(indice);
				try {
					ResultSet rs = bd_gov.select_cadastro();
					for(int i =0;i<=indice;i++) {
						rs.next();
					}
					lis_cpf.setText(rs.getString("cpf"));
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
	});
			
		
		JLabel lblNewLabel = new JLabel("Nomes:");
		lblNewLabel.setBounds(49, 37, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton sair = new JButton("SAIR");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();}
		});
		sair.setBounds(159, 227, 89, 23);
		contentPane.add(sair);
		
		lis_cpf = new JTextField();
		lis_cpf.setEditable(false);
		lis_cpf.setBounds(124, 104, 185, 20);
		contentPane.add(lis_cpf);
		lis_cpf.setColumns(10);

	}

}
