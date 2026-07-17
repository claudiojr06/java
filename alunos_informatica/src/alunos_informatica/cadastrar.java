package alunos_informatica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField gnome;
	private JTextField gcpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrar frame = new cadastrar();
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
	public cadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nome = new JLabel("Nome");
		nome.setBounds(10, 30, 46, 14);
		contentPane.add(nome);
		
		JLabel cpf = new JLabel("CPF");
		cpf.setBounds(10, 75, 46, 14);
		contentPane.add(cpf);
		
		gnome = new JTextField();
		gnome.setBounds(49, 27, 375, 20);
		contentPane.add(gnome);
		gnome.setColumns(10);
		
		gcpf = new JTextField();
		gcpf.setBounds(49, 72, 375, 20);
		contentPane.add(gcpf);
		gcpf.setColumns(10);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados.(gnome.getText(), Integer.parseInt(gcpf.getText()));
				dispose();
			}
		});
		cadastrar.setBounds(63, 227, 114, 23);
		contentPane.add(cadastrar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(335, 227, 89, 23);
		contentPane.add(sair);

	}
}
