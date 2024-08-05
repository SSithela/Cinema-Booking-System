package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cinema;
import za.ac.cput.repository.CinemaRepository;

import java.util.List;

@Service
public class CinemaService implements ICinemaService {
    private CinemaRepository repository;
    @Autowired
    private CinemaService(CinemaRepository cinemaRepository){
        this.repository=cinemaRepository;
    }

    @Override
    public Cinema create(Cinema cinema) {
        return repository.save(cinema);
    }

    @Override
    public Cinema read(Integer integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Cinema update(Cinema cinema) {
        return this.repository.existsById(cinema.getCinemaId()) ? this.repository.save(cinema) : null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<Cinema> getAll() {
        return this.repository.findAll();
    }
}
