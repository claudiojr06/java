package urna;

import java.sql.*;

public class bd {
	// DOWNLOAD MYSQL CONNECTOR: https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j-9.6.0.zip


		private static String url = "jdbc:mysql://localhost:3306/urna";
		private static String user = "root";
	        private static String password = "Senac@2026";

		public static Connection conexao() throws SQLException {
			return DriverManager.getConnection(url, user, password);
		}
	// FUNÇÕES DO USUARIO
		public static ResultSet select_deputado() throws SQLException {
			Connection con = conexao();
			String sqlSelect = "SELECT * FROM deputado";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			return rs;
		}
		public static void insert_deputado(String numero) throws SQLException {
			Connection con = conexao();
			String sqlInsert = "INSERT INTO voto_deputado(numero) VALUES (?)";
			PreparedStatement stmt = con.prepareStatement(sqlInsert);
			stmt.setString(1, numero);
			stmt.executeUpdate();
		}
		public static ResultSet select_presidente() throws SQLException {
			Connection con = conexao();
			String sqlSelect = "SELECT * FROM presidente";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			return rs;
		}
		public static void insert_presidente(String numero) throws SQLException {
			Connection con = conexao();
			String sqlInsert = "INSERT INTO voto_presidente(numero) VALUES (?)";
			PreparedStatement stmt = con.prepareStatement(sqlInsert);
			stmt.setString(1, numero);
			stmt.executeUpdate();
		}

}
