package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.repository.BookingRepository;
import java.util.List;
@Service
public class BookingService implements IBookingService {
    private BookingRepository repository;

    @Autowired
    private BookingService(BookingRepository bookingRepository) {
        this.repository = bookingRepository;
    }
    @Override
    public Booking create(Booking booking) {
        return this.repository.save(booking);
    }

    @Override
    public Booking read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        return this.repository.existsById(booking.getBookingId()) ? this.repository.save(booking) : null;
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
    public List<Booking> getAll() {
        return this.repository.findAll();
    }

}
