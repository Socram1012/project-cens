package com.proyecto.cens.models;

public class Grafico {
    private String category;
    private int value;
    public Grafico(String category, int value) { this.category = category; this.value = value; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
}
