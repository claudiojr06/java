package consumo_api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class consumo {
	static String endereco = "http://192.168.0.225:3000/";
	public static void main (String [] args) throws Exception{
		//int cep = 36272000;
		//pesquisa_cep(cep);
		//validar_cpf("639.313.460-72");
		//validar_cnpj("39.801.879/0001-06");
		//validar_nome("Bulbasaur");
		//cadastrar_selecao("Cruzeiro","A++","Maior");
		
	}
	public static void pesquisa_cep(int cep) throws Exception {
	HttpClient client = HttpClient.newHttpClient();
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(endereco + "cep/"+cep))
			.GET()
			.build();
	HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
	System.out.println("Status Code: "+ response.statusCode());
	JSONObject objeto;
	JSONParser parser = new JSONParser();
	objeto = (JSONObject) parser.parse(response.body());
	System.out.println("CEP: " + objeto.get("cep"));
	System.out.println("Rua: " + objeto.get("logradouro"));
	System.out.println("Bairro: " + objeto.get("bairro"));
	System.out.println("Cidade: " + objeto.get("cidade"));
	System.out.println("Estado: " + objeto.get("estado"));
	
	}
	
	
	public static String validar_cpf(String cpf) throws Exception{
		HttpClient client = HttpClient.newHttpClient();
		String jsonInput= """
		{
			"cpf": "%s"
		}
		""".formatted(cpf);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco + "validar/cpf"))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(jsonInput))
				.build();
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
		System.out.println("Status Code: "+ response.statusCode());
		JSONObject objeto;
		JSONParser parser = new JSONParser();
		objeto = (JSONObject) parser.parse(response.body());
		System.out.println("CPF: " + objeto.get("cpf"));
		System.out.println("VALIDO: " + objeto.get("valido"));
		return objeto.get("valido").toString();
	
	}
	
	public static String validar_cnpj(String cnpj) throws Exception{
		HttpClient client = HttpClient.newHttpClient();// vai ser o client para fazer a requisição
		String jsonInput= """
		{
			"cnpj": "%s"
		}
		""".formatted(cnpj);
		HttpRequest request = HttpRequest.newBuilder() // vai ser a requisiçao que o client solicitação
				.uri(URI.create(endereco + "validar/cnpj"))// sera de onde vamos buscar  e o que vamos validar 
				.header("Content-Type", "application/json") // o formato do arquivo
				.POST(HttpRequest.BodyPublishers.ofString(jsonInput))// ele vai dar a resposta enquanto for um JSON
				.build();//criar tudo requisitado
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString()); // transformar tudo e String e enviar toda a solicitação
		System.out.println("Status Code: "+ response.statusCode()); // escrever o Status para verificar o codigo se é 200 ok ou outro sera erro
		JSONObject objeto; // criar objeto JSON
		JSONParser parser = new JSONParser();// transformando parser em um JSON
		objeto = (JSONObject) parser.parse(response.body()); // vai transformar a resposta do objeto em forma de JSON 
		System.out.println("CNPJ: " + objeto.get("cnpj")); // escreve o cnpj solicitado
		System.out.println("VALIDO: " + objeto.get("valido")); // escreve se sera verdadeiro ou falso
		return objeto.get("valido").toString(); // sera o retorno da função
	
	}
	
	public static void validar_nome(String nome) throws Exception{
		HttpClient client = HttpClient.newHttpClient();// vai ser o client para fazer a requisição
		HttpRequest request = HttpRequest.newBuilder() 
				.uri(URI.create(endereco + "pokemon/nome/"+nome))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString()); 
		System.out.println("Status Code: "+ response.statusCode()); 
		JSONObject objeto; 
		JSONParser parser = new JSONParser();
		objeto = (JSONObject) parser.parse(response.body()); 
		System.out.println("NOME: " + objeto.get("nome"));
		System.out.println("ID: " + objeto.get("id"));
		JSONArray tipos= (JSONArray) objeto.get("tipos");
		for(int i = 0;i<tipos.size(); i++) {
			System.out.println("TIPOS:" + tipos.get(i));
		}
		System.out.println("_________________________________");
		System.out.println("ALTURA: " + objeto.get("altura"));
		System.out.println("PESO: " + objeto.get("peso"));
		System.out.println("HP: " + objeto.get("hp"));
		System.out.println("ATAQUE: " + objeto.get("ataque"));
		System.out.println("DEFESA: " + objeto.get("defesa"));
		System.out.println("VELOCIDADE: " + objeto.get("velocidade"));
		System.out.println("EVOLUÇÃO: " + objeto.get("evoluiPara"));
		

		
	
	}
	
	public static void cadastrar_selecao(String nome ,String grupo ,String bandeira) throws Exception{
		HttpClient client = HttpClient.newHttpClient();
		String jsonInput= """
		{
		"pais": "%s",
		"grupo": "%s",
		"bandeira": "%s"
		}
		""".formatted(nome, grupo , bandeira);
		HttpRequest request = HttpRequest.newBuilder() // vai ser a requisiçao que o client solicita
				.uri(URI.create(endereco + "copa/selecoes"))// sera de onde vamos buscar  e o que vamos validar 
				.header("Content-Type", "application/json")// o formato do arquivo
				.POST(HttpRequest.BodyPublishers.ofString(jsonInput))// ele vai dar a resposta enquanto for um JSON
				.build(); // criar requisição
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());// transformar tudo e String e enviar toda a solicitação
		System.out.println("Status Code: "+ response.statusCode());
		System.out.println(response.body());
		
	
	
	
	}
	public static JSONArray pesquisa_selecao() throws Exception{
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco+ "copa/selecoes"))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Status Code: "+ response.statusCode());
		JSONArray array;
		JSONParser parse = new JSONParser();
		array = (JSONArray) parse.parse(response.body());
		return array;
	
}
	public static JSONArray pesquisa_paises() throws Exception{

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco+ "paises"))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Status Code: "+ response.statusCode());
		JSONArray array;
		JSONParser parse = new JSONParser();
		array = (JSONArray) parse.parse(response.body());
		return array;
	
}
	public static void valida_jogo (String mandante , String visitante , String data) {
		
	}
	public static boolean selecao_igual (String mandante , String visitante) {
		if (mandante.equals(visitante))
			return true;
		return false;
	}
	public static JSONArray pesquisa_jogos() throws Exception{

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco+ "copa/jogos"))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Status Code: "+ response.statusCode());
		JSONArray array;
		JSONParser parse = new JSONParser();
		array = (JSONArray) parse.parse(response.body());
		return array;
	
	
	}
}
