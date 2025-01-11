package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.controller;

import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.WasteCategory;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service;

    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return service.getAllWasteCategories();
    }

    @PostMapping
    public WasteCategory createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        return service.saveWasteCategory(wasteCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory updatedCategory) {
        WasteCategory existingCategory = service.findById(id);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }
        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());
        WasteCategory savedCategory = service.saveWasteCategory(existingCategory);
        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        WasteCategory existingCategory = service.findById(id);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteWasteCategory(id);
        return ResponseEntity.ok().build();
    }


}



//
//What’s Next?
//Once this works, we can add more functionality, such as creating, updating, and deleting waste categories.
