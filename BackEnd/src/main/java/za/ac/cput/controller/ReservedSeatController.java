package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ReservedSeat;
import za.ac.cput.domain.ReservedSeatId;
import za.ac.cput.service.ReservedSeatService;

@RestController
@RequestMapping("/reserved-seats")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservedSeatController {
    @Autowired
    private ReservedSeatService service;

    @PostMapping("/create")
    ReservedSeat create(@RequestBody ReservedSeat reservedSeat) {
        System.out.println(reservedSeat);
        return service.create(reservedSeat);
    }

    @PostMapping("/")
    boolean read(@RequestBody ReservedSeat reservedSeatId) {
        System.out.println(reservedSeatId);
        return service.read(reservedSeatId.getReservedSeatId()) != null;
    }
}
