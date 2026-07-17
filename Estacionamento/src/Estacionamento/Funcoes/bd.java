package Estacionamento.Funcoes;

import java.sql.*;
import java.time.LocalDateTime;

public class bd {
	private static String url = "jdbc:mysql://localhost:3306/estacionamento";
	private static String user = "root";
	private static String password = "Senac@2026";

	public static Connection conexao() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static ResultSet select_veiculo() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM veiculo";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static ResultSet select_vaga() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM vaga";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void delete() throws SQLException {
		Connection con = conexao();
		String sqlDelete = "DELETE FROM TABLE WHERE COLUNA = ?";
		PreparedStatement stmt = con.prepareStatement(sqlDelete);
		stmt.setString(1, "VALOR");
		stmt.executeUpdate();
	}

	public static void update_vaga(int id) throws SQLException {
		Connection con = conexao();
		String sqlUpdate = "UPDATE vaga Set saida = ?WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(sqlUpdate);
		stmt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
		stmt.setInt(2, id);
		stmt.executeUpdate();
	}
	
	
	public static void insert_veiculo(String p, String m) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO veiculo (placa, modelo) VALUES (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setString(1, p);
		stmt.setString(2, m);
		stmt.executeUpdate();
	}
	public static void insert_vaga(String p,int v) throws SQLException {
		Connection con = conexao();
		String entrada=null;
		String sqlInsert = "INSERT INTO vaga(vaga, placa, entrada) VALUES (?,?, ?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setInt(1,v);
		stmt.setString(2, p);
		stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
		stmt.executeUpdate();
	}
}
