package com.mojafirma.presenter;

import com.mojafirma.model.dao.ShowingDao;
import com.mojafirma.presenter.view.ShowingView;

public class ShowingPresenter {
    private ShowingDao showingDao = new ShowingDao();
    ShowingView showingView = new ShowingView();

    public ShowingPresenter(ShowingView showingView) {
        this.showingView = showingView;
    }

    public void addShowing() {
        showingDao.addShowing(showingView.getAddingShowing());
    }
}
