package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Cinema;
import za.ac.cput.domain.MovieRoom;
import za.ac.cput.domain.Seat;
import za.ac.cput.factory.CinemaFactory;
import za.ac.cput.factory.MovieRoomFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieRoomControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private List<MovieRoom> movieRooms=new ArrayList<>();
    private Cinema cinema= CinemaFactory.createCinema(123,movieRooms);
    private List<Seat> seats=new ArrayList<>();
    private MovieRoom movieRoom= MovieRoomFactory.createRoom(1,true,seats);

    private final String baseUrl = "http://localhost:8084/rooms/";
    @Test
    void create() {
        String url = baseUrl + "create";
        ResponseEntity<MovieRoom> responseEntity = testRestTemplate.postForEntity(url, movieRoom, MovieRoom.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void update() {
    }

    @Test
    void read() {
    }
}