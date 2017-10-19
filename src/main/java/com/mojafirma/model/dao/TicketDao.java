package com.mojafirma.model.dao;

import com.mojafirma.model.Ticket;
import com.mojafirma.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketDao {

    public Integer addTicket(Ticket ticket) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer ticketID = null;
        try {
            tx = session.beginTransaction();
            ticketID = (Integer) session.save(ticket);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ticketID;
    }
}
