package lista_telefonica.funcoes;

import java.sql.*;
import java.time.LocalDateTime;


public class bd_lista {private static String url = "jdbc:mysql://localhost:3306/listatelefonica";
private static String user = "claudio";
private static String password ="84016653av";

public static Connection conexao() throws SQLException {
return DriverManager.getConnection(url, user, password);
}

public static ResultSet select_pessoa() throws SQLException {
Connection con = conexao();
String sqlSelect = "SELECT * FROM pessoa";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sqlSelect);
return rs;
}

public static ResultSet select_log() throws SQLException {
Connection con = conexao();
String sqlSelect = "SELECT * FROM TABELA";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sqlSelect);
return rs;
}

public static void delete(int id) throws SQLException {
Connection con = conexao();
String sqlDelete = "DELETE FROM pessoa WHERE idpessoa = ?";
PreparedStatement stmt = con.prepareStatement(sqlDelete);
stmt.setInt(1, id);
stmt.executeUpdate();
}

public static void update_pessoa(int idpessoa,String telefone) throws SQLException {
Connection con = conexao();
String sqlUpdate = "UPDATE pessoa SET telefone = ? WHERE idpessoa = ?";
PreparedStatement stmt = con.prepareStatement(sqlUpdate);
stmt.setString(1, telefone);
stmt.setInt(2, idpessoa);
stmt.executeUpdate();
insert_log(idpessoa);
}

public static void insert_pessoa(String n ,String tel) throws SQLException {
Connection con = conexao();
String sqlInsert = "INSERT INTO pessoa (nome, telefone) VALUES (?, ?)";
PreparedStatement stmt = con.prepareStatement(sqlInsert);
stmt.setString(1, n);
stmt.setString(2, tel);
stmt.executeUpdate();
}


public static void insert_log(int idpessoa) throws SQLException {
Connection con = conexao();
String sqlInsert = "INSERT INTO log (idpessoa,data) VALUES (?,?)";
PreparedStatement stmt = con.prepareStatement(sqlInsert);
stmt.setInt(1, idpessoa);
stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
stmt.executeUpdate();
}

}
