package za.ac.cput.service;

import za.ac.cput.domain.Seat;

import java.util.List;

public interface ISeatService extends IService<Seat,Integer>{
    List<Seat> getAll();
}
