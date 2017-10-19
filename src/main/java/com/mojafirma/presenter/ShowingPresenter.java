package com.mojafirma.presenter;

import com.mojafirma.model.Showing;

public interface ShowingPresenter {

    Showing getShowing(Integer showingId);
    void addShowing();
}
