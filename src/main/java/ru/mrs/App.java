package ru.mrs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class App{
	
	private static final String HOST = "http://localhost:8080";
	private static final String RES = "api/0.0.1/res";
	private static final String POSTS_API_URL = HOST + "/" + RES;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("hello to : " + POSTS_API_URL);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(POSTS_API_URL))
				.build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (java.net.ConnectException e) {
			System.out.println(e.getMessage());
		}
		if (response != null) {
			// System.out.println(response.body().toString());
			ObjectMapper mapper = new ObjectMapper();
			List<Post> posts = mapper.readValue(response.body(), new TypeReference<List<Post>>() {});
			posts.forEach(System.out::println);
		}
	}
}