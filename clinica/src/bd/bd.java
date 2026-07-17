package bd;

import java.sql.*;

public class bd {
	private static String url = "jdbc:mysql://localhost:3306/clinica";
	private static String user = "root";
	private static String password = "Senac@2026";

	public static Connection conexao() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static ResultSet select_paciente() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM paciente";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void insert_paciente(String nome, String cpf, String telefone) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO paciente(nome, cpf, telefone) VALUES (?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setString(1, nome);
		stmt.setString(2, cpf);
		stmt.setString(3, telefone);
		stmt.executeUpdate();
	}

	public static ResultSet select_horario() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "select dataa, paciente.nome, paciente.cpf, telefone from horario INNER JOIN paciente on id_paciente = paciente.id";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelect);
		return rs;
	}

	public static void insert_horario(int nome,String data) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO horario(id_paciente,dataa) VALUES (?,?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setInt(1,nome );
		stmt.setString(2,data );
		stmt.executeUpdate();
	}



//	public static void update_estoque(int id) throws SQLException {
	//	Connection con = conexao();
		//String sqlUpdate = "UPDATE vinculo SET ativo = 0, data_modificacao = now() WHERE id = ?";
		//PreparedStatement stmt = con.prepareStatement(sqlUpdate);
		//stmt.setInt(1, id);
	//	stmt.executeUpdate();
	//}
//	public static void insert_estoque(int id_pro,String validade, int quantidade) throws SQLException {
	//	//Connection con = conexao();
		//String sqlInsert = "INSERT INTO estoque(id_produto, validade, quantidade) VALUES (?, ?, ?)";
		//PreparedStatement stmt = con.prepareStatement(sqlInsert);
		//stmt.setInt(1, id_pro);
		//stmt.setString(2, validade);
	//	stmt.setInt(3, quantidade);
//		stmt.executeUpdate();
	}
