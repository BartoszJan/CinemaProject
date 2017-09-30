package com.mojafirma.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "showing")
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showing_id;

    @Column(name = "movie_title")
    private String movie_title;

    @Column(name = "movie_date_time")
    private LocalDateTime movie_date_time;

    @Column(name = "room_number")
    private int room_number;

    public int getShowing_id() {
        return showing_id;
    }

    public void setShowing_id(int showing_id) {
        this.showing_id = showing_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public LocalDateTime getMovie_date_time() {
        return movie_date_time;
    }

    public void setMovie_date_time(LocalDateTime movie_date_time) {
        this.movie_date_time = movie_date_time;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "showing_id='" + showing_id + '\'' +
                ", movie_title='" + movie_title + '\'' +
                ", movie_date_time=" + movie_date_time +
                ", room_number=" + room_number +
                '}';
    }
}
