package Estacionamento.Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Estacionamento.Funcoes.bd;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Saida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saida frame = new Saida();
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
	public Saida() throws SQLException {
		setTitle("Saída");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lplaca = new JLabel("Placa:");
		lplaca.setFont(new Font("Stencil", Font.PLAIN, 19));
		lplaca.setBounds(10, 10, 106, 28);
		contentPane.add(lplaca);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setForeground(new Color(255, 0, 0));
		sair.setFont(new Font("Stencil", Font.BOLD, 19));
		sair.setBounds(190, 48, 170, 35);
		contentPane.add(sair);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 10, 258, 28);
		contentPane.add(comboBox);
		comboBox.addItem("");
		ResultSet rs=bd.select_vaga();
		while(rs.next()){
			if(rs.getString("saida")== null)
			comboBox.addItem(rs.getString("placa"));
		}
		
		JButton saida = new JButton("Saída");
		saida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs;
				try {
					rs=bd.select_vaga();
					while(rs.next()){
						if(rs.getString("placa").equals( comboBox.getSelectedItem().toString()))
						if(rs.getString("saida")== null)
						bd.update_vaga(rs.getInt("id"));
					}
					dispose();
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		saida.setFont(new Font("Stencil", Font.BOLD, 19));
		saida.setBounds(10, 48, 170, 35);
		contentPane.add(saida);
	}

}
