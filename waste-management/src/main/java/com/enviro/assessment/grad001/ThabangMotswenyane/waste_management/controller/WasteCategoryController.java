package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.controller;

import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.WasteCategory;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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

}



//
//What’s Next?
//Once this works, we can add more functionality, such as creating, updating, and deleting waste categories.
