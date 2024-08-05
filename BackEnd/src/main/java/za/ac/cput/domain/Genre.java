package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Genre {
    @Id
    private int id;
    private String name;

    public Genre(int id,String name){
        this.id=id;
        this.name=name;
    }

    public Genre() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
