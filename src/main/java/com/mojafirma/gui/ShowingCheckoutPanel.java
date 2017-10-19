package com.mojafirma.gui;

import com.mojafirma.model.Movie;
import com.mojafirma.presenter.view.MovieView;
import com.mojafirma.util.MovieListModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class ShowingCheckoutPanel extends JFrame {
    private JPanel panel1;
    private JList movieJList;
    private JTextArea showingsTextArea;
    private JTextField textField3;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField4;
    private JTextField year;
    private JTextField textField6;
    private JTextField duration;
    private JTextField textField7;
    private JTextField director;

    public ShowingCheckoutPanel() { iniShowingCheckoutPanel(); }

    MovieView movieView = new MovieView();

    private void iniShowingCheckoutPanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        movieJList.setModel(new MovieListModel(movieView.showMovieList()));
        movieJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        movieJList.setCellRenderer(new ListCellRenderer<Movie>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Movie> list, Movie value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel listItem = new JLabel(value.getTitle());
                listItem.setOpaque(true);
                if (isSelected)

                {
                    listItem.setBackground(list.getSelectionBackground());
                    listItem.setForeground(list.getSelectionForeground());
                }
                else
                {
                    listItem.setBackground(list.getBackground());
                    listItem.setForeground(list.getForeground());
                }
                listItem.setFont(list.getFont());
                listItem.setEnabled(list.isEnabled());
                listItem.setMinimumSize(new Dimension(100, 20));
                return listItem;
            }
        });

        movieJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList<Movie> movieList = (JList<Movie>) e.getSource();
                Movie selectedMovie = movieList.getSelectedValue();

                year.setText(selectedMovie.getYear().toString());
                duration.setText("" + selectedMovie.getDuration());
                director.setText(selectedMovie.getDirector());
                showingsTextArea.setText("");
                for (int i = 0; i < selectedMovie.getShowings().size(); i++) {
                    showingsTextArea.append((i + 1) + ") " + selectedMovie.getShowings().get(i).getMovie_date_time().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")).toString()
                            + " // Sala numer: " + selectedMovie.getShowings().get(i).getRoom_number() + "\n\n");
                }
            }
        });
        setLocation(100, 100);
        setSize(800, 600);
        setVisible(true);
    }
}
