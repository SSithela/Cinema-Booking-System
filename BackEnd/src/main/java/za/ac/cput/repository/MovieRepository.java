package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
}
