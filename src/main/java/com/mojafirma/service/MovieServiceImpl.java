package com.mojafirma.service;

import com.mojafirma.model.Movie;
import com.mojafirma.interfaces.MovieService;
import com.mojafirma.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> showMovieList() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Movie getMovie(int id) {
        return movieRepository.findOne(id);
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}


