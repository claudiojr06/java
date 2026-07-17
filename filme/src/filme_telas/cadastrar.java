package filme_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import consumo.consumo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;


public class cadastrar extends JFrame {
	static JOptionPane mensagem = new JOptionPane();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filme;

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
		
		JLabel lblNewLabel = new JLabel("Cadastrar Filme");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Filme:");
		lblNewLabel_1.setBounds(10, 58, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Genero:");
		lblNewLabel_2.setBounds(10, 103, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		
		JFormattedTextField genero = new JFormattedTextField();
		genero.setBounds(121, 100, 227, 20);
		contentPane.add(genero);
		
		JLabel lblNewLabel_3 = new JLabel("Lançamento:");
		lblNewLabel_3.setBounds(10, 144, 82, 14);
		contentPane.add(lblNewLabel_3);
		MaskFormatter dat =null;
		try {
			dat=new MaskFormatter("####");
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField ano = new JFormattedTextField(dat);
		ano.setBounds(121, 141, 227, 20);
		contentPane.add(ano);
		
		
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(224, 206, 89, 23);
		contentPane.add(sair);
		
		//no botão de cadastrar validei que o ano precisa ser entre 1895 a 2026 e se todos os campos estão preenchidos para fazer o cadastro 
		//e o formato da mascara para permitir somente numeros
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					if ( Integer.parseInt(ano.getText().toString()) < 1895 
						|| Integer.parseInt(ano.getText().toString()) > 2026) {
						JOptionPane.showMessageDialog(null, "Lancamento invalido");
						
					}

					
						if (!genero.getText().toString().isEmpty() && !ano.getText().toString().isEmpty()
								&& Integer.parseInt(ano.getText().toString() )>= 1895 && Integer.parseInt(ano.getText().toString() )<= 2026){
							try {
								consumo.cadastrar_filmes(filme.getText(),ano.getText(),genero.getText());
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
								}
						 
						
						
								
				
						
					

				}

				private void genero(String lowerCase, int int1, String text) {
					// TODO Auto-generated method stub
					
				}
			});
				
					
				
					
					
	
	
		btnCadastrar.setBounds(66, 206, 106, 23);
		contentPane.add(btnCadastrar);
		
		filme = new JTextField();
		filme.setBounds(121, 55, 227, 20);
		contentPane.add(filme);
		filme.setColumns(10);
		
		
		
		

	}
}
