package consumo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;



public class consumo {
			static String endereco = "http://192.168.0.225:3000/";//endereço da api
		public static void main (String [] args) throws Exception{
			
		}

//função para fazer o cadastro dos filmes na api onde criamos o arquivo em formtato Json com as informções dentro do array 
public static void cadastrar_filmes(String titulo ,String lancamento ,String genero) throws Exception{
	HttpClient client = HttpClient.newHttpClient();
	String jsonInput= """
	{
	"titulo": "%s",
	"lancamento": "%s",
	"genero": "%s"
	}
	""".formatted(titulo, lancamento , genero);
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(endereco + "api/filmes"))
			.header("Content-Type", "application/json")
			.POST(HttpRequest.BodyPublishers.ofString(jsonInput))
			.build(); 
	HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
	System.out.println("Status Code: "+ response.statusCode());
	System.out.println(response.body());
	



}
//função para buscar na api os filmes ja cadastrado , onde pegamos as informações no endereço e pesquisamos na tela de buscar pelo objeto do array "titulo"
		
		public static JSONArray pesquisa_filme() throws Exception {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(endereco + "api/filmes"))
					.GET()
					.build();
			HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
			System.out.println("Status Code: "+ response.statusCode());
			JSONArray objeto;
			JSONParser parser = new JSONParser();
			objeto = (JSONArray) parser.parse(response.body());
			return objeto;
	
			
			}

	
		

		//public static JSONArray pesquisa_filme() {
			// TODO Auto-generated method stub
			//return null;
		}


