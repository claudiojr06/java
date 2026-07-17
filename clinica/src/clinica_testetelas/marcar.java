package clinica_testetelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class marcar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField horario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marcar frame = new marcar();
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
	 * @throws ParseException 
	 */
	public marcar() throws SQLException, ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarcarHorrio = new JLabel("MARCAR HORÁRIO");
		lblMarcarHorrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcarHorrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarcarHorrio.setBounds(10, 0, 399, 44);
		contentPane.add(lblMarcarHorrio);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 71, 83, 31);
		contentPane.add(lblNewLabel);
		
		JComboBox cpf = new JComboBox();
		cpf.setBounds(81, 76, 157, 22);
		contentPane.add(cpf);
		ResultSet rs = null;
		try {
			rs = bd.bd.select_paciente();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (rs.next()) {
			cpf.addItem(rs.getString("cpf"));
		}

		
		JLabel lblHorrio = new JLabel("HORÁRIO:");
		lblHorrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHorrio.setBounds(10, 106, 63, 31);
		contentPane.add(lblHorrio);
		MaskFormatter mf = new MaskFormatter("####/##/## ##:##:##");
		horario = new JFormattedTextField(mf);
		horario.setColumns(10);
		horario.setBounds(91, 112, 147, 20);
		contentPane.add(horario);
		
		JButton btnMarcar = new JButton("MARCAR");
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				try {
					ResultSet rs = bd.bd.select_paciente();
					int indice_pac=cpf.getSelectedIndex();
					for (int i = 0; i <= indice_pac; i++)
						rs.next();
					int id_paciente = rs.getInt("id");
					
					rs = bd.bd.select_paciente();
					bd.bd.insert_horario(id_paciente, horario.getText());
					
					 JOptionPane.showMessageDialog(null, 
							 "Consulta Marcada!");
					 
					 
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnMarcar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMarcar.setBounds(36, 181, 128, 37);
		contentPane.add(btnMarcar);
		
		JButton sair = new JButton("sair");
		sair.setForeground(new Color(255, 0, 0));
		sair.setFont(new Font("Tahoma", Font.BOLD, 13));
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		sair.setBounds(218, 181, 128, 37);
		contentPane.add(sair);
		

}

}

