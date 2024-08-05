package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Seat;
import za.ac.cput.repository.SeatRepository;

import java.util.List;

@Service
public class SeatService implements ISeatService {
 private SeatRepository repository;

 @Autowired
    private SeatService(SeatRepository seatRepository){
     this.repository=seatRepository;
 }

    @Override
    public Seat create(Seat seat) {
        return repository.save(seat);
    }

    @Override
    public Seat read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Seat update(Seat seat) {
        return this.repository.existsById(seat.getSeatId()) ? this.repository.save(seat) : null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<Seat> getAll() {
        return repository.findAll();
    }
}
