package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
}
