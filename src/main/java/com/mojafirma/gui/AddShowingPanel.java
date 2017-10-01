package com.mojafirma.gui;

import com.mojafirma.HibernateUtil;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.ShowingDao;

import javax.swing.*;
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

    public AddShowingPanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));

        panel1.add(headTextField);
        panel1.add(textField1);
        panel1.add(movieTitleInput);
        panel1.add(textField2);
        panel1.add(dateTimeInput);
        panel1.add(textField3);
        panel1.add(roomNumberInput);
        panel1.add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String movietitle = movieTitleInput.getText();
                LocalDateTime diteTimeShowing = LocalDateTime.parse(dateTimeInput.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                int roomNumber = Integer.parseInt(roomNumberInput.getText());

                ShowingDao showingDao = new ShowingDao();
                Showing showing = new Showing();
                showing.setMovie_title(movietitle);
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

