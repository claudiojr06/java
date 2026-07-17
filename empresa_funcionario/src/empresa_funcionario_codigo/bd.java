package empresa_funcionario_codigo;

import java.sql.*;

public class bd {private static String url = "jdbc:mysql://localhost:3306/empresa_funcionarios";
private static String user = "root";
private static String password = "Senac@2026";

public static Connection conexao() throws SQLException {
return DriverManager.getConnection(url, user, password);
}

public static ResultSet select_demissao() throws SQLException {
Connection con = conexao();
String sqlSelect = "SELECT * FROM demissao";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sqlSelect);
return rs;
}

public static ResultSet select_funcionario() throws SQLException {
Connection con = conexao();
String sqlSelect = "SELECT * FROM funcionario";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sqlSelect);
return rs;
}

public static ResultSet select_login() throws SQLException {
Connection con = conexao();
String sqlSelect = "SELECT * FROM login";
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

public static void update() throws SQLException {
Connection con = conexao();
String sqlUpdate = "UPDATE TABELA SET COLUNA = ? WHERE COLUNA = ?";
PreparedStatement stmt = con.prepareStatement(sqlUpdate);
stmt.setString(1, "INFORMAÇÃO");
stmt.setString(2, "CAMPO BUSCADO");
stmt.executeUpdate();
}

public static void insert_demissao(int funcionario ,String motivo) throws SQLException {
Connection con = conexao();
String sqlInsert = "INSERT INTO demissao (id_funcionario,motivo,data_demissao) VALUES (?,?, now())";
PreparedStatement stmt = con.prepareStatement(sqlInsert);
stmt.setInt(1, funcionario);
stmt.setString(2, motivo);
stmt.executeUpdate();
}
public static void insert_funcionario(String n,String c,String d,String f) throws SQLException {
Connection con = conexao();
String sqlInsert = "INSERT INTO funcionario (nome,cpf,nascimento,funcao) VALUES (?, ?,?,?)";
PreparedStatement stmt = con.prepareStatement(sqlInsert);
stmt.setString(1, f);
stmt.setString(2, c);
stmt.setString(3, d);
stmt.setString(4, f);
stmt.executeUpdate();
}
public static void insert_login(String u,String s) throws SQLException {
Connection con = conexao();
String sqlInsert = "INSERT INTO login (usuario,senha) VALUES (?, ?)";
PreparedStatement stmt = con.prepareStatement(sqlInsert);
stmt.setString(1, u);
stmt.setString(2, s);
stmt.executeUpdate();
}


}
