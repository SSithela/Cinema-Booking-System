package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Integer> {
}
