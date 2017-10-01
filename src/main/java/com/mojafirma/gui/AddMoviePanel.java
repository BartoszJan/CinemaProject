package com.mojafirma.gui;

import com.mojafirma.HibernateUtil;
import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddMoviePanel extends JFrame{

    private JPanel panel1;
    private JTextField headTextField;
    private JTextField textField1;
    private JTextField movieTitleInput;
    private JTextField textField3;
    private JTextField yearInput;
    private JTextField textField5;
    private JTextField durationInput;
    private JTextField textField7;
    private JTextField directorInput;
    private JButton button1;

    public AddMoviePanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        panel1.add(headTextField);
        panel1.add(textField1);
        panel1.add(movieTitleInput);
        panel1.add(textField3);
        panel1.add(yearInput);
        panel1.add(textField5);
        panel1.add(durationInput);
        panel1.add(textField7);
        panel1.add(directorInput);
        panel1.add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String movietitle = movieTitleInput.getText();
                LocalDate yearMovie = LocalDate.parse(yearInput.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int duration = Integer.parseInt(durationInput.getText());
                String director = directorInput.getText();

                MovieDao movieDao = new MovieDao();
                Movie movie = new Movie();
                movie.setTitle(movietitle);
                movie.setYear(yearMovie);
                movie.setDuration(duration);
                movie.setDirector(director);
                movieDao.addMovie(movie);
                HibernateUtil.getSessionFactory().close();
            }
        });

        setSize(500, 500);
        setVisible(true);
    }
}
