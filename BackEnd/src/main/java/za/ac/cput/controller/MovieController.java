package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Movie;
import za.ac.cput.service.MovieService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService service;

    @PostMapping("/create")
    Movie create(@RequestBody Movie movie) {
        return service.create(movie);
    }

    @GetMapping({"/", "/all"})
    List<Movie> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    Movie read(@PathVariable String id){
        System.out.println(service.read(id));
        return service.read(id);
    }


}
