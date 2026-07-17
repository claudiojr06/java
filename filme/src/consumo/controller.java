package consumo;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


//no controller tentei fazer uma função para verificar se o Filme esta cadastrado mas não consegui puxar 


public class controller {
	static JOptionPane mensagem = new JOptionPane();
	
	public static boolean pesquisa_filme(String filme) {
			try {
			JSONObject jo;
			JSONArray array = consumo.pesquisa_filme();
			for(int i = 0;i<array.size();i++) {
				jo = (JSONObject) array.get(i);
				if(jo.get("filme").toString().equals(filme()))
					return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		mensagem.showMessageDialog(mensagem, "Filme não encontrado.");
		return false;
		}

	private static Object filme() {
		// TODO Auto-generated method stub
		return null;
	}


}
