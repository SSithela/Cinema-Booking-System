package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Cinema;
import za.ac.cput.domain.Movie;
import za.ac.cput.util.ApiRequest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Value("${api.key}")
    private String apiKey;
    @Value("${api.secret}")
    private String apiSecret;
    private final String baseUrl = "http://localhost:8084/movie/";

    @Test
    void a_create() throws IOException, InterruptedException {
        List<Movie> list = ApiRequest.movieList();
        for (int i = 0; i < list.size(); i++) {
            String url = baseUrl + "create";
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-API-KEY", apiKey);
            headers.add("X-API-SECRET", apiSecret);
            HttpEntity<Movie> entity = new HttpEntity<>(list.get(i), headers);
            ResponseEntity<Movie> responseEntity = testRestTemplate.postForEntity(url, entity, Movie.class);
            assertNotNull(responseEntity);
            assertNotNull(responseEntity.getBody());
            System.out.println(list.get(i));
        }
    }

    @Test
    void read() {
        String url = baseUrl + "615656";
        ResponseEntity<Movie> responseEntity = testRestTemplate.getForEntity(url, Movie.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println(responseEntity.getBody());
    }
}