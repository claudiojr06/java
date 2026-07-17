package tela;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class codigo {
	static String endereco = "http://192.168.0.225:3000/";
	public static void main (String [] args) throws Exception{
		
		
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
		HttpRequest request = HttpRequest.newBuilder() 
				.uri(URI.create(endereco + "copa/selecoes"))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(jsonInput))
				.build(); 
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
		System.out.println("Status Code: "+ response.statusCode());
		System.out.println(response.body());

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
	
	}
