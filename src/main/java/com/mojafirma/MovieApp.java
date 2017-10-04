package com.mojafirma;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;
import com.mojafirma.util.HibernateUtil;

import java.time.LocalDate;

public class MovieApp {

    public static void main(String[] args) {

        MovieDao movieDao = new MovieDao();

        Movie matrix = new Movie();
        matrix.setTitle("Matrix");
        matrix.setDuration(120);
        matrix.setYear(LocalDate.of(1990, 01, 01));
        matrix.setDirector("Wachowsky brothers");

        movieDao.addMovie(matrix);

        HibernateUtil.getSessionFactory().close();
    }
}
