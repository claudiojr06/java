package governo;

import java.sql.SQLException;



public class gov_cadastro {
	String nome;
	String cpf;
	public void bd_gov(String n, String c) throws SQLException {
		nome = n;
		cpf = c;
		bd_gov.insert_cadastro(n, c);
		
	 	}	
	}			
