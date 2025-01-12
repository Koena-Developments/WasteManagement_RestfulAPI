package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management;

import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.DisposalGuideline;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service.DisposalGuidelineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DisposableGuidelineServiceTest {

    @InjectMocks
    private DisposalGuidelineService service;

    @Mock
    private DisposalGuidelineRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDisposalGuidelines() {
        // Arrange
        when(repository.findAll()).thenReturn(Arrays.asList(
                new DisposalGuideline(1L, "Plastic", "Recycle in blue bins"),
                new DisposalGuideline(2L, "Organic", "Compost in green bins")
        ));

        // Act
        var result = service.getAllDisposalGuidelines();

        // Assert
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testSaveDisposalGuideline() {
        // Arrange
        DisposalGuideline guideline = new DisposalGuideline(null, "Glass", "Recycle in designated bins");
        when(repository.save(guideline)).thenReturn(guideline);

        // Act
        var result = service.saveDisposalGuideline(guideline);

        // Assert
        assertEquals("Glass", result.getWasteCategory());
        verify(repository, times(1)).save(guideline);
    }

    @Test
    void testFindById() {
        // Arrange
        DisposalGuideline guideline = new DisposalGuideline(1L, "Plastic", "Recycle in blue bins");
        when(repository.findById(1L)).thenReturn(Optional.of(guideline));

        // Act
        var result = service.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Plastic", result.getWasteCategory());
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
    void testDeleteDisposalGuideline() {
        // Arrange
        DisposalGuideline guideline = new DisposalGuideline(1L, "Plastic", "Recycle in blue bins");
        when(repository.findById(1L)).thenReturn(Optional.of(guideline));

        // Act
        service.deleteDisposalGuideline(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }
}
