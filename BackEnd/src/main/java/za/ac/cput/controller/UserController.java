
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Movie;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    User create(@RequestBody User user){
        System.out.println("Hekskskj");
        return service.create(user);
    }
    @PostMapping("/update-user")
    User update(@RequestBody User user){
//        System.out.println("Hekskskj");
        System.out.println(user.getUserId());
        return service.update(user);
    }
    @GetMapping("/{email}")
    User read(@PathVariable String email){
        System.out.println(email);
//        for (User user:service.getAll()){
//            if(user.getEmail()==email)
//        }
        return service.getByEmail(email);
    }
    @GetMapping({"/", "/all"})
    List<User> getAll(){
        return service.getAll();
    }
}
