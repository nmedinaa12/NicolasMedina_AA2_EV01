package com.finanzas.models;

public class Meta {
    private int id;
    private String nombre;
    private double montoObjetivo;
    private double progreso;

    public Meta(int id, String nombre, double montoObjetivo, double progreso) {
        this.id = id;
        this.nombre = nombre;
        this.montoObjetivo = montoObjetivo;
        this.progreso = progreso;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMontoObjetivo() {
        return montoObjetivo;
    }

    public void setMontoObjetivo(double montoObjetivo) {
        this.montoObjetivo = montoObjetivo;
    }

    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
    }
}
