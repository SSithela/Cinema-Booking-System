package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cinema;
import za.ac.cput.service.CinemaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService service;

    @PostMapping("/create")
    Cinema create(@RequestBody Cinema cinema) {
        return service.create(cinema);
    }

    @GetMapping("/{id}")
    Cinema read(@PathVariable Integer id) {
        System.out.println(23355);
        return service.read(id);
    }
    @GetMapping("/all")
    List<Cinema> getAll() {
        return service.getAll();
    }

    @PostMapping("/update")
    Cinema update(@RequestBody Cinema cinema) {
        return service.create(cinema);
    }


}
