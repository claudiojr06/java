package Academia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cad_cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cad_cliente frame = new cad_cliente();
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
	public cad_cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 10, 49, 34);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(69, 18, 335, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 46, 49, 34);
		contentPane.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(69, 54, 118, 18);
		contentPane.add(textField_1);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(210, 46, 66, 34);
		contentPane.add(lblTelefone);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(286, 54, 118, 18);
		contentPane.add(textField_2);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setBounds(10, 82, 49, 34);
		contentPane.add(lblPeso);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(69, 90, 118, 18);
		contentPane.add(textField_3);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(210, 82, 66, 34);
		contentPane.add(lblAltura);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(286, 90, 118, 18);
		contentPane.add(textField_4);
		
		JLabel lblNasc = new JLabel("Nasc.:");
		lblNasc.setBounds(10, 118, 49, 34);
		contentPane.add(lblNasc);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(69, 126, 118, 18);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 162, 179, 34);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(225, 162, 179, 34);
		contentPane.add(btnCancelar);

	}
}
