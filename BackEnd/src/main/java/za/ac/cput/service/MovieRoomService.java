package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.MovieRoom;
import za.ac.cput.repository.MovieRoomRepository;

@Service
public class MovieRoomService implements IMovieRoomService{
    private MovieRoomRepository repository;

    @Autowired
    private MovieRoomService(MovieRoomRepository movieRoomRepository){
        this.repository=movieRoomRepository;
    }

    @Override
    public MovieRoom create(MovieRoom movieRoom) {
        return repository.save(movieRoom);
    }

    @Override
    public MovieRoom read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public MovieRoom update(MovieRoom movieRoom) {
        return this.repository.existsById(movieRoom.getRoom_id()) ? this.repository.save(movieRoom) : null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
