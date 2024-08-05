package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.MovieRoom;
import za.ac.cput.service.MovieRoomService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rooms")
public class MovieRoomController {
    @Autowired
    private MovieRoomService service;

    @PostMapping("/create")
    MovieRoom create(@RequestBody MovieRoom movieRoom) {
        return service.create(movieRoom);
    }

    @PostMapping("/update")
    MovieRoom update(@RequestBody MovieRoom movieRoom) {
        return service.update(movieRoom);
    }

    @GetMapping("/{id}")
    MovieRoom read(@PathVariable Integer id) {
        return service.read(id);
    }

}
