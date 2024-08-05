package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;


import java.util.List;
@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    Booking create(@RequestBody Booking booking) {

        System.out.println(booking);
        return bookingService.create(booking);
    }
    @GetMapping("/read/{id}")
    Booking read(@PathVariable Integer id){
        return bookingService.read(id);
    }
    @PostMapping("/update")
    Booking update(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @GetMapping({"/", "/all"})
    List<Booking> getAll() {
        return bookingService.getAll();
    }
}
