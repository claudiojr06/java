package Exemplo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField entrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
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
	public Tela1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Olá Mundo!");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBackground(new Color(128, 255, 255));
		titulo.setForeground(new Color(255, 0, 0));
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		titulo.setBounds(10, 11, 414, 43);
		contentPane.add(titulo);
		
		entrada = new JTextField();
		entrada.setBounds(20, 52, 404, 20);
		contentPane.add(entrada);
		entrada.setColumns(10);
		
		JButton botao = new JButton("Pesquisar");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titulo.setText(entrada.getText());
			}
		});
		botao.setBounds(84, 135, 248, 23);
		contentPane.add(botao);

	}
}
