package clinica_testetelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class agenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agenda frame = new agenda();
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
	public agenda() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(21, 43, 46, 14);
		contentPane.add(lblHorario);
		
		
		
		JTextArea informacoes = new JTextArea();
		informacoes.setEditable(false);
		JScrollPane sp = new JScrollPane(informacoes);
		sp.setBounds(15, 72, 409, 130);
		contentPane.add(sp);
		
		JComboBox horario = new JComboBox();
		horario.setBounds(89, 39, 262, 22);
		contentPane.add(horario);
		ResultSet rs=bd.bd.select_horario();
		while(rs.next()) {
			horario.addItem(rs.getString("dataa"));
		}
		horario.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indice = horario.getSelectedIndex();
				System.out.println(indice);
				try {
					ResultSet rs = bd.bd.select_horario();
					for(int i =0;i<=indice;i++) {
						rs.next();
					}
					String l="";
					l += "\n" + "Nome:  "+rs.getString("nome");				
					l += "\n" +"CPF:  "+rs.getString("cpf");
					l += "\n"+ "Telefone:  "+rs.getString("telefone");
					informacoes.setText(l);
					
			}	
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton sair = new JButton("SAIR");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		sair.setForeground(Color.RED);
		sair.setFont(new Font("Tahoma", Font.BOLD, 13));
		sair.setBounds(135, 213, 128, 37);
		contentPane.add(sair);
	}

}
