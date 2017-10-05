package com.mojafirma.gui;

import com.mojafirma.model.Movie;
import com.mojafirma.util.HibernateUtil;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.ShowingDao;
import com.mojafirma.util.MovieComboBoxModel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AddShowingPanel extends JFrame {
    private JPanel panel1;

    private JTextField headTextField;
    private JTextField textField3;
    private JTextField dateTimeInput;
    private JTextField textField2;
    private JTextField roomNumberInput;
    private JButton button1;
    private JTextField textField1;
    private JComboBox chooseMovieComboBox;

    public void setMovieList(List<Movie> movies) {
        chooseMovieComboBox.setModel(new MovieComboBoxModel(movies));
    }

    public void iniAddShowingPanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chooseMovieComboBox.setRenderer(new BasicComboBoxRenderer(){
            public Component getListCellRendererComponent(JList list, Object value, int index,              boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null){
                    Movie movie = (Movie) value;
                    setText(movie.getTitle());
                }
                return this;
            }
        });

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

