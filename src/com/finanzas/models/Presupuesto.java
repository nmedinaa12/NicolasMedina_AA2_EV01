package com.finanzas.models;

public class Presupuesto {
    private int id;
    private double montoTotal;
    private String periodo;

    public Presupuesto(int id, double montoTotal, String periodo) {
        this.id = id;
        this.montoTotal = montoTotal;
        this.periodo = periodo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
