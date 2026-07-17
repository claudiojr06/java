package banco_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class movimentar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					movimentar frame = new movimentar();
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
	public movimentar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(173, 70, 185));
		contentPane_1.setBounds(0, 0, 434, 170);
		contentPane.add(contentPane_1);
		
		JLabel dsafsds = new JLabel("Movimentar Conta");
		dsafsds.setHorizontalAlignment(SwingConstants.CENTER);
		dsafsds.setForeground(Color.WHITE);
		dsafsds.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		dsafsds.setBounds(10, 11, 414, 37);
		contentPane_1.add(dsafsds);
		
		JButton btnDeposito = new JButton("Deposito");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depositar dep = new depositar();
				dep.setVisible(true);
				dispose();
				
			}
		});
		btnDeposito.setBackground(new Color(0, 255, 0));
		btnDeposito.setBounds(116, 72, 89, 23);
		contentPane_1.add(btnDeposito);
		
		JButton btnSaque = new JButton("Saque");
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saque saq = new saque ();
				saq.setVisible(true);
				dispose();
			}
		});
		btnSaque.setBackground(new Color(0, 255, 0));
		btnSaque.setBounds(255, 72, 89, 23);
		contentPane_1.add(btnSaque);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu m = new menu();
				m.setVisible(true);
				dispose();
			}
		});
		btnSair.setBackground(new Color(255, 0, 0));
		btnSair.setBounds(182, 119, 89, 23);
		contentPane_1.add(btnSair);

	}

}
