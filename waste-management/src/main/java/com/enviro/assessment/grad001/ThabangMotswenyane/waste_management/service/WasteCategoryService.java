package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.WasteCategory;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    public List<WasteCategory> getAllWasteCategories() {
        return repository.findAll();
    }

    public WasteCategory saveWasteCategory(WasteCategory wasteCategory) {
        return repository.save(wasteCategory);
    }

    public WasteCategory findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteWasteCategory(Long id) {
        repository.deleteById(id);
    }


}