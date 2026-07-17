package tela;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class controller {
	static String grupo2;
	static JOptionPane mensagem = new JOptionPane();
	

		public static boolean valida_grupo(String grupo) {
			grupo2 = grupo.replaceAll(" ", "").toUpperCase(); 
			if (!grupo2.contains("GRUPO")) {
				mensagem.showMessageDialog(mensagem, "Grupo Não Existe");
				return false;
			}
			else {
				
				if (grupo2.length() != 6) {
					mensagem.showMessageDialog(mensagem, "O formato do grupo está incorreto");
					return false;
				} else {
					
					grupo2 = grupo2.replaceAll("GRUPO", "GRUPO ").toUpperCase();
					char ultimo = grupo2.charAt(grupo.length() - 1);
					if ((int) ultimo < 65 || (int) ultimo > 76) {
						mensagem.showMessageDialog(mensagem, "Grupo Não Exista digite somente de A até L");
						return false;
					}
					
					else {
						System.out.println(grupo2);
					}
				}
			}

			return true;
			}
		
		public static boolean valida_pais(String pais) {
				try {
				JSONObject jo;
				JSONArray array = codigo.pesquisa_paises();
				for(int i = 0;i<array.size();i++) {
					jo = (JSONObject) array.get(i);
					if(jo.get("paises").toString().toUpperCase().equals(pais.toUpperCase()))
						return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			mensagem.showMessageDialog(mensagem, "País não encontrado.");
			return false;
			}
		
		public static boolean valida_bandeira(String bandeira) {
		
			if (bandeira.contains(" ")) {
				mensagem.showMessageDialog(mensagem, "link da bandeira não contem espaço");
				return false;
			}
			
			if(!bandeira.startsWith("https://www.bandeirasnacionais.com/")) {
				mensagem.showMessageDialog(mensagem, "Endereço incorreto:");
			}
			
		return true;	
		
		}
}
