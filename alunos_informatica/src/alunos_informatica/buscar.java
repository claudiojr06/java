package alunos_informatica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class buscar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpf;
	private JTextField nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buscar frame = new buscar();
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
	public buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(10, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		cpf = new JTextField();
		cpf.setBounds(64, 27, 226, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aluno a;
				a=dados.buscar_cpf(Integer.parseInt(cpf.getText()));
				nome.setText(a.nome);
			}
		});
		buscar.setBounds(300, 26, 123, 23);
		contentPane.add(buscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 73, 46, 14);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setEditable(false);
		nome.setColumns(10);
		nome.setBounds(64, 70, 359, 20);
		contentPane.add(nome);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(150, 128, 89, 23);
		contentPane.add(btnNewButton_1);

	}

}
