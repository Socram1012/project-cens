package com.proyecto.cens.models;

public class ResultadoPromedioDTO {
    private String category;
    private Float value;

    public ResultadoPromedioDTO() {
    }

    public ResultadoPromedioDTO(String category, Float value) {
        this.category = category;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}