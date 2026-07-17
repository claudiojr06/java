package hortfruit_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hortifruit_bd.bd;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class vendas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField quantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vendas frame = new vendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public vendas() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setBackground(new Color(224, 255, 255));
		lblVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendas.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblVendas.setBounds(10, 0, 414, 40);
		contentPane.add(lblVendas);

		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Arial", Font.BOLD, 15));
		lblProduto.setBounds(56, 57, 82, 29);
		contentPane.add(lblProduto);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 15));
		lblQuantidade.setBounds(46, 97, 108, 29);
		contentPane.add(lblQuantidade);

		quantidade = new JTextField();
		quantidade.setColumns(10);
		quantidade.setBounds(148, 102, 148, 20);
		contentPane.add(quantidade);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 15));
		lblCliente.setBounds(46, 147, 108, 29);
		contentPane.add(lblCliente);

		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setForeground(new Color(255, 0, 0));
		sair.setFont(new Font("Arial", Font.BOLD, 12));
		sair.setBounds(281, 221, 117, 29);
		contentPane.add(sair);

		JComboBox produto = new JComboBox();
		produto.setBounds(148, 61, 148, 25);
		contentPane.add(produto);
		ResultSet rs = null;
		try {
			rs = bd.select_produto();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (rs.next()) {
			produto.addItem(rs.getString("nome"));
		}

		JComboBox cliente = new JComboBox();
		cliente.setBounds(148, 150, 148, 25);
		contentPane.add(cliente);
		ResultSet rs2 = null;
		try {
			rs2 = bd.select_cliente();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (rs2.next()) {
			cliente.addItem(rs2.getString("cpf"));
		}

		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice_pro = produto.getSelectedIndex();
				try {
					ResultSet rs = bd.select_produto();
					for (int i = 0; i <= indice_pro; i++)
						rs.next();
					int id_produto = rs.getInt("id");
					rs = bd.select_produto();
					int indice_cli = cliente.getSelectedIndex();
					ResultSet rs2 = bd.select_cliente();
					for (int i = 0; i <= indice_cli; i++)
						rs2.next();
					int id_cliente = rs2.getInt("id");
					rs2 = bd.select_cliente();
					bd.insert_venda(id_produto, Integer.parseInt(quantidade.getText()), id_cliente);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnRealizarVenda.setFont(new Font("Arial", Font.BOLD, 12));
		btnRealizarVenda.setBounds(70, 221, 117, 29);
		contentPane.add(btnRealizarVenda);

	}
}
