package za.ac.cput.factory;

import za.ac.cput.domain.Genre;
import za.ac.cput.util.Helper;

public class GenreFactory {
    public static Genre createGenre(int id, String name) {
        if (Helper.isNullOrEmpty(name)) {
            return null;
        }

        return new Genre(id, name);
    }
}
