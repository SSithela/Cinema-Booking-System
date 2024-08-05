package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ReservedSeat;
import za.ac.cput.domain.ReservedSeatId;
import za.ac.cput.repository.ReservedSeatRepository;

@Service
public class ReservedSeatService implements IReservedSeatService {
    private ReservedSeatRepository repository;

    @Autowired
    private ReservedSeatService(ReservedSeatRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReservedSeat create(ReservedSeat reservedSeat) {
        return this.repository.save(reservedSeat);
    }

    @Override
    public ReservedSeat read(ReservedSeatId reservedSeatId) {
        return this.repository.findById(reservedSeatId).orElse(null);
    }

    @Override
    public ReservedSeat update(ReservedSeat reservedSeat) {
        return null;
    }

    @Override
    public boolean delete(ReservedSeatId reservedSeatId) {
        return false;
    }
}
