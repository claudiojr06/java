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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Entrada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada frame = new Entrada();
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
	public Entrada() throws SQLException {
		setTitle("Entrada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lplaca = new JLabel("Placa:");
		lplaca.setFont(new Font("Stencil", Font.PLAIN, 19));
		lplaca.setBounds(10, 10, 106, 28);
		contentPane.add(lplaca);
		
		
		
		JButton sair = new JButton("Sair");
		sair.setForeground(new Color(255, 0, 0));
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setFont(new Font("Stencil", Font.BOLD, 19));
		sair.setBounds(190, 159, 170, 35);
		contentPane.add(sair);
		
		JComboBox placa = new JComboBox();
		placa.setBounds(102, 10, 258, 28);
		contentPane.add(placa);
		placa.addItem("");
		ResultSet rs=bd.select_veiculo();
		while(rs.next()) {
			ResultSet rs2= bd.select_vaga();
			int existe=0;
					while(rs2.next()) {
						if(rs2.getString("placa").equals(rs.getString("placa")))
							if(rs2.getString("saida")== null)
								existe =1;
					}
					if(existe==0)
			placa.addItem(rs.getString("placa"));
		}
		
		JLabel vagaa = new JLabel("VAGA:");
		vagaa.setFont(new Font("Stencil", Font.PLAIN, 19));
		vagaa.setBounds(10, 85, 106, 28);
		contentPane.add(vagaa);
		
		JComboBox vaga = new JComboBox();
		vaga.setBounds(102, 85, 258, 28);
		contentPane.add(vaga);
		for(int i =1;i<=50;i++) {
			int ocupado = 0;
			rs=bd.select_vaga();
			while(rs.next()) {
				if(rs.getInt("vaga")== i ) {
					if(rs.getString("saida") == null) {
						ocupado=1;
					}
					
				}	
			}	
			if(ocupado ==0)
				vaga.addItem(i);
		}
		JButton entrada = new JButton("Entrada");
		entrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bd.insert_vaga(placa.getSelectedItem().toString(),Integer.parseInt(vaga.getSelectedItem().toString()));
				} catch (NumberFormatException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		entrada.setFont(new Font("Stencil", Font.BOLD, 19));
		entrada.setBounds(10, 159, 170, 35);
		contentPane.add(entrada);
		
		

	}
}
