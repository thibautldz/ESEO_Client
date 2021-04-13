package com.javaBeansUtils;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.javaBeans.Ville;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class RestClient {

	public static List<Ville> getListeVille() throws JsonParseException, JsonProcessingException, IOException {

		Client client = Client.create();
		URI uri = UriBuilder.fromUri("http://localhost:8181/").build();
		ClientResponse responseclient = client.resource(uri).path("villes").get(ClientResponse.class);
		String CorpsRepHttp = responseclient.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<Ville> listevilles = mapper.readValue(CorpsRepHttp, new TypeReference<List<Ville>>() {
		});
		return listevilles;
	}
	
	public static List<Ville> getVillebyCodeInsee(String codeInsee) throws JsonParseException, JsonProcessingException, IOException {

		Client client = Client.create();
		URI uri = UriBuilder.fromUri("http://localhost:8181/").build();
		ClientResponse responseclient = client.resource(uri).path("ville").queryParam("codeInsee",codeInsee).get(ClientResponse.class);
		String CorpsRepHttp = responseclient.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<Ville> listevilles = mapper.readValue(CorpsRepHttp, new TypeReference<List<Ville>>() {
		});
		return listevilles;
	}

	public static void PutVille(Ville ville, String codeInsee) throws JsonParseException, JsonProcessingException, IOException {

		Client client = Client.create();
		URI uri = UriBuilder.fromUri("http://localhost:8181/").build();
		ObjectMapper mapper = new ObjectMapper();
		ClientResponse responseclient = client.resource(uri).path("ville")
				.path(codeInsee)
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,mapper.writeValueAsString(ville));
		String CorpsRepHttp = responseclient.getEntity(String.class);

	}

	public static void DeleteVille(String codeInsee) throws JsonParseException, JsonProcessingException, IOException {

		Client client = Client.create();
		URI uri = UriBuilder.fromUri("http://localhost:8181/").build();
		ClientResponse responseclient = client.resource(uri).path("ville").path(codeInsee).delete(ClientResponse.class);
		String CorpsRepHttp = responseclient.getEntity(String.class);

		System.out.println(CorpsRepHttp);
	}
}
