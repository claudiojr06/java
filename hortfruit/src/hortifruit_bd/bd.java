package hortifruit_bd;

import java.sql.*;

public class bd {
	private static String url = "jdbc:mysql://localhost:3306/hortfruit";
	private static String user = "root";
	private static String password = "Senac@2026";

	public static Connection conexao() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

//FUNÇÕES DO USUARIO
	public static ResultSet select_cliente() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM cliente";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void insert_cliente(String nome, String cpf, String telefone) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO cliente(nome, cpf, telefone) VALUES (?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setString(1, nome);
		stmt.setString(2, cpf);
		stmt.setString(3, telefone);
		stmt.executeUpdate();
	}

//FUNÇÕES DO VEÍCULO
	public static ResultSet select_produto() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM produto";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void insert_produto(String nome, float preco) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO produto(nome, preco) VALUES (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setString(1, nome);
		stmt.setFloat(2, preco);
		stmt.executeUpdate();
	}

//FUNÇÕES DO VÍNCULO
	public static ResultSet select_vendas() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "select vendas.id,cliente.cpf,produto.nome, vendas.id_quantidade, produto.preco from vendas inner join cliente on cliente.id=vendas.id_cliente inner join produto on produto.id=vendas.id_produto";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void insert_venda(int id_p, int id_q, int id_c) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO vendas(id_produto, id_quantidade, id_cliente, dataa) VALUES (?, ?, ?, now())";
		String sqlUpdate = "UPDATE estoque set quantidade = ? where id = ?";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setInt(1, id_p);
		stmt.setInt(2, id_q);
		stmt.setInt(3, id_c);
		stmt.executeUpdate();
		stmt = con.prepareStatement(sqlUpdate);
		stmt.setInt(1, id_q);
		stmt.setInt(2, id_p);
		stmt.executeUpdate();
	}

	public static void update_estoque(int id) throws SQLException {
		Connection con = conexao();
		String sqlUpdate = "UPDATE vinculo SET ativo = 0, data_modificacao = now() WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sqlUpdate);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	public static void insert_estoque(int id_pro,String validade, int quantidade) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO estoque(id_produto, validade, quantidade) VALUES (?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setInt(1, id_pro);
		stmt.setString(2, validade);
		stmt.setInt(3, quantidade);
		stmt.executeUpdate();
	}
}
