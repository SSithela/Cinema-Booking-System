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
import za.ac.cput.domain.Genre;
import za.ac.cput.factory.GenreFactory;
import za.ac.cput.util.ApiRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GenreControllerTest {
//    Genre g=GenreFactory.
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Value("${api.key}")
    private String apiKey;
    @Value("${api.secret}")
    private String apiSecret;
    private final String baseUrl = "http://localhost:8084/genre/";

    @Test
    void a_create() throws IOException, InterruptedException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY", apiKey);
        headers.add("X-API-SECRET", apiSecret);
        List<Genre> list= ApiRequest.genreList();
        for(int i=0;i<list.size();i++){
            String url = baseUrl + "create";
            HttpEntity<Genre> entity = new HttpEntity<>(list.get(i), headers);
            ResponseEntity<Genre> responseEntity = testRestTemplate.postForEntity(url, entity, Genre.class);
            assertNotNull(responseEntity);
            assertNotNull(responseEntity.getBody());
        }
    }
}