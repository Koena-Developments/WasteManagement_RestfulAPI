package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management;

import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.RecyclingTip;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service.RecyclingTipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecyclingTipServiceTest {

    @InjectMocks
    private RecyclingTipService service;

    @Mock
    private RecyclingTipRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRecyclingTips() {
        // Arrange
        when(repository.findAll()).thenReturn(Arrays.asList(
                new RecyclingTip(1L, "Reuse jars as containers"),
                new RecyclingTip(2L, "Recycle old newspapers")
        ));

        // Act
        var result = service.getAllRecyclingTips();

        // Assert
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testSaveRecyclingTip() {
        // Arrange
        RecyclingTip tip = new RecyclingTip(null, "Avoid single-use plastics");
        when(repository.save(tip)).thenReturn(tip);

        // Act
        var result = service.saveRecyclingTip(tip);

        // Assert
        assertEquals("Avoid single-use plastics", result.getTip());
        verify(repository, times(1)).save(tip);
    }

    @Test
    void testFindById() {
        // Arrange
        RecyclingTip tip = new RecyclingTip(1L, "Reuse jars as containers");
        when(repository.findById(1L)).thenReturn(Optional.of(tip));

        // Act
        var result = service.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Reuse jars as containers", result.getTip());
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
    void testDeleteRecyclingTip() {
        // Arrange
        RecyclingTip tip = new RecyclingTip(1L, "Reuse jars as containers");
        when(repository.findById(1L)).thenReturn(Optional.of(tip));

        // Act
        service.deleteRecyclingTip(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }
}
