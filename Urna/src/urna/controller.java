package urna;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class controller {
	public static void numero(JTextField[] campos,String n, JTextField nome_candidato) {
		String nome="";
		for(int i=0;i<campos.length;i++)
			if(campos[i].getText().length()==0) {
				campos[i].setText(n);
				nome+= n;
				break;
			}
			else
				nome+= campos[i].getText();
		if(campos[campos.length-1].getText()!="") {
			try {
				ResultSet rs;
				if(campos.length == 5) {
				 rs= bd.select_deputado();
				}
				else
					{rs=bd.select_presidente();					
					}
				while(rs.next()) {
					if(rs.getString("numero").equals(nome))
						nome_candidato.setText(rs.getString("nome"));
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	public static int salvar (JTextField[] campos){
		String num ="";
		for(int i=0;i<campos.length;i++)
			num+= campos[i].getText();
			try {
				ResultSet rs;
				if(campos.length == 5)
				 rs= bd.select_deputado();
				else
					rs=bd.select_presidente();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return 0;
	}
	
	public static void limpar(JTextField[] campos,JTextField candidato) {
		for (int i=0;i<campos.length;i++)
			campos[i].setText("");
	candidato.setText(null);	
	}
	
		public static void branco(String candidato) {
			try {
				if(candidato.equals("deputado"))
				bd.insert_deputado(null);
				else
				bd.insert_presidente(null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
				
	}
}
