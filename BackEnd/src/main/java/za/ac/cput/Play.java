package za.ac.cput;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.service.MovieService;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class Play {

    public static void main(String[] args) {

//        LocalDateTime dateTime=LocalDateTime.of(2023,10);
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.themoviedb.org/3/genre/movie/list?language=en"))
//                .header("accept", "application/json")
//                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzODVmMWU4NTUxOGM2NDRkYTJjOWUzOWY3ZWZkNGQxNyIsInN1YiI6IjYwYmMyZWI1Y2E0ZjY3MDA1OWUyMzBkNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pwdrejarorYnUj1DOhlfP_Q4GYKqGP6W41SR31UT0iI")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        try {
//            JsonNode rootNode = objectMapper.readTree(response.body());
//            JsonNode dataArray = rootNode.get("genres");
//            for (JsonNode objectNode : dataArray) {
//                int id = objectNode.get("id").asInt();
//                String name = objectNode.get("name").asText("null");
//                System.out.println("Object ID: " + id + ", Name: " + name);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
