package codigo;

import java.sql.*;

public class bd {
	private static String url = "jdbc:mysql://localhost:3306/Localizo";
	private static String user = "root";
	private static String password = "Senac@2026";

	public static Connection conexao() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

//FUNÇÕES DO USUARIO
	public static ResultSet select_usuario() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM usuario";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void insert_usuario(String nome, String cpf, String telefone, String endereco) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO usuario(nome, cpf, telefone, endereco) VALUES (?, ?, ?,?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setString(1, nome);
		stmt.setString(2, cpf);
		stmt.setString(3, telefone);
		stmt.setString(4, endereco);
		stmt.executeUpdate();
	}

//FUNÇÕES DO VEÍCULO
	public static ResultSet select_veiculo() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM veiculo";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void insert_veiculo(String marca, String modelo, String placa) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO veiculo(marca, modelo, placa) VALUES (?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setString(1, marca);
		stmt.setString(2, modelo);
		stmt.setString(3, placa);
		stmt.executeUpdate();
	}

//FUNÇÕES DO VÍNCULO
	public static ResultSet select_vinculo() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "select vinculo.id,usuario.cpf,veiculo.placa, veiculo.marca , veiculo.modelo, vinculo.ativo from vinculo\r\n"
				+ "inner join usuario on usuario.id=vinculo.id_usuario\r\n"
				+ "inner join veiculo on veiculo.id=vinculo.id_veiculo";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void insert_vinculo(int id_u, int id_v) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO vinculo(id_usuario, id_veiculo, ativo, data_criacao) VALUES (?, ?, 1, now())";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setInt(1, id_u);
		stmt.setInt(2, id_v);
		stmt.executeUpdate();
	}

	public static void update_vinculo(int id) throws SQLException {
		Connection con = conexao();
		String sqlUpdate = "UPDATE vinculo SET ativo = 0, data_modificacao = now() WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sqlUpdate);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}

}
