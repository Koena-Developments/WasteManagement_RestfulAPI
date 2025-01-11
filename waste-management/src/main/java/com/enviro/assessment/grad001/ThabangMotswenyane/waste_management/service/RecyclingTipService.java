package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service;

import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.RecyclingTip;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    // Create or update a recycling tip
    public RecyclingTip saveRecyclingTip(RecyclingTip recyclingTip) {
        return repository.save(recyclingTip);
    }

    // Get all recycling tips
    public List<RecyclingTip> getAllRecyclingTips() {
        return repository.findAll();
    }

    // Get a recycling tip by ID
    public RecyclingTip findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete a recycling tip by ID
    public void deleteRecyclingTip(Long id) {
        repository.deleteById(id);
    }
}
