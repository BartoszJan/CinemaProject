package com.mojafirma.util;

import com.mojafirma.model.Showing;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class ShowingListModel extends AbstractListModel<Showing> {

    private List<Showing> showings;

    public ShowingListModel(List<Showing> showings) {
        this.showings = showings;
    }

    @Override
    public int getSize() {
        return showings.size();
    }

    @Override
    public Showing getElementAt(int index) {
        return showings.stream().sorted((e1, e2) -> e1.getShowing_date_time().compareTo(e2.getShowing_date_time()))
                .collect(Collectors.toList()).get(index);
    }


}
