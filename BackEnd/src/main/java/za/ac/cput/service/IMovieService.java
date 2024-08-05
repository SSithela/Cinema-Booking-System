package za.ac.cput.service;

import za.ac.cput.domain.Movie;

import java.util.List;

public interface IMovieService extends IService<Movie,String>{
    public List<Movie> getAll();
}
