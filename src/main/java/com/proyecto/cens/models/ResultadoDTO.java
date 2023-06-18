package com.proyecto.cens.models;

public class ResultadoDTO {
    private String category;
    private Double value;

    public ResultadoDTO() {
    }

    public ResultadoDTO(String category, Double value) {
        this.category = category;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
