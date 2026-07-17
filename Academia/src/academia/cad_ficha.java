package academia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class cad_ficha extends JFrame {

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
					cad_ficha frame = new cad_ficha();
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
	public cad_ficha() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ficha = new JLabel("FICHA ");
		ficha.setHorizontalAlignment(SwingConstants.CENTER);
		ficha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		ficha.setBounds(10, 11, 414, 23);
		contentPane.add(ficha);
		
		JLabel musculo = new JLabel("MÚSCULO:");
		musculo.setBounds(10, 48, 120, 14);
		contentPane.add(musculo);
		
		JLabel exercicio = new JLabel("EXERCÍCIO:");
		exercicio.setBounds(10, 94, 76, 14);
		contentPane.add(exercicio);
		
		JLabel peso = new JLabel("PESO:");
		peso.setBounds(10, 138, 55, 14);
		contentPane.add(peso);
		
		JLabel cliente = new JLabel("CLIENTE:");
		cliente.setBounds(10, 185, 76, 14);
		contentPane.add(cliente);
		
		textField = new JTextField();
		textField.setBounds(96, 45, 250, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 91, 250, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 135, 250, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(98, 182, 248, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton cadastrar = new JButton("CADASTRAR");
		cadastrar.setForeground(new Color(0, 128, 0));
		cadastrar.setBackground(new Color(255, 255, 255));
		cadastrar.setBounds(75, 227, 101, 23);
		contentPane.add(cadastrar);
		
		JButton cancelar = new JButton("CANCELAR");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			dispose();
			}
		});
		cancelar.setForeground(new Color(255, 0, 0));
		cancelar.setBounds(257, 227, 89, 23);
		contentPane.add(cancelar);

	}

}
