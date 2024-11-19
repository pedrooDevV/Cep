package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.LocalDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CepService {
    LocalDTO localDTO = new LocalDTO();

    public LocalDTO getCep(String local) throws IOException, InterruptedException {

        final String ENDERECE = "http://viacep.com.br/ws/";
        final String ENDERECETWO = "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDERECE + local + ENDERECETWO))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            localDTO = mapper.readValue(response.body(), LocalDTO.class);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return localDTO;
    }
}