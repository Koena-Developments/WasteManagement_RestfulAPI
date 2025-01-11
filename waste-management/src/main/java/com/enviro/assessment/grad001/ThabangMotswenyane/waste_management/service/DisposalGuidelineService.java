package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service;

import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.DisposalGuideline;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    // Create or update a disposal guideline
    public DisposalGuideline saveDisposalGuideline(DisposalGuideline disposalGuideline) {
        return repository.save(disposalGuideline);
    }

    // Get all disposal guidelines
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return repository.findAll();
    }

    // Get disposal guideline by ID
    public DisposalGuideline findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete a disposal guideline by ID
    public void deleteDisposalGuideline(Long id) {
        repository.deleteById(id);
    }
}