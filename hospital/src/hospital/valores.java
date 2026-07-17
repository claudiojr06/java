package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class valores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					valores frame = new valores();
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
	public valores() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar valores:");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(0, 0, 145, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID do paciente:");
		lblId.setForeground(new Color(0, 128, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblId.setBounds(0, 43, 145, 28);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(128, 49, 296, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setForeground(new Color(0, 128, 255));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTotal.setBounds(0, 82, 145, 28);
		contentPane.add(lblTotal);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(48, 82, 376, 22);
		contentPane.add(textField_1);
		
		JLabel lblDataDeCobrana = new JLabel("data de cobrança :");
		lblDataDeCobrana.setForeground(new Color(0, 128, 255));
		lblDataDeCobrana.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblDataDeCobrana.setBounds(0, 121, 145, 28);
		contentPane.add(lblDataDeCobrana);
		
		JLabel lblStatus = new JLabel("status:");
		lblStatus.setForeground(new Color(0, 128, 255));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblStatus.setBounds(0, 156, 145, 28);
		contentPane.add(lblStatus);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(143, 121, 281, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(62, 160, 94, 22);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("buscar");
		btnNewButton.setBounds(155, 5, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnConferirConvenio = new JButton("conferir\r\nconvenio");
		btnConferirConvenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convenios c = new convenios();
				c.setVisible(true);
			}
		});
		btnConferirConvenio.setBounds(26, 211, 130, 39);
		contentPane.add(btnConferirConvenio);
		
		JButton btnSair = new JButton("sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(285, 5, 91, 23);
		contentPane.add(btnSair);

	}
}
