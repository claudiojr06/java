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
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class relatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField produto;
	private JTextField quantidade;
	private JTextField cliente;
	private JTextField preco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relatorio frame = new relatorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public relatorio() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatorioDeVendas = new JLabel("Relatorio de Vendas");
		lblRelatorioDeVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorioDeVendas.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblRelatorioDeVendas.setBounds(10, 0, 414, 40);
		contentPane.add(lblRelatorioDeVendas);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Arial", Font.BOLD, 15));
		lblProduto.setBounds(30, 91, 82, 29);
		contentPane.add(lblProduto);
		
		produto = new JTextField();
		produto.setEditable(false);
		produto.setColumns(10);
		produto.setBounds(122, 91, 148, 20);
		contentPane.add(produto);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 15));
		lblQuantidade.setBounds(30, 127, 108, 29);
		contentPane.add(lblQuantidade);
		
		quantidade = new JTextField();
		quantidade.setEditable(false);
		quantidade.setColumns(10);
		quantidade.setBounds(122, 126, 148, 20);
		contentPane.add(quantidade);
		
		cliente = new JTextField();
		cliente.setEditable(false);
		cliente.setColumns(10);
		cliente.setBounds(122, 159, 148, 20);
		contentPane.add(cliente);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 15));
		lblCliente.setBounds(30, 159, 108, 29);
		contentPane.add(lblCliente);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setForeground(new Color(255, 0, 0));
		sair.setFont(new Font("Arial", Font.BOLD, 12));
		sair.setBounds(159, 235, 117, 29);
		contentPane.add(sair);
		
		JLabel lblVenda = new JLabel("Venda:");
		lblVenda.setFont(new Font("Arial", Font.BOLD, 15));
		lblVenda.setBounds(30, 51, 82, 29);
		contentPane.add(lblVenda);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setFont(new Font("Arial", Font.BOLD, 15));
		lblPreo.setBounds(30, 195, 108, 29);
		contentPane.add(lblPreo);
		
		preco = new JTextField();
		preco.setEditable(false);
		preco.setColumns(10);
		preco.setBounds(122, 195, 148, 20);
		contentPane.add(preco);
		
		JComboBox venda = new JComboBox();
		venda.setBounds(112, 53, 208, 22);
		contentPane.add(venda);
		ResultSet rs=bd.select_vendas();
		while(rs.next())
			venda.addItem(rs.getString("id"));
		venda.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indice = venda.getSelectedIndex();
				System.out.println(indice);
				try {
					ResultSet rs = bd.select_vendas();
					while(rs.next()) {
						if(venda.getSelectedItem().toString().equals(rs.getString("id"))) {
							produto.setText(rs.getString("nome"));
							quantidade.setText(rs.getString("id_quantidade"));
							cliente.setText(rs.getString("cpf"));
							int total = rs.getInt("preco")*rs.getInt("id_quantidade");
							preco.setText(""+total);
						}
					}				
					
				
					
			}	
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});

	}

}
