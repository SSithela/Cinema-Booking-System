package za.ac.cput.service;
import za.ac.cput.domain.MovieShow;
import java.util.List;

public interface IShowService extends IService<MovieShow,Integer>{
    public List<MovieShow> getAll();
}
