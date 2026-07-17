package Estacionamento.Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Estacionamento.Funcoes.bd;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField placa;
	private JTextField modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("Cadastrar Veículo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lplaca = new JLabel("Placa:");
		lplaca.setFont(new Font("Stencil", Font.PLAIN, 19));
		lplaca.setBounds(10, 10, 106, 28);
		contentPane.add(lplaca);

		placa = new JTextField();
		placa.setBounds(115, 11, 245, 28);
		contentPane.add(placa);
		placa.setColumns(10);

		modelo = new JTextField();
		modelo.setColumns(10);
		modelo.setBounds(115, 49, 245, 28);
		contentPane.add(modelo);

		JLabel lmodelo = new JLabel("Modelo:");
		lmodelo.setFont(new Font("Stencil", Font.PLAIN, 19));
		lmodelo.setBounds(10, 48, 106, 28);
		contentPane.add(lmodelo);

		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println();
				try {
					if (placa.getText().length() > 0 && modelo.getText().length() > 0) {
						bd.insert_veiculo(placa.getText(), modelo.getText());
						dispose();
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		Cadastrar.setFont(new Font("Stencil", Font.BOLD, 19));
		Cadastrar.setBounds(10, 86, 170, 35);
		contentPane.add(Cadastrar);

		JButton sair = new JButton("Sair");
		sair.setForeground(new Color(255, 0, 0));
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setFont(new Font("Stencil", Font.BOLD, 19));
		sair.setBounds(190, 86, 170, 35);
		contentPane.add(sair);

	}
}
