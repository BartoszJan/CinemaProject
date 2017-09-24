package com.mojafirma;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;

import java.sql.Date;

public class MovieApp {

    public static void main(String[] args) {
        MovieDao movieDao = new MovieDao();
        Movie matrix = new Movie();
        matrix.setTitle("Matrix");
        matrix.setDuration(120);
        matrix.setYear(Date.valueOf("1990-01-01"));
        matrix.setDirector("Wachowsky brothers");

        movieDao.addMovie(matrix);

        HibernateUtil.getSessionFactory().close();
    }
}
