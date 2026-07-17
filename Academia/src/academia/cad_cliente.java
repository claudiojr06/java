package academia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 524, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nome = new JLabel("NOME:");
		nome.setBounds(10, 58, 46, 14);
		contentPane.add(nome);
		
		JLabel nascimento = new JLabel("NASCIMENTO:");
		nascimento.setBounds(10, 98, 85, 14);
		contentPane.add(nascimento);
		
		JLabel altura = new JLabel("ALTURA:");
		altura.setBounds(10, 139, 72, 14);
		contentPane.add(altura);
		
		JLabel telefone = new JLabel("TELEFONE:");
		telefone.setBounds(261, 139, 85, 14);
		contentPane.add(telefone);
		
		JLabel peso = new JLabel("PESO:");
		peso.setBounds(10, 178, 46, 14);
		contentPane.add(peso);
		
		JLabel cpf = new JLabel("CPF:");
		cpf.setBounds(291, 98, 46, 14);
		contentPane.add(cpf);
		
		JLabel lblNewLabel_6 = new JLabel("CADASTRO:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setBounds(10, 0, 488, 32);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(58, 55, 426, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 95, 118, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 136, 118, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 175, 118, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(328, 95, 170, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(338, 136, 160, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton cancelar = new JButton("CANCELAR");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setForeground(new Color(255, 0, 0));
		cancelar.setBounds(318, 220, 139, 23);
		contentPane.add(cancelar);
		
		JButton cadastrar = new JButton("CADASTRAR");
		cadastrar.setForeground(new Color(0, 64, 0));
		cadastrar.setBounds(48, 220, 127, 23);
		contentPane.add(cadastrar);

	}
}
