package consumo_api;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastrarselecao extends JFrame {
	static JOptionPane mensagem = new JOptionPane();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pais;
	private JTextField grupo;
	private JTextField bandeira;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarselecao frame = new cadastrarselecao();
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
	public cadastrarselecao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel sss = new JLabel("PAÍS:");
		sss.setBounds(31, 23, 66, 14);
		contentPane.add(sss);
		
		pais = new JTextField();
		pais.setBounds(121, 20, 303, 20);
		contentPane.add(pais);
		pais.setColumns(10);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(31, 64, 66, 14);
		contentPane.add(lblGrupo);
		
		grupo = new JTextField();
		grupo.setColumns(10);
		grupo.setBounds(121, 61, 303, 20);
		contentPane.add(grupo);
		
		JLabel pais_1_1 = new JLabel("Bandeira:");
		pais_1_1.setBounds(31, 110, 66, 14);
		contentPane.add(pais_1_1);
		
		bandeira = new JTextField();
		bandeira.setColumns(10);
		bandeira.setBounds(121, 107, 303, 20);
		contentPane.add(bandeira);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if(!pais.getText().isEmpty()&& !grupo.getText().isEmpty() && !bandeira.getText().isEmpty())
				controller.valida_selecao(pais.getText(), grupo.getText(), bandeira.getText());
				
			}
		});
		cadastrar.setBounds(184, 154, 125, 23);
		contentPane.add(cadastrar);

	}
}
