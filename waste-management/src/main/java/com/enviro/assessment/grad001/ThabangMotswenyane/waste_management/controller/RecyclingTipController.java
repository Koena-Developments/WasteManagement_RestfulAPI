package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.controller;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.RecyclingTip;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService service;

    // Get all recycling tips
    @GetMapping
    public List<RecyclingTip> getAllRecyclingTips() {
        return service.getAllRecyclingTips();
    }

    // Get a recycling tip by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTip(@PathVariable Long id) {
        RecyclingTip tip = service.findById(id);
        if (tip == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tip);
    }

    // Create a new recycling tip
    @PostMapping
    public RecyclingTip createRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        return service.saveRecyclingTip(recyclingTip);
    }

    // Update an existing recycling tip
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @RequestBody RecyclingTip updatedTip) {
        RecyclingTip existingTip = service.findById(id);
        if (existingTip == null) {
            return ResponseEntity.notFound().build();
        }
        existingTip.setTip(updatedTip.getTip());
        RecyclingTip savedTip = service.saveRecyclingTip(existingTip);
        return ResponseEntity.ok(savedTip);
    }

    // Delete a recycling tip
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        RecyclingTip existingTip = service.findById(id);
        if (existingTip == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteRecyclingTip(id);
        return ResponseEntity.ok().build();
    }
}