package estacionamento2_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import codigo.bd;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class cad_veiculo extends JFrame {

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
					cad_veiculo frame = new cad_veiculo();
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
	public cad_veiculo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		lblNewLabel_1.setBounds(20, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		modelo = new JTextField();
		modelo.setColumns(10);
		modelo.setBounds(90, 33, 334, 20);
		contentPane.add(modelo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marca:");
		lblNewLabel_1_1.setBounds(20, 79, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		marca = new JTextField();
		marca.setColumns(10);
		marca.setBounds(90, 76, 334, 20);
		contentPane.add(marca);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Placa:");
		lblNewLabel_1_1_1.setBounds(20, 132, 46, 14);
		contentPane.add(lblNewLabel_1_1_1);
		MaskFormatter pla=null;
		try {
			pla=new MaskFormatter("???#A##");
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField placa = new JFormattedTextField(pla);
		placa.setBounds(90, 129, 334, 20);
		contentPane.add(placa);
		
		
		
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(placa.getText().contains(" ")) {
					 JOptionPane.showMessageDialog(null,
				                "Placa deve conter 7 caracteres no Padrao");}
				
					
				try {
					bd.insert_veiculo(marca.getText(),modelo.getText(),placa.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}
				
			}
	);
		cadastrar.setBounds(107, 227, 107, 23);
		contentPane.add(cadastrar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
					}
		});
		sair.setBounds(280, 227, 89, 23);
		contentPane.add(sair);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Veiculo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		

	}

}
