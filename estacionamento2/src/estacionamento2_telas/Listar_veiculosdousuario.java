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
import javax.swing.JButton;
import javax.swing.JTextField;

public class Listar_veiculosdousuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField placa;
	private JTextField modelo;
	private JTextField marca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listar_veiculosdousuario frame = new Listar_veiculosdousuario();
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
	public Listar_veiculosdousuario() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(51, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox usuario = new JComboBox();
		usuario.setBounds(107, 11, 272, 22);
		contentPane.add(usuario);
		ResultSet rs=bd.select_vinculo();
		while(rs.next()) {
			if(rs.getInt("ativo")==1)
			usuario.addItem(rs.getString("cpf"));
		}
		
		usuario.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indice = usuario.getSelectedIndex();
				System.out.println(indice);
				try {
					ResultSet rs = bd.select_vinculo();
					while(rs.next()) {
						if(usuario.getSelectedItem().toString().equals(rs.getString("cpf"))) {
							placa.setText(rs.getString("placa"));
							marca.setText(rs.getString("marca"));
							modelo.setText(rs.getString("modelo"));
						}
					}				
					
				
					
			}	
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton desvincular = new JButton("Desvincular");
		desvincular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = bd.select_vinculo();
					while(rs.next()) {
						if(usuario.getSelectedItem().toString().equals(rs.getString("cpf"))
						&& placa.getText().equals(rs.getString("placa"))){
							bd.update_vinculo(rs.getInt("id"));
						}
					}				
					
				
					
			}	
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
		});
		desvincular.setBounds(107, 227, 102, 23);
		contentPane.add(desvincular);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(51, 52, 60, 14);
		contentPane.add(lblPlaca);
		
		placa = new JTextField();
		placa.setEditable(false);
		placa.setColumns(10);
		placa.setBounds(117, 49, 262, 20);
		contentPane.add(placa);
		
		modelo = new JTextField();
		modelo.setEditable(false);
		modelo.setColumns(10);
		modelo.setBounds(107, 141, 262, 20);
		contentPane.add(modelo);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(34, 144, 60, 14);
		contentPane.add(lblModelo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(37, 96, 60, 14);
		contentPane.add(lblMarca);
		
		marca = new JTextField();
		marca.setEditable(false);
		marca.setColumns(10);
		marca.setBounds(107, 93, 262, 20);
		contentPane.add(marca);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(261, 227, 89, 23);
		contentPane.add(btnNewButton);

	}
}
