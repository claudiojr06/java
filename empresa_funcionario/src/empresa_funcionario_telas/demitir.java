package empresa_funcionario_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import empresa_funcionario_codigo.bd;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class demitir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTextField motivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demitir frame = new demitir();
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
	public demitir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel gffs = new JLabel("CPF:");
		gffs.setBounds(0, 36, 90, 14);
		contentPane.add(gffs);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(123, 71, 301, 20);
		contentPane.add(nome);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(67, 33, 123, 20);
		contentPane.add(cpf);
		
		JLabel lblNewLabel = new JLabel("Nome Completo:");
		lblNewLabel.setBounds(13, 74, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotivoDaDemisso = new JLabel("Motivo da Demissão:");
		lblMotivoDaDemisso.setBounds(10, 127, 128, 14);
		contentPane.add(lblMotivoDaDemisso);
		
		motivo = new JTextField();
		motivo.setColumns(10);
		motivo.setBounds(123, 124, 301, 20);
		contentPane.add(motivo);
		
		JButton sair = new JButton("Sair");
		sair.setBackground(Color.RED);
		sair.setBounds(253, 183, 148, 23);
		contentPane.add(sair);
		
		JButton demitir = new JButton("Demitir");
		demitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				try {
					rs = bd.select_funcionario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while(rs.next()) {
						if(rs.getString("cpf").equals(cpf.getText())) {
							bd.insert_demissao(rs.getInt("id"),motivo.getText());
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		demitir.setBackground(Color.RED);
		demitir.setBounds(37, 183, 148, 23);
		contentPane.add(demitir);
		
		JButton buscar = new JButton("Buscar");
				buscar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						try {
							ResultSet rs=bd.select_funcionario(); 
								
							while(rs.next()) {
								if(rs.getString("cpf").equals(cpf.getText())){
									nome.setText(rs.getString("nome"));
								}}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
		buscar.setBounds(200, 32, 89, 23);
		contentPane.add(buscar);

	}

}
