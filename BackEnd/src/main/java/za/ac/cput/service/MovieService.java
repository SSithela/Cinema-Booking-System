package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Movie;
import za.ac.cput.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    private MovieRepository repository;

    @Autowired
    private MovieService(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Movie create(Movie movie) {
        return this.repository.save(movie);
    }

    @Override
    public Movie read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Movie update(Movie movie) {
        return this.repository.existsById(movie.getMovie_id()) ? this.repository.save(movie) : null;
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }
}
