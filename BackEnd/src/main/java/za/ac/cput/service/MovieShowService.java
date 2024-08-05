package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.MovieShow;
import za.ac.cput.repository.MovieShowRepository;
import java.util.List;
@Service
public class MovieShowService implements IShowService {
    private MovieShowRepository repository;

    @Autowired
    private MovieShowService(MovieShowRepository movieShowRepository) {
        this.repository = movieShowRepository;
    }

    @Override
    public MovieShow create(MovieShow show) {
        return this.repository.save(show);
    }

    @Override
    public MovieShow read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public MovieShow update(MovieShow show) {
        return this.repository.existsById(show.getShowId()) ? this.repository.save(show) : null;
    }

    @Override
    public boolean delete(Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<MovieShow> getAll() {
        return this.repository.findAll();
    }

}
