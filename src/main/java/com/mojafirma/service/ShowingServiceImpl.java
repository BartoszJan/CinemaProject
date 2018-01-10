package com.mojafirma.service;

import com.mojafirma.model.Showing;
import com.mojafirma.interfaces.ShowingService;
import com.mojafirma.repository.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingServiceImpl implements ShowingService {

    @Autowired
    private ShowingRepository showingRepository;

    @Override
    public Showing getShowing(Integer showingId) {
        return showingRepository.findOne(showingId);
    }

    @Override
    public List<Showing> getShowings() {
        return (List<Showing>) showingRepository.findAll();
    }

    @Override
    public void addShowing(Showing showing) {
        showingRepository.save(showing);
    }

    @Override
    public void deleteShowing(Showing showing) {
        showingRepository.delete(showing.getShowing_id());
    }
}
