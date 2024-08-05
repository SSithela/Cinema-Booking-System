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
import za.ac.cput.factory.SeatFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SeatControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private Cinema cinema= CinemaFactory.createCinema(123,null);
    private MovieRoom movieRoom= MovieRoomFactory.createRoom(1,7,true,null);
    private Seat seat= SeatFactory.createSeat(1,250,false);
    private final String baseUrl = "http://localhost:8084/seat/";
    @Test
    void create() {
        String url = baseUrl + "create";
        ResponseEntity<Seat> responseEntity = testRestTemplate.postForEntity(url, seat, Seat.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void read() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }
}