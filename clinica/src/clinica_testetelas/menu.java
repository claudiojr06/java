package clinica_testetelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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

public menu() {

	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("CONSULTÓRIO DO DEMBELE");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(10, 0, 399, 44);
	contentPane.add(lblNewLabel);
	
	JButton paciente = new JButton("Cadastrar Paciente");
	paciente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		cad_paciente p = null;
		try {
			p = new cad_paciente();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		p.setVisible(true);
		}
	});
	paciente.setFont(new Font("Tahoma", Font.BOLD, 13));
	paciente.setBounds(116, 54, 176, 44);
	contentPane.add(paciente);
	
	JButton marcar = new JButton("Marcar Horário");
	marcar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        marcar h = null;
		try {
			h = new marcar();
		} catch (SQLException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        h.setVisible(true);
		}
	});
	marcar.setFont(new Font("Tahoma", Font.BOLD, 13));
	marcar.setBounds(116, 105, 176, 44);
	contentPane.add(marcar);
	
	JButton agenda = new JButton("Agenda");
	agenda.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		agenda a = null;
		try {
			a = new agenda();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		a.setVisible(true);
		}
	});
	agenda.setFont(new Font("Tahoma", Font.BOLD, 13));
	agenda.setBounds(116, 155, 176, 44);
	contentPane.add(agenda);
	
	JButton sair = new JButton("SAIR");
	sair.setForeground(new Color(255, 0, 0));
	sair.setFont(new Font("Tahoma", Font.BOLD, 13));
	sair.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		dispose();
		}
	});
	sair.setBounds(116, 210, 176, 40);
	contentPane.add(sair);

}
}