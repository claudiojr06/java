package Estacionamento.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Estacionamento do Fred");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cad = new JButton("Cadastrar Veículo");
		cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro c = new Cadastro();
				c.setVisible(true);
			}
		});
		cad.setFont(new Font("Stencil", Font.PLAIN, 19));
		cad.setBounds(91, 31, 240, 41);
		contentPane.add(cad);
		
		JButton entrada = new JButton("Entrada");
		entrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada en = null;
				try {
					en = new Entrada();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				en.setVisible(true);
			}
		});
		entrada.setFont(new Font("Stencil", Font.PLAIN, 19));
		entrada.setBounds(91, 82, 240, 41);
		contentPane.add(entrada);
		
		JButton saida = new JButton("Saída");
		saida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Saida s = null;
				try {
					s = new Saida();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				s.setVisible(true);
			}
		});
		saida.setFont(new Font("Stencil", Font.PLAIN, 19));
		saida.setBounds(91, 133, 240, 41);
		contentPane.add(saida);
		
		JButton relatorio = new JButton("Relatório");
		relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio r = new Relatorio();
				r.setVisible(true);
			}
		});
		relatorio.setFont(new Font("Stencil", Font.PLAIN, 19));
		relatorio.setBounds(91, 182, 240, 41);
		contentPane.add(relatorio);

	}
}
