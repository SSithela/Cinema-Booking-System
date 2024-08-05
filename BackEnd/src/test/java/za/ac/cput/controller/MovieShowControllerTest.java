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
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Movie;
import za.ac.cput.domain.MovieRoom;
import za.ac.cput.domain.MovieShow;
import za.ac.cput.domain.Seat;
import za.ac.cput.factory.MovieShowFactory;
import za.ac.cput.service.MovieRoomService;
import za.ac.cput.service.MovieService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieShowControllerTest {
    private static MovieShow show;
    private final String baseURL = "http://localhost:8084/show/";
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRoomService movieRoomService;
    @Value("${api.key}")
    private String apiKey;
    @Value("${api.secret}")
    private String apiSecret;
    @Test
    void create() {
        String url = baseURL + "create";
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY", apiKey);
        headers.add("X-API-SECRET", apiSecret);

        List<Movie> movieList = movieService.getAll().stream().filter(movie -> movie.isNowShowing()==true).toList();
        for (int i = 0; i < movieList.size(); i++) {
            MovieRoom movieRoom=movieRoomService.read(i+1);
//            System.out.println();
            show = MovieShowFactory.createShow(i + 1, movieList.get(i), movieRoom, Date.valueOf("2023-10-30"), "17:30");
            HttpEntity<MovieShow> entity = new HttpEntity<>(show, headers);
            ResponseEntity<MovieShow> responseEntity = restTemplate.postForEntity(url, entity, MovieShow.class);
            assertNotNull(responseEntity);
            assertNotNull(responseEntity.getBody());
            System.out.println(responseEntity.getBody());
        }

    }

    @Test
    void read() {
        String url = baseURL + "/read/" + show.getShowId();
        System.out.println("URl: " + url);
        ResponseEntity<MovieShow> response = restTemplate.getForEntity(url, MovieShow.class);
        assertEquals(show.getShowId(), response.getBody().getShowId());
        System.out.println(response.getBody());
    }

    @Test
    void update() throws IOException, InterruptedException {
//        MovieShow updatedBooking = new MovieShow.Builder().copy(show).setRoomNum(null).build();
//        String url = baseURL + "/update";
//        System.out.println("URL: " + url);
//        System.out.println("Updated Data: " + updatedBooking);
//        ResponseEntity<MovieShow> response = restTemplate.postForEntity(url, updatedBooking, MovieShow.class);
//        assertNotNull(response.getBody());
    }

    @Test
    void getAll() throws IOException, InterruptedException {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void test() {
        MovieRoom show1 = movieRoomService.read(1);
        List<Seat> seatList1 = show1.getSeats();
        System.out.println(show1);
//        System.out.println(movieService.getAll());
    }
}