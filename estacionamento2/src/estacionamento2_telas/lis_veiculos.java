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
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

public class lis_veiculos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField modelo;
	private JTextField marca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lis_veiculos frame = new lis_veiculos();
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
	public lis_veiculos() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(49, 15, 46, 14);
		contentPane.add(lblPlaca);
		
		JComboBox placa = new JComboBox();
		placa.setBounds(105, 11, 272, 22);
		contentPane.add(placa);
		ResultSet rs=bd.select_veiculo();
		while(rs.next()) {
			placa.addItem(rs.getString("placa"));
		}
		placa.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indice = placa.getSelectedIndex();
				System.out.println(indice);
				try {
					ResultSet rs = bd.select_veiculo();
					for(int i =0;i<=indice;i++) {
						rs.next();
					}
					modelo.setText(rs.getString("modelo"));				
					marca.setText(rs.getString("marca"));
					
					
			}	
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(176, 184, 89, 23);
		contentPane.add(sair);
		
		JLabel lblNewLabel = new JLabel("Modelo:");
		lblNewLabel.setBounds(49, 57, 46, 14);
		contentPane.add(lblNewLabel);
		
		modelo = new JTextField();
		modelo.setEditable(false);
		modelo.setBounds(115, 54, 262, 20);
		contentPane.add(modelo);
		modelo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(49, 109, 46, 14);
		contentPane.add(lblMarca);
		
		marca = new JTextField();
		marca.setEditable(false);
		marca.setColumns(10);
		marca.setBounds(115, 106, 262, 20);
		contentPane.add(marca);

	}
}
