package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(161, 0, 91, 29);
		lblMenu.setForeground(new Color(0, 128, 255));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		contentPane.add(lblMenu);
		
		JButton btnCadpaciente = new JButton("cad-paciente");
		btnCadpaciente.setBounds(10, 43, 130, 39);
		contentPane.add(btnCadpaciente);
		
		JButton btnCadmedico = new JButton("cad-medico");
		btnCadmedico.setBounds(161, 43, 130, 39);
		contentPane.add(btnCadmedico);
		
		JButton btnFaturamento = new JButton("faturamento");
		btnFaturamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valores v = new valores();
				v.setVisible(true);
			}
		});
		btnFaturamento.setBounds(10, 211, 130, 39);
		contentPane.add(btnFaturamento);
		
		JButton btnSair = new JButton("sair");
		btnSair.setSelectedIcon(null);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setBounds(304, 211, 130, 39);
		contentPane.add(btnSair);
		
		JButton btnConsultas = new JButton("consultas");
		btnConsultas.setBounds(10, 119, 130, 39);
		contentPane.add(btnConsultas);
		
		JButton btnExames = new JButton("exames");
		btnExames.setBounds(161, 119, 130, 39);
		contentPane.add(btnExames);
		
		JButton btnInternaes = new JButton("internações");
		btnInternaes.setBounds(161, 211, 130, 39);
		contentPane.add(btnInternaes);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alfredo Vasconcelos\\Downloads\\ze-gotinha_edit-770x416.jpg"));
		lblNewLabel.setBounds(-14, -2, 529, 287);
		contentPane.add(lblNewLabel);

	}

}
