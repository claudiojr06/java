package consumo_api;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class controller {
	static String grupo2;
	static JOptionPane mensagem = new JOptionPane();

	//valida_grupo: função para validar se o grupo ja existe
	public static boolean valida_grupo(String grupo) {
		grupo2 = grupo.replaceAll(" ", "").toUpperCase(); //pegara tudo do grupo e substituira espaços por nada e colocara as caracteres em maiusculo
		if (!grupo2.contains("GRUPO")) {
			mensagem.showMessageDialog(mensagem, "Grupo Invalido");
			return false;
		}// !=nao se o grupo escritor for diferente dos que contem dara a mensagem de grupo invalido
		else {
			//caso passe do primeiro IF , o segundo validara o comprimento do grupo digitado for diferente de  6 caracteres sera invalido
			if (grupo2.length() != 6) {
				mensagem.showMessageDialog(mensagem, "O formato do grupo está incorreto");
				return false;
			} else {
				// proxima validação sera se o grupo é valido pegando o grupo digitado e substituindo colocando um espaço , e depois pegando a ultima caractere
				//e validando se ela esta entre 65 ate 76 que sao os numeros na programação para verificar de A ate L
				grupo2 = grupo2.replaceAll("GRUPO", "GRUPO ").toUpperCase();
				char ultimo = grupo2.charAt(grupo.length() - 1);
				if ((int) ultimo < 65 || (int) ultimo > 76) {
					mensagem.showMessageDialog(mensagem, "Grupo Invalido");
					return false;
				}
				// se tudo estiver correto a validação do grupo estara feita faltando as outras coisas 

				else {
					System.out.println(grupo2);
				}
			}
		}

		return true;
		}
	//função para validar a bandeira

	public static boolean valida_bandeira(String bandeira) {
		//primeiro if sera para verificar se contem espaço se tiver espaço dara a mensagem de Endereço incorreto
		if (bandeira.contains(" ")) {
			mensagem.showMessageDialog(mensagem, "Endereço incorreto");
			return false;
		}
		//apos validar que não possui espaço a proxima validação sera se o endereço começa com "https://www.bandeirasnacionais.com/"
		// se não iniciar dara a mensagem de endereço incorreto
		if(!bandeira.startsWith("https://www.bandeirasnacionais.com/")) {
			mensagem.showMessageDialog(mensagem, "Endereço incorreto:");
		}
		
	return true;	
	}
	//validar o pais
	public static boolean valida_pais(String pais) {
	//primeiro criamos a o JsonObject para pegar uma parte do array
		// if o paises for igual ao pais digitado retornara verdaeiro caso não esteja na lista o pais retornara a mensagem de pais não encontrado
		try {
		JSONObject jo;
		JSONArray array = consumo.pesquisa_paises();
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
		// aqui serão as funçoes que vão ser utilizadas para validar os jogos cadastrados
	public static void valida_jogo(String mandante ,String visitante, String data) {
		boolean si =selecao_igual(mandante , visitante);
		boolean jr =valida_jogo_repetido(mandante,visitante);
		boolean jd =valida_jogo_dia(mandante , visitante, data);
		boolean tjM = valida_total_jogo(mandante);
		boolean tjV= valida_total_jogo(visitante);
		boolean sg =valida_selecao_grupo(mandante,visitante);
	}
// validação para o cadastro da seleção , primeiro valida se o grupo , bandeira e pais existe
	public static void valida_selecao(String pais, String grupo, String bandeira) {
		JSONArray array;
		JSONObject jo;
		boolean gru = valida_grupo(grupo);
		boolean ban = valida_bandeira(bandeira);
		boolean pai = valida_pais(pais);
		if(gru == true && ban == true && pai== true) {
		

		System.out.println(grupo);
		int gp = 0, i = 0;
		//primeiro if vai validar se o pais ja foi cadastrado se ele for igual a um cadastrado dara a mensagem , se não tiver cadastrado passara para a proxima validação
		try {
			System.out.println("AS");
			array = consumo.pesquisa_selecao();
			for (i = 0; i < array.size(); i++) {
				jo = (JSONObject) array.get(i);
				if (jo.get("pais").toString().toUpperCase().equals(pais.toUpperCase())) {
					mensagem.showMessageDialog(mensagem, "Pais já Cadastrado");
					break;
					//segundo if sera para selecionar o grupo e adicionar o pais na posição e aumentar 1 posição para o proximo pais ser cadastro e verificar se ja chegou no limite no grupo
				}
				if (jo.get("grupo").toString().toUpperCase().equals(grupo2.toUpperCase()))
					gp++;
				
				//Terceiro if sera para validar se a bandeira ja esta cadastrada
				if (jo.get("bandeira").toString().toUpperCase().equals(bandeira.toUpperCase())) {
					mensagem.showMessageDialog(mensagem, "Bandeira já Cadastrado.");
					break;
				}
				// quarto if sera para verificar se o tamanho da posição no grupo é menor que 4 se for maior dara a mensagem que o grupo ja esta cheio 
			}
			if (i == array.size() && gp < 4)
				consumo.cadastrar_selecao(pais, grupo2, bandeira);
			else {
				mensagem.showMessageDialog(mensagem, "Grupo ja Preenchido por completo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
		}
		// validar se as seleções não vão ser iguais 
	public static boolean selecao_igual(String mandante , String visitante) {
		// esta verificando se o mandante não sera igual ao visitante se forem igual dara a mensagem 
		if(mandante.equals(visitante)) {
			mensagem.showMessageDialog(mensagem, "Mandante e visitante iguais");
			return true;
		}
		return false;
	}
	// valida se o jogo ja foi cadastrado
		public static boolean valida_jogo_repetido(String mandante , String visitante) {
			// primeiro ele percorre as posições dos jogos ja cadastrado ate o tamanho do array
			//depois ele pegara o mandante e o visitante e validaera se o mandante e visitante ja estao cadastrados nessas posições nesse jogo  tanto como mandante como visitante
			//se tiver cadastrado ele dara a mensagem de ja cadastrado
			try {
				JSONArray array = consumo.pesquisa_jogos();
				for(int i= 0;i<array.size();i++) {
					JSONObject objeto = (JSONObject) array.get(i);
					if (objeto.get("mandante").toString().toUpperCase().equals(mandante.toUpperCase())) {
						if (objeto.get("visitante").toString().toUpperCase().equals(visitante.toUpperCase())) {
							mensagem.showMessageDialog(mensagem, "Jogo ja cadastrado");
							return true;
						}
					}
					
					if (objeto.get("mandante").toString().toUpperCase().equals(visitante.toUpperCase())) {
						if (objeto.get("visitante").toString().toUpperCase().equals(mandante.toUpperCase())) {
							mensagem.showMessageDialog(mensagem, "Jogo ja cadastrado");
							return true;
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		public static boolean valida_jogo_dia(String mandante , String visitante , String data) {
			try {
				//valida jogo dia 
				JSONArray array = consumo.pesquisa_jogos();
				// ele percorrera as posições do array e verificara o objeto data
				//se a data for igual a data cadastrada ele verificara se a seleção mandante e visitante ja tem jogo nesse dia , se tiver 
				//ele dara a mensagem que a seleção ja possui jogo nessa data
				for(int i= 0;i<array.size();i++) {
					JSONObject objeto = (JSONObject) array.get(i);
					if (objeto.get("data").equals(data)) {
						if (objeto.get("mandante").toString().toUpperCase().equals(mandante.toUpperCase())
						||(objeto.get("visitante").toString().toUpperCase().equals(mandante.toUpperCase()))){
							mensagem.showMessageDialog(mensagem, mandante + " Ja possui jogo nessa data");
							return true;
						}
					
					if (objeto.get("data").equals(data)) {
						if (objeto.get("mandante").toString().toUpperCase().equals(visitante.toUpperCase())
						||(objeto.get("visitante").toString().toUpperCase().equals(visitante.toUpperCase()))){
							mensagem.showMessageDialog(mensagem, visitante + " Ja possui jogo nessa data");
							return true;
							}
						}	
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		public static boolean valida_total_jogo(String pais) {
			try {
			int total_jogos=0;
				JSONArray array = consumo.pesquisa_jogos();
			//ele vai percorrer as posições do array e pegara os objetos mandante e visitante para verificar se o pais possui 3 jogos ja cadastrado
			//se ele tiver os 3 jogos ja cadastrado o sistema dara a mensagem que todos os jogos do pais ja estão cadastrados
			for(int i= 0;i<array.size();i++) {
				JSONObject objeto = (JSONObject) array.get(i);
				if (objeto.get("mandante").toString().toUpperCase().equals(pais.toUpperCase())) {
					total_jogos++;
				}
				if (objeto.get("visitante").toString().toUpperCase().equals(pais.toUpperCase())){
					total_jogos++;
				
				}
						
		}
			if(total_jogos == 3) {
				mensagem.showMessageDialog(mensagem,pais +" já possui todos os jogos cadastrados" );
				return false;
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
			return false;
		}
		//vai validar se as seleçoes estão no mesmo grupo
		public static boolean valida_selecao_grupo(String mandante , String visitante) {
			try {
				String grupoMandante = "a" , grupoVisitante = "b";
				JSONArray array = consumo.pesquisa_selecao();
				
				//percorre o array e pegara o objeto pais e verifica o grupo tanto do mandante quanto do visitante
				//depois vai comparar para ver se os grupos são iguais , se nao for dara a mensagem de que as seleções possuem grupos diferentes 
					for(int i =0 ;i<array.size() ;i++) {
						JSONObject objeto = (JSONObject)array.get(i);
						if(objeto.get("pais").toString().toUpperCase().equals(mandante.toUpperCase())){
							grupoMandante= objeto.get("grupo").toString();
						}
						if(objeto.get("pais").toString().toUpperCase().equals(visitante.toUpperCase())){
							grupoVisitante= objeto.get("grupo").toString();
						}
						if(grupoMandante.equals(grupoVisitante)) {
							return true;
						}
					}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mensagem.showMessageDialog(mensagem, "As seleções possuem grupos diferentes");
			return false;
		}
}
