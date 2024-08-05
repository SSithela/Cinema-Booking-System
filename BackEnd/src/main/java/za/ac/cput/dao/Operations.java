package za.ac.cput.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import za.ac.cput.domain.Genre;
import za.ac.cput.domain.Movie;
import za.ac.cput.factory.GenreFactory;
import za.ac.cput.factory.MovieFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Operations {
    static String makeCall(String str) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8084/"+str))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static List<Genre> genreList() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = makeCall("genre/");
        List<Genre> list = new ArrayList<>();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonStr);
//            JsonNode dataArray = rootNode.get("genres");
            for (JsonNode objectNode : rootNode) {
                int id = objectNode.get("id").asInt();
                String name = objectNode.get("name").asText();
                list.add(GenreFactory.createGenre(id, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Movie> movieList() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = makeCall("movie/");
        List<Movie> list = new ArrayList<>();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonStr);
            for (JsonNode objectNode : rootNode) {
                String id = objectNode.get("movie_id").asText();
                String name = objectNode.get("title").asText();
                String overview = objectNode.get("overview").asText();
                String poster_path = objectNode.get("posterImg").asText();
                String backdrop_path = objectNode.get("backdropImg").asText();
                String releaseDate=objectNode.get("releaseDate").asText();
                double ratting=objectNode.get("ratting").asDouble();
                JsonNode gArray = objectNode.get("genres");
                System.out.println(gArray);
                ArrayList<Genre> glist = new ArrayList<>();
                for (JsonNode x : gArray) {
                    for (Genre y : genreList()) {
                        if (y.getId() == x.asInt()) {
                            glist.add(y);
                            break;
                        }
                    }
                }
                list.add(MovieFactory.createMovie(id, name, overview, poster_path, backdrop_path,releaseDate, ratting,glist,true));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
