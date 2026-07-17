package urna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Deputado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField nome_do_candidato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deputado frame = new Deputado();
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
	public Deputado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 10, 65, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(85, 10, 65, 48);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(160, 10, 65, 48);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(235, 10, 65, 48);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(310, 10, 65, 48);
		contentPane.add(textField_4);
		
		JTextField[] campos =  {textField ,textField_1 , textField_2 ,textField_3 ,textField_4};
		//campos[3].setText("teste");
		
		JButton sete = new JButton("7");
		sete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(sete);
				controller.numero(campos,sete.getText(),nome_do_candidato);
			}
		});
		sete.setBounds(10, 85, 85, 48);
		contentPane.add(sete);
		
		JButton oito = new JButton("8");
		oito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(oito);
				controller.numero(campos,oito.getText(),nome_do_candidato);
			}
		});
		oito.setBounds(105, 85, 85, 48);
		contentPane.add(oito);
		
		JButton nove = new JButton("9");
		nove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(nove);
				controller.numero(campos,nove.getText(),nome_do_candidato);
			}
		});
		nove.setBounds(204, 85, 85, 48);
		contentPane.add(nove);
		
		JButton quatro = new JButton("4");
		quatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(quatro);
				controller.numero(campos,quatro.getText(),nome_do_candidato);
			}
		});
		quatro.setBounds(10, 141, 85, 48);
		contentPane.add(quatro);
		
		JButton cinco = new JButton("5");
		cinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.numero(campos,cinco.getText(),nome_do_candidato);
			}
		});
		cinco.setBounds(105, 143, 85, 48);
		contentPane.add(cinco);
		
		JButton seis = new JButton("6");
		seis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.numero(campos,seis.getText(),nome_do_candidato);
			}
		});
		seis.setBounds(204, 141, 85, 48);
		contentPane.add(seis);
		
		JButton um = new JButton("1");
		um.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.add(um);
				controller.numero(campos,um.getText(),nome_do_candidato);
			}
		});
		um.setBounds(10, 199, 85, 48);
		contentPane.add(um);
			
		JButton dois = new JButton("2");
		dois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.add(dois);
				controller.numero(campos,dois.getText(),nome_do_candidato);
			}
		});
		dois.setBounds(105, 201, 85, 48);
		contentPane.add(dois);
		
		
		
		JButton tres = new JButton("3");
		tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.add(tres);
				controller.numero(campos,tres.getText(),nome_do_candidato);
			}
		});
		tres.setBounds(204, 199, 85, 48);
		contentPane.add(tres);
		
	
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.add(zero);
				controller.numero(campos,zero.getText(),nome_do_candidato);
			}
		});
		zero.setBounds(105, 258, 85, 48);
		contentPane.add(zero);
		
		
		
		
		
		JButton branco = new JButton("Branco");
		branco.setBounds(310, 85, 270, 48);
		contentPane.add(branco);
		try {
			bd.insert_deputado(null);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.limpar(campos,nome_do_candidato);
			}
		});
		limpar.setBounds(310, 141, 270, 48);
		contentPane.add(limpar);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.salvar(campos);
				String num ="";
				for(int i=0;i<5;i++)
					num+=campos[i].getText();
				
				
				
				Presidente p = new Presidente();
				p.setVisible(rootPaneCheckingEnabled);
				dispose();
			}
		});
		confirmar.setBounds(310, 199, 270, 48);
		contentPane.add(confirmar);
		
		nome_do_candidato = new JTextField();
		nome_do_candidato.setEditable(false);
		nome_do_candidato.setBounds(385, 10, 195, 48);
		contentPane.add(nome_do_candidato);
		nome_do_candidato.setColumns(10);

	}
}
