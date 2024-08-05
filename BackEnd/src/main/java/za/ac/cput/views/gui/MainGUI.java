package za.ac.cput.views.gui;

import za.ac.cput.dao.Operations;
import za.ac.cput.domain.Movie;
import za.ac.cput.domain.MovieRoom;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainGUI extends JFrame implements ActionListener {
    private JComboBox<String> movieJComboBox;
    private JComboBox<String> roomJComboBox;
    private JTextField date;
    private JTextField time;

    public MainGUI(){

        List<Movie> movies;
        try {
            movies=Operations.movieList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String[] options2=new String[movies.size()];
        for (int i=0;i<movies.size();i++){
            options2[i]=movies.get(i).getTitle();
        }
        String[] js=options2;
        roomJComboBox=new JComboBox<>(js);
        movieJComboBox=new JComboBox<>(options2);
        date=new JTextField(9);
        time=new JTextField(3);
    }
    public void setGUI(){
        this.setLayout(new FlowLayout());
        this.add(movieJComboBox);
        this.add(roomJComboBox);
        this.add(date);
        this.add(time);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600,499);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
