package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management;

import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.WasteCategory;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service.WasteCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WasteCategoryServiceTest {

    @InjectMocks
    private WasteCategoryService service;

    @Mock
    private WasteCategoryRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllWasteCategories() {
        // Arrange
        WasteCategory category1 = new WasteCategory(null, "Plastic", "Non-biodegradable");
        WasteCategory category2 = new WasteCategory(null, "Organic", "Biodegradable");
        when(repository.findAll()).thenReturn(Arrays.asList(category1, category2));

        // Act
        var result = service.getAllWasteCategories();

        // Assert
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testSaveWasteCategory() {
        // Arrange
        WasteCategory category = new WasteCategory(null, "Glass", "Recyclable");
        when(repository.save(category)).thenReturn(category);

        // Act
        var result = service.saveWasteCategory(category);

        // Assert
        assertEquals("Glass", result.getName());
        verify(repository, times(1)).save(category);
    }

    @Test
    void testFindById() {
        // Arrange
        WasteCategory category = new WasteCategory(1L, "Plastic", "Non-biodegradable");
        when(repository.findById(1L)).thenReturn(Optional.of(category));

        // Act
        var result = service.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Plastic", result.getName());
    }

    @Test
    void testFindByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act
        var result = service.findById(1L);

        // Assert
        assertNull(result);
    }

    @Test
    void testDeleteWasteCategory() {
        // Arrange
        WasteCategory category = new WasteCategory(1L, "Plastic", "Non-biodegradable");
        when(repository.findById(1L)).thenReturn(Optional.of(category));

        // Act
        service.deleteWasteCategory(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }
//
//    @Test
//    void testDeleteWasteCategoryNotFound() {
//        // Arrange
//        when(repository.findById(1L)).thenReturn(Optional.empty());
//
//        // Act & Assert
//        assertThrows(IllegalArgumentException.class, () -> service.deleteWasteCategory(1L));
//    }
}

