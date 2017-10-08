package com.mojafirma.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "showing")
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showing_id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable=false)
    private Movie movie;

    @Column(name = "movie_date_time")
    private LocalDateTime movie_date_time;

    @Column(name = "room_number")
    private int room_number;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            mappedBy = "showing", orphanRemoval = true)
    @Column(name = "TICKET", nullable = false)
    private List<Ticket> tickets;

    public int getShowing_id() {
        return showing_id;
    }

    public void setShowing_id(int showing_id) {
        this.showing_id = showing_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "showing_id=" + showing_id +
                ", movie=" + movie +
                ", movie_date_time=" + movie_date_time +
                ", room_number=" + room_number +
                '}';
    }
}
