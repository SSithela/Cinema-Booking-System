package za.ac.cput.controller;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;


import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookingControllerTest {
    static Date date = new Date(2023,10,12);
    private static Booking booking = BookingFactory.createBooking(date,null,null);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8084/booking/";
    @Test
    void create() throws IOException, InterruptedException{
        String url = baseURL + "/create";
        ResponseEntity<Booking> postResponse = restTemplate.postForEntity(url,booking,Booking.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Booking savedBooking = postResponse.getBody();
        System.out.println("Saved Data: " + savedBooking);
        assertEquals(booking.getBookingId(),savedBooking.getBookingId());
    }

    @Test
    void read(){
        String url = baseURL + "/read/" + booking.getBookingId();
        System.out.println("URl: " + url);
        ResponseEntity<Booking> response = restTemplate.getForEntity(url,Booking.class);
        assertEquals(booking.getBookingId(),response.getBody().getBookingId());
        System.out.println(response.getBody());
    }
    @Test
    void update() throws IOException, InterruptedException{
        Booking updatedBooking = new Booking.Builder().copy(booking).setSeats(null).build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + updatedBooking);
        ResponseEntity<Booking> response = restTemplate.postForEntity(url,updatedBooking, Booking.class);
        assertNotNull(response.getBody());
    }

    @Test
    void getAll() throws IOException, InterruptedException{
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}