package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
}
