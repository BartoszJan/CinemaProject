package com.mojafirma;

import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.ShowingDao;

import java.time.LocalDateTime;

public class ShowingApp {

    public static void main(String[] args) {

        ShowingDao showingDao = new ShowingDao();
        Showing matrixShowing = new Showing();
        matrixShowing.setMovie_title("Matrix");
        matrixShowing.setMovie_date_time(LocalDateTime.of(2017, 10, 15, 20, 15));

        showingDao.addShowing(matrixShowing);
        HibernateUtil.getSessionFactory().close();
    }
}
