package com.mojafirma.model.dao;

import com.mojafirma.model.Movie;
import com.mojafirma.util.HibernateUtil;
import com.mojafirma.model.Showing;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShowingDao {

    public Integer addShowing(Showing showing) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer showingID = null;
        try {
            tx = session.beginTransaction();
            showingID = (Integer) session.save(showing);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return showingID;
    }

    public Showing getShowing(Integer showingId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Showing showing = null;
        try{
            tx = session.beginTransaction();
            showing = session.get(Showing.class, showingId);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return showing;
    }
}
