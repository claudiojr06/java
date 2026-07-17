package consumo_api;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class cadastrarjogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mandante;
	private JTextField visitante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarjogo frame = new cadastrarjogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public cadastrarjogo() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mandante:");
		lblNewLabel.setBounds(10, 24, 81, 14);
		contentPane.add(lblNewLabel);
		
		mandante = new JTextField();
		mandante.setBounds(77, 21, 225, 20);
		contentPane.add(mandante);
		mandante.setColumns(10);
		
		JLabel lblVisitante = new JLabel("Visitante:");
		lblVisitante.setBounds(10, 73, 81, 14);
		contentPane.add(lblVisitante);
		
		visitante = new JTextField();
		visitante.setColumns(10);
		visitante.setBounds(77, 70, 225, 20);
		contentPane.add(visitante);
		
		JLabel lblVisitante_1 = new JLabel("DATA:");
		lblVisitante_1.setBounds(10, 129, 81, 14);
		contentPane.add(lblVisitante_1);
		
		MaskFormatter mk = new MaskFormatter ("##/##/2026");
		JFormattedTextField data = new JFormattedTextField(mk);
		data.setBounds(77, 126, 225, 20);
		contentPane.add(data);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!mandante.getText().isEmpty()&& !visitante.getText().isEmpty()&&!data.getText().equals("  /  /2026"))
				controller.valida_jogo(mandante.getText(), visitante.getText(), data.getText());
			}
		});
		cadastrar.setBounds(129, 174, 124, 23);
		contentPane.add(cadastrar);
		
		

	}
}
