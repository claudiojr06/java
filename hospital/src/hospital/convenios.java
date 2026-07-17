package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class convenios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					convenios frame = new convenios();
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
	public convenios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID do paciente:");
		lblId.setForeground(new Color(0, 128, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblId.setBounds(0, 11, 145, 28);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 50, 424, 28);
		contentPane.add(textField);
		
		JLabel lblNome = new JLabel("nome:");
		lblNome.setForeground(new Color(0, 128, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(0, 137, 145, 28);
		contentPane.add(lblNome);
		
		JLabel lblTipo = new JLabel("tipo:");
		lblTipo.setForeground(new Color(0, 128, 255));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTipo.setBounds(0, 192, 145, 28);
		contentPane.add(lblTipo);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(63, 142, 361, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(48, 198, 376, 22);
		contentPane.add(textField_2);
		
		JButton btnConferir = new JButton("conferir");
		btnConferir.setBounds(151, 92, 130, 39);
		contentPane.add(btnConferir);
		
		JButton btnSair = new JButton("sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setBackground(new Color(255, 0, 0));
		btnSair.setBounds(172, 231, 91, 23);
		contentPane.add(btnSair);

	}

}
