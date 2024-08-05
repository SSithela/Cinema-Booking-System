package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ReservedSeat;
import za.ac.cput.domain.ReservedSeatId;

@Repository
public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, ReservedSeatId> {

}
