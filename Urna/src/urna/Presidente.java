package urna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Presidente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_11;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presidente frame = new Presidente();
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
	public Presidente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_2 = new JPanel();
		contentPane_2.setLayout(null);
		contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_2.setBounds(10, 10, 590, 316);
		contentPane.add(contentPane_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 10, 65, 48);
		contentPane_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(85, 10, 65, 48);
		contentPane_2.add(textField_7);
		
		JTextField[] campos =  {textField_6 ,textField_7 };
		
		JButton sete_1 = new JButton("7");
		sete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,sete_1.getText(),textField_11);
			}
		});
		sete_1.setBounds(10, 85, 85, 48);
		contentPane_2.add(sete_1);
		
		JButton oito_1 = new JButton("8");
		oito_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,oito_1.getText(),textField_11);
			}
		});
		oito_1.setBounds(105, 85, 85, 48);
		contentPane_2.add(oito_1);
		
		JButton nove_1 = new JButton("9");
		nove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,nove_1.getText(),textField_11);
			}
		});
		nove_1.setBounds(204, 85, 85, 48);
		contentPane_2.add(nove_1);
		
		JButton quatro_1 = new JButton("4");
		quatro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,quatro_1.getText(),textField_11);
			}
		});
		quatro_1.setBounds(10, 141, 85, 48);
		contentPane_2.add(quatro_1);
		
		JButton cinco_1 = new JButton("5");
		cinco_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,cinco_1.getText(),textField_11);
			}
		});
		cinco_1.setBounds(105, 143, 85, 48);
		contentPane_2.add(cinco_1);
		
		JButton seis_1 = new JButton("6");
		seis_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,seis_1.getText(),textField_11);
			}
		});
		seis_1.setBounds(204, 141, 85, 48);
		contentPane_2.add(seis_1);
		
		JButton um_1 = new JButton("1");
		um_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,um_1.getText(),textField_11);
			
			}
		});
		um_1.setBounds(10, 199, 85, 48);
		contentPane_2.add(um_1);
		
		JButton dois_1 = new JButton("2");
		dois_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,dois_1.getText(),textField_11);
			}
		});
		dois_1.setBounds(105, 201, 85, 48);
		contentPane_2.add(dois_1);
		
		JButton tres_1 = new JButton("3");
		tres_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,tres_1.getText(),textField_11);
			}
		});
		tres_1.setBounds(204, 199, 85, 48);
		contentPane_2.add(tres_1);
		
		JButton zero_1 = new JButton("0");
		zero_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.numero(campos,zero_1.getText(),textField_11);

			}
		});
		zero_1.setBounds(105, 258, 85, 48);
		contentPane_2.add(zero_1);
		
		JButton branco_1 = new JButton("Branco");
		branco_1.setBounds(310, 85, 270, 48);
		contentPane_2.add(branco_1);
		
		JButton limpar_1 = new JButton("Limpar");
		limpar_1.setBounds(310, 141, 270, 48);
		contentPane_2.add(limpar_1);
		
		JButton confirmar_1 = new JButton("Confirmar");
		confirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		confirmar_1.setBounds(310, 199, 270, 48);
		contentPane_2.add(confirmar_1);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(172, 10, 408, 48);
		contentPane_2.add(textField_11);

	}
}
