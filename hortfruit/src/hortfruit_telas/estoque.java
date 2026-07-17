package hortfruit_telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hortifruit_bd.bd;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class estoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField quantidade;
	private JTextField validade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					estoque frame = new estoque();
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
	public estoque() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoque.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblEstoque.setBounds(118, 0, 188, 40);
		contentPane.add(lblEstoque);

		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Arial", Font.BOLD, 15));
		lblProduto.setBounds(28, 58, 82, 29);
		contentPane.add(lblProduto);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 15));
		lblQuantidade.setBounds(28, 143, 108, 29);
		contentPane.add(lblQuantidade);

		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setForeground(new Color(255, 0, 0));
		sair.setFont(new Font("Arial", Font.BOLD, 12));
		sair.setBounds(232, 203, 117, 29);
		contentPane.add(sair);

		quantidade = new JTextField();
		quantidade.setColumns(10);
		quantidade.setBounds(146, 148, 132, 20);
		contentPane.add(quantidade);

		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setFont(new Font("Arial", Font.BOLD, 15));
		lblValidade.setBounds(28, 98, 108, 29);
		contentPane.add(lblValidade);

		validade = new JTextField();
		validade.setColumns(10);
		validade.setBounds(146, 103, 132, 20);
		contentPane.add(validade);

		JComboBox produto = new JComboBox();
		produto.setBounds(146, 62, 132, 22);
		contentPane.add(produto);
		ResultSet rs = null;
		try {
			rs = bd.select_produto();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					produto.addItem(rs.getString("nome"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		produto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indice = produto.getSelectedIndex();
				System.out.println(indice);
				try {
					ResultSet rs = bd.select_produto();
					for (int i = 0; i <= indice; i++) {
						rs.next();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton salvar = new JButton("Salvar Alteração");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice_pro = produto.getSelectedIndex();
				try {
					ResultSet rs = bd.select_produto();
					for (int i = 0; i <= indice_pro; i++)
						rs.next();
					int id_produto = rs.getInt("id");
					rs = bd.select_produto();
					bd.insert_estoque(id_produto, validade.getText(), Integer.parseInt(quantidade.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		salvar.setFont(new Font("Arial", Font.BOLD, 12));
		salvar.setBounds(65, 203, 138, 29);
		contentPane.add(salvar);
	}
}
