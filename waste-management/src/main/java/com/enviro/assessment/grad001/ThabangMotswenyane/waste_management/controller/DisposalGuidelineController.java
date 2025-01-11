package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.controller;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.DisposalGuideline;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService service;

    // Get all disposal guidelines
    @GetMapping
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return service.getAllDisposalGuidelines();
    }

    // Get disposal guideline by ID
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuideline(@PathVariable Long id) {
        DisposalGuideline guideline = service.findById(id);
        if (guideline == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guideline);
    }

    // Create a new disposal guideline
    @PostMapping
    public DisposalGuideline createDisposalGuideline(@RequestBody DisposalGuideline disposalGuideline) {
        return service.saveDisposalGuideline(disposalGuideline);
    }

    // Update an existing disposal guideline
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(@PathVariable Long id, @RequestBody DisposalGuideline updatedGuideline) {
        DisposalGuideline existingGuideline = service.findById(id);
        if (existingGuideline == null) {
            return ResponseEntity.notFound().build();
        }
        existingGuideline.setWasteCategory(updatedGuideline.getWasteCategory());
        existingGuideline.setGuideline(updatedGuideline.getGuideline());
        DisposalGuideline savedGuideline = service.saveDisposalGuideline(existingGuideline);
        return ResponseEntity.ok(savedGuideline);
    }

    // Delete a disposal guideline
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        DisposalGuideline existingGuideline = service.findById(id);
        if (existingGuideline == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteDisposalGuideline(id);
        return ResponseEntity.ok().build();
    }
}