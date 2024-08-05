package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.MovieShow;
import za.ac.cput.service.MovieShowService;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/show")
public class MovieShowController {
    @Autowired
    private MovieShowService movieShowService;

    @PostMapping("/create")
    MovieShow create(@RequestBody MovieShow show) {
        return movieShowService.create(show);
    }

    @GetMapping("/read/{id}")
    MovieShow read(@PathVariable Integer id){
        return movieShowService.read(id);
    }

    @PostMapping("/update")
    MovieShow update(@RequestBody MovieShow show) {
        return movieShowService.create(show);
    }

    @GetMapping({"/", "/all"})
    List<MovieShow> getAll() {
        return movieShowService.getAll();
    }
}
