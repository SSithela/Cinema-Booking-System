package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Genre;
import za.ac.cput.repository.GenreRepository;

import java.util.List;
@Service
public class GenreService implements IGenreService{
    private GenreRepository repository;
    @Autowired
    private GenreService(GenreRepository genreRepository){
        this.repository=genreRepository;
    }
    @Override
    public List<Genre> getAll() {
        return this.repository.findAll();
    }

    public Genre create(Genre genre){
        return this.repository.save(genre);
    }
}
