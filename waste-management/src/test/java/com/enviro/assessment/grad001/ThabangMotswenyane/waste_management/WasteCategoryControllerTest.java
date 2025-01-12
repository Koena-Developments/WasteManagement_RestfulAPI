//package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management;
//
//import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.controller.WasteCategoryController;
//import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.service.WasteCategoryService;
//import com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model.WasteCategory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(controllers = WasteCategoryController.class)
//@Import(WasteCategoryControllerTest.TestConfig.class)
//class WasteCategoryControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WasteCategoryService service;
//
//    // Test configuration to provide a mocked service
//    @Import(WasteCategoryController.class)
//    static class TestConfig {
//        @Bean
//        public WasteCategoryService wasteCategoryService() {
//            return Mockito.mock(WasteCategoryService.class);
//        }
//    }
//
//    @BeforeEach
//    void setUp() {
//        // Mock service setup (optional, can also go directly into tests)
//    }
//
//    @Test
//    void testGetAllWasteCategories() throws Exception {
//        // Arrange
//        when(service.getAllWasteCategories()).thenReturn(Arrays.asList(
//                new WasteCategory(1L, "Plastic", "Non-biodegradable"),
//                new WasteCategory(2L, "Organic", "Biodegradable")
//        ));
//
//        // Act & Assert
//        mockMvc.perform(get("/api/waste-categories"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name").value("Plastic"))
//                .andExpect(jsonPath("$[1].name").value("Organic"));
//    }
//
//    @Test
//    void testCreateWasteCategory() throws Exception {
//        // Arrange
//        WasteCategory category = new WasteCategory(1L, "Glass", "Recyclable");
//        when(service.saveWasteCategory(any(WasteCategory.class))).thenReturn(category);
//
//        // Act & Assert
//        mockMvc.perform(post("/api/waste-categories")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\":\"Glass\",\"description\":\"Recyclable\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Glass"));
//    }
//
//    @Test
//    void testUpdateWasteCategory() throws Exception {
//        // Arrange
//        WasteCategory category = new WasteCategory(1L, "Glass", "Recyclable");
//        when(service.saveWasteCategory(any(WasteCategory.class))).thenReturn(category);
//        when(service.findById(1L)).thenReturn(category);
//
//        // Act & Assert
//        mockMvc.perform(put("/api/waste-categories/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\":\"Glass\",\"description\":\"Recyclable updated\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Glass"))
//                .andExpect(jsonPath("$.description").value("Recyclable updated"));
//    }
//
//    @Test
//    void testDeleteWasteCategory() throws Exception {
//        // Arrange
//        WasteCategory category = new WasteCategory(1L, "Plastic", "Non-biodegradable");
//        when(service.findById(1L)).thenReturn(category);
//
//        // Act & Assert
//        mockMvc.perform(delete("/api/waste-categories/1"))
//                .andExpect(status().isOk());
//    }
//}
