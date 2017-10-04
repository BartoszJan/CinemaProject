package com.mojafirma.gui;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;
import com.mojafirma.util.HibernateUtil;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.ShowingDao;
import com.mojafirma.util.MovieComboBoxModel;
import com.mojafirma.util.MovieListModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddShowingPanel extends JFrame{
    private JPanel panel1;

    private JTextField headTextField;
    private JTextField textField3;
    private JTextField dateTimeInput;
    private JTextField textField2;
    private JTextField roomNumberInput;
    private JButton button1;
    private JTextField textField1;
    private JTextField movieTitleInput;
    private JComboBox chooseMovieComboBox;

    public AddShowingPanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MovieDao movieDao = new MovieDao();

        chooseMovieComboBox.setModel(new MovieComboBoxModel(movieDao.getMovieList()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LocalDateTime diteTimeShowing = LocalDateTime.parse(dateTimeInput.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                int roomNumber = Integer.parseInt(roomNumberInput.getText());

                Movie movie = (Movie) chooseMovieComboBox.getSelectedItem();
                ShowingDao showingDao = new ShowingDao();
                Showing showing = new Showing();
                showing.setMovie(movie);
                showing.setMovie_date_time(diteTimeShowing);
                showing.setRoom_number(roomNumber);
                showingDao.addShowing(showing);
                HibernateUtil.getSessionFactory().close();
            }
        });

        setSize(500, 500);
        setVisible(true);

    }

}

