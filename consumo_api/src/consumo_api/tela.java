package consumo_api;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpf;
	private JTextField validado;

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
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(69, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		cpf = new JTextField();
		cpf.setBounds(145, 26, 221, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		validado = new JTextField();
		validado.setEditable(false);
		validado.setColumns(10);
		validado.setBounds(145, 106, 221, 20);
		contentPane.add(validado);
		
		JLabel lblValido = new JLabel("VALIDO:");
		lblValido.setBounds(22, 109, 46, 14);
		contentPane.add(lblValido);
		
		JButton validar = new JButton("validar");
		validar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf2;
				cpf2 = cpf.getText();
				String validar;
				try {
					validar = consumo.validar_cpf(cpf2);
					validado.setText(validar);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		validar.setBounds(202, 57, 89, 23);
		contentPane.add(validar);

	}
}
