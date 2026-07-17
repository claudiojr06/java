package hortfruit_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
		setBounds(100, 100, 399, 221);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Cad_Produto = new JButton("Cad Produto");
		Cad_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro_prod cp = new cadastro_prod();
				cp.setVisible(true);			}
		});
		Cad_Produto.setFont(new Font("Arial", Font.BOLD, 12));
		Cad_Produto.setBounds(53, 29, 117, 29);
		contentPane.add(Cad_Produto);
		
		JButton cliente = new JButton("Cad Cliente");
		cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro_cliente cc = new cadastro_cliente();
				cc.setVisible(true);
			}
		});
		cliente.setFont(new Font("Arial", Font.BOLD, 12));
		cliente.setBounds(194, 29, 117, 29);
		contentPane.add(cliente);
		
		JButton estoque = new JButton("Estoque");
		estoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estoque est = new estoque();
				est.setVisible(true);
			}
		});
		estoque.setFont(new Font("Arial", Font.BOLD, 12));
		estoque.setBounds(53, 69, 117, 29);
		contentPane.add(estoque);
		
		JButton relatorio = new JButton("Relatório");
		relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorio ret = null;
				try {
					ret = new relatorio();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ret.setVisible(true);
			}
		});
		relatorio.setFont(new Font("Arial", Font.BOLD, 12));
		relatorio.setBounds(194, 69, 117, 29);
		contentPane.add(relatorio);
		
		JButton vendas = new JButton("Vendas");
		vendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendas vd = null;
				try {
					vd = new vendas();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vd.setVisible(true);
			}
		});
		vendas.setFont(new Font("Arial", Font.BOLD, 12));
		vendas.setBounds(53, 109, 117, 29);
		contentPane.add(vendas);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setFont(new Font("Arial", Font.BOLD, 12));
		sair.setBounds(194, 109, 117, 29);
		contentPane.add(sair);

	}
}
