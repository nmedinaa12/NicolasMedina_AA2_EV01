package com.finanzas.dao;

import com.finanzas.models.Presupuesto;
import com.finanzas.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresupuestoDAO {

    public void insertar(Presupuesto presupuesto) throws SQLException {
        String query = "INSERT INTO presupuestos (monto_total, periodo) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, presupuesto.getMontoTotal());
            stmt.setString(2, presupuesto.getPeriodo());
            stmt.executeUpdate();
        }
    }

    public List<Presupuesto> consultar() throws SQLException {
        List<Presupuesto> presupuestos = new ArrayList<>();
        String query = "SELECT * FROM presupuestos";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                presupuestos.add(new Presupuesto(
                        rs.getInt("id"),
                        rs.getDouble("monto_total"),
                        rs.getString("periodo")
                ));
            }
        }
        return presupuestos;
    }

    public void actualizar(Presupuesto presupuesto) throws SQLException {
        String query = "UPDATE presupuestos SET monto_total = ?, periodo = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, presupuesto.getMontoTotal());
            stmt.setString(2, presupuesto.getPeriodo());
            stmt.setInt(3, presupuesto.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM presupuestos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

