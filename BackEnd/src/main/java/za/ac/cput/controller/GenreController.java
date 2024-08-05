package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Genre;
import za.ac.cput.service.GenreService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService service;

    @PostMapping("/create")
    Genre create(@RequestBody Genre genre) {
        return service.create(genre);
    }



    @GetMapping({"/", "/all"})
    List<Genre> getAll(){
        return service.getAll();
    }
}
