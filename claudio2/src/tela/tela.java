package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import consumo_api.controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pais;
	private JTextField bandeira;
	private JTextField grupo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela frame = new tela();
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
	public tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("pais");
		lblNewLabel.setBounds(31, 25, 46, 14);
		contentPane.add(lblNewLabel);
		
		pais = new JTextField();
		pais.setBounds(87, 22, 267, 20);
		contentPane.add(pais);
		pais.setColumns(10);
		
		JLabel lblBandeira = new JLabel("bandeira");
		lblBandeira.setBounds(31, 74, 46, 14);
		contentPane.add(lblBandeira);
		
		bandeira = new JTextField();
		bandeira.setColumns(10);
		bandeira.setBounds(87, 71, 267, 20);
		contentPane.add(bandeira);
		
		JButton cadastrar = new JButton("cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!pais.getText().isEmpty()&& !grupo.getText().isEmpty() && !bandeira.getText().isEmpty())
					controller.valida_selecao(pais.getText(), grupo.getText(), bandeira.getText());
			}
		});
		cadastrar.setBounds(162, 198, 89, 23);
		contentPane.add(cadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("grupo:");
		lblNewLabel_1.setBounds(31, 119, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		grupo = new JTextField();
		grupo.setBounds(87, 116, 267, 20);
		contentPane.add(grupo);
		grupo.setColumns(10);

	}
}
