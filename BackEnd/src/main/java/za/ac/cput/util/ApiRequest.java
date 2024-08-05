package za.ac.cput.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import za.ac.cput.domain.Genre;
import za.ac.cput.domain.Movie;
import za.ac.cput.factory.GenreFactory;
import za.ac.cput.factory.MovieFactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiRequest {

    static String makeCall(String str) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/" + str + "?language=en"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzODVmMWU4NTUxOGM2NDRkYTJjOWUzOWY3ZWZkNGQxNyIsInN1YiI6IjYwYmMyZWI1Y2E0ZjY3MDA1OWUyMzBkNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pwdrejarorYnUj1DOhlfP_Q4GYKqGP6W41SR31UT0iI")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static List<Genre> genreList() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = makeCall("genre/movie/list");
        List<Genre> list = new ArrayList<>();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonStr);
            JsonNode dataArray = rootNode.get("genres");
            for (JsonNode objectNode : dataArray) {
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
        String jsonStr = makeCall("movie/now_playing");
        ObjectMapper objectMapper2 = new ObjectMapper();
        String jsonStr2 = makeCall("movie/upcoming");
        List<Movie> list = new ArrayList<>();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonStr);
            JsonNode dataArray = rootNode.get("results");
            for (JsonNode objectNode : dataArray) {
                String id = objectNode.get("id").asText();
                String name = objectNode.get("original_title").asText();
                String overview = objectNode.get("overview").asText();
                String poster_path = objectNode.get("poster_path").asText();
                String backdrop_path = objectNode.get("backdrop_path").asText();
                String releaseDate = objectNode.get("release_date").asText();
                double ratting = objectNode.get("vote_average").asDouble();
                JsonNode gArray = objectNode.get("genre_ids");
                System.out.println("ID: " + id + " Name: " + name);
                ArrayList<Genre> glist = new ArrayList<>();
                for (JsonNode x : gArray) {
                    for (Genre y : genreList()) {
                        if (y.getId() == x.asInt()) {
                            glist.add(y);
                            break;
                        }
                    }
                }
                list.add(MovieFactory.createMovie(id, name, overview, poster_path, backdrop_path, releaseDate, ratting, glist,true));
            }
            JsonNode rootNode1 = objectMapper.readTree(jsonStr2);
            JsonNode dataArray1 = rootNode1.get("results");
            for (JsonNode objectNode : dataArray1) {
                String id = objectNode.get("id").asText();
                String name = objectNode.get("original_title").asText();
                String overview = objectNode.get("overview").asText();
                String poster_path = objectNode.get("poster_path").asText();
                String backdrop_path = objectNode.get("backdrop_path").asText();
                String releaseDate = objectNode.get("release_date").asText();
                double ratting = objectNode.get("vote_average").asDouble();
                JsonNode gArray = objectNode.get("genre_ids");
                System.out.println("ID: " + id + " Name: " + name);
                ArrayList<Genre> glist = new ArrayList<>();
                for (JsonNode x : gArray) {
                    for (Genre y : genreList()) {
                        if (y.getId() == x.asInt()) {
                            glist.add(y);
                            break;
                        }
                    }
                }
                list.add(MovieFactory.createMovie(id, name, overview, poster_path, backdrop_path, releaseDate, ratting, glist,false));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
