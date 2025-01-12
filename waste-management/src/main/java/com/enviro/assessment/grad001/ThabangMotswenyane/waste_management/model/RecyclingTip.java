package com.enviro.assessment.grad001.ThabangMotswenyane.waste_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tip is required")
    private String tip;

    public RecyclingTip() {
    }

    public RecyclingTip(Long ID, String Tip)
    {
        this.id = ID;
        this.tip = Tip;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
