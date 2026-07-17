package consumo_api;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cad_jogo = new JButton("Cadastrar Jogo");
		cad_jogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarjogo cj = null;
				try {
					cj = new cadastrarjogo();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cj.setVisible(true);
			}
		});
		cad_jogo.setBounds(10, 11, 414, 33);
		contentPane.add(cad_jogo);
		
		JButton cad_selecao = new JButton("Cadastrar Seleção");
		cad_selecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarselecao cs = new cadastrarselecao();
				cs.setVisible(true);
			}
		});
		cad_selecao.setBounds(10, 65, 414, 33);
		contentPane.add(cad_selecao);
		
		JButton bus_jogo = new JButton("Buscar Jogo");
		bus_jogo.setBounds(10, 124, 414, 40);
		contentPane.add(bus_jogo);
		
		JButton bus_selecao = new JButton("Buscar Seleção");
		bus_selecao.setBounds(10, 188, 414, 40);
		contentPane.add(bus_selecao);

	}
}
