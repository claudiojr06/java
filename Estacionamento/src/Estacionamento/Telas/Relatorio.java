package Estacionamento.Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Estacionamento.Funcoes.bd;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Relatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField entrada;
	private JTextField saida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio frame = new Relatorio();
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
	public Relatorio() {
		setTitle("Relatório");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lplaca = new JLabel("Placa:");
		lplaca.setFont(new Font("Stencil", Font.PLAIN, 19));
		lplaca.setBounds(10, 11, 106, 28);
		contentPane.add(lplaca);
		
		JComboBox placa = new JComboBox();
		placa.setBounds(102, 11, 200, 28);
		contentPane.add(placa);
		ResultSet rs;
		try {
			rs=bd.select_veiculo();
		
		while(rs.next()) {
			placa.addItem(rs.getString("placa"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		JLabel lblEntrada = new JLabel("ENTRADA:");
		lblEntrada.setFont(new Font("Stencil", Font.PLAIN, 19));
		lblEntrada.setBounds(10, 76, 106, 28);
		contentPane.add(lblEntrada);
		
		JLabel lblSada = new JLabel("SAÍDA:");
		lblSada.setFont(new Font("Stencil", Font.PLAIN, 19));
		lblSada.setBounds(10, 135, 106, 28);
		contentPane.add(lblSada);
		
		entrada = new JTextField();
		entrada.setEditable(false);
		entrada.setBounds(112, 80, 151, 20);
		contentPane.add(entrada);
		entrada.setColumns(10);
		
		saida = new JTextField();
		saida.setEditable(false);
		saida.setColumns(10);
		saida.setBounds(102, 139, 161, 20);
		contentPane.add(saida);
		
		JButton buscar = new JButton("BUSCAR");
		buscar.setBounds(335, 14, 89, 23);
		contentPane.add(buscar);
		
		JButton sair = new JButton("SAIR");
		sair.setBounds(273, 79, 89, 66);
		contentPane.add(sair);

	}
}
