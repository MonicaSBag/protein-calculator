package com.studiopy.protein_calculator.model;

public class Alimento {

    private String nombre;
    private double proteina100g;

    public Alimento(String nombre, double proteina100g) {
        this.nombre = nombre;
        this.proteina100g = proteina100g;
    }

    public String getNombre() {
        return nombre;
    }

    public double getProteina100g() {
        return proteina100g;
    }
}
