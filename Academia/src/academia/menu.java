package academia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TITULO = new JLabel("ACADEMIA");
		TITULO.setForeground(new Color(0, 0, 0));
		TITULO.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 21));
		TITULO.setBounds(163, 11, 322, 26);
		contentPane.add(TITULO);
		
		JButton cadastrarcliente = new JButton("CADASTRAR CLIENTE\r\n");
		cadastrarcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cad_cliente cc=new cad_cliente();
					cc.setVisible(true);
					
			}
		});
		cadastrarcliente.setForeground(new Color(0, 0, 0));
		cadastrarcliente.setBackground(new Color(0, 128, 0));
		cadastrarcliente.setBounds(131, 108, 175, 23);
		contentPane.add(cadastrarcliente);
		
		JButton cadastrarficha = new JButton("CADASTRAR FICHA\r\n");
		cadastrarficha.setForeground(new Color(0, 0, 0));
		cadastrarficha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cad_ficha cf=new cad_ficha();
				cf.setVisible(true);
				
				
			}
		});
	
		cadastrarficha.setBackground(new Color(0, 128, 0));
		cadastrarficha.setBounds(131, 142, 175, 23);
		contentPane.add(cadastrarficha);
		
		JButton buscarcliente = new JButton("BUSCAR CLIENTE");
		buscarcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bus_cliente bc=new bus_cliente();
				bc.setVisible(true);
				dispose();
			}
		});
		buscarcliente.setBackground(new Color(0, 128, 0));
		buscarcliente.setForeground(new Color(0, 0, 0));
		buscarcliente.setBounds(131, 182, 175, 23);
		contentPane.add(buscarcliente);
		
		JButton sair = new JButton("SAIR");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setForeground(new Color(0, 0, 0));
		sair.setBackground(new Color(255, 0, 0));
		sair.setBounds(131, 227, 175, 23);
		contentPane.add(sair);
		
		JLabel SUBTITULO = new JLabel("MENU INICIAL");
		SUBTITULO.setForeground(new Color(0, 0, 0));
		SUBTITULO.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		SUBTITULO.setBounds(163, 61, 414, 23);
		contentPane.add(SUBTITULO);

	}
}
