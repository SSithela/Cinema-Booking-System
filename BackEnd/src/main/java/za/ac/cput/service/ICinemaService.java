package za.ac.cput.service;

import za.ac.cput.domain.Cinema;

import java.util.List;

public interface ICinemaService extends IService<Cinema,Integer>{
    List<Cinema> getAll();
}
