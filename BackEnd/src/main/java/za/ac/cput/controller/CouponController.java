/*
 * CouponController.java
 * Controller for coupon entity
 * Author: Sinethemba Sithela (219112940)
 * Date: 26/08/2023
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Coupon;
import za.ac.cput.service.CouponService;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService service;

    @PostMapping("/create")
    Coupon create(@RequestBody Coupon coupon){
        return service.create(coupon);
    }

    @GetMapping({"/", "/all"})
    List<Coupon> getAll(){
        return service.getAll();
    }
}
