package governo;

import java.sql.*;



public class bd_gov {

	private static String url = "jdbc:mysql://localhost:3306/governo";
	private static String user = "root";
	private static String password = "Senac@2026";

	public static void main(String[] args) throws SQLException {
		select_cadastro();
		

	}

	public static Connection conexao() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	public static ResultSet select_cadastro(String cpf) throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM cadastro WHERE CPF= ?";
		PreparedStatement stmt = con.prepareStatement(sqlSelect);
		stmt.setString(1,cpf);
		ResultSet rsp = stmt.executeQuery();
		return rsp;
		
		
	}

	public static ResultSet select_cadastro() throws SQLException {
		Connection con = conexao();
		String sqlSelect = "SELECT * FROM cadastro ORDER BY nome ASC";
		Statement stmt = con.createStatement();
		ResultSet rsp = stmt.executeQuery(sqlSelect);
			System.out.println("\n\n\n");
		
		return rsp;
		
		
	}
	

	
	public static void delete() throws SQLException {
		Connection con = conexao();
		String sqlDelete = "DELETE FROM TABLE WHERE COLUNA = ?";
		PreparedStatement stmt = con.prepareStatement(sqlDelete);
		stmt.setString(1, "VALOR");
		stmt.executeUpdate();
	}

	public static void update() throws SQLException {
		Connection con = conexao();
		String sqlUpdate = "UPDATE TABELA SET COLUNA = ? WHERE COLUNA = ?";
		PreparedStatement stmt = con.prepareStatement(sqlUpdate);
		stmt.setString(1, "INFORMAÇÃO");
		stmt.setString(2, "CAMPO BUSCADO");
		stmt.executeUpdate();
	}

	public static void insert_cadastro(String n, String c) throws SQLException {
		Connection con = conexao();
		String sqlInsert = "INSERT INTO cadastro (nome, CPF) VALUES (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sqlInsert);
		stmt.setString(1, n);
		stmt.setString(2, c);

		stmt.executeUpdate();
	}
	
	
	


}



