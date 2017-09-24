package com.mojafirma.model.dao;

import com.mojafirma.HibernateUtil;
import com.mojafirma.model.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDao {

    public Integer addMovie(Movie movie) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer movieID = null;
        try {
            tx = session.beginTransaction();
            movieID = (Integer) session.save(movie);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return movieID;
    }
}
