package com.finanzas.dao;

import com.finanzas.models.Transaccion;
import com.finanzas.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaccionDAO {

    public void insertar(Transaccion transaccion) throws SQLException {
        String query = "INSERT INTO transacciones (descripcion, monto, tipo) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, transaccion.getDescripcion());
            stmt.setDouble(2, transaccion.getMonto());
            stmt.setString(3, transaccion.getTipo());
            stmt.executeUpdate();
        }
    }

    public List<Transaccion> consultar() throws SQLException {
        List<Transaccion> transacciones = new ArrayList<>();
        String query = "SELECT * FROM transacciones";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                transacciones.add(new Transaccion(
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getDouble("monto"),
                        rs.getString("tipo")
                ));
            }
        }
        return transacciones;
    }

    public void actualizar(Transaccion transaccion) throws SQLException {
        String query = "UPDATE transacciones SET descripcion = ?, monto = ?, tipo = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, transaccion.getDescripcion());
            stmt.setDouble(2, transaccion.getMonto());
            stmt.setString(3, transaccion.getTipo());
            stmt.setInt(4, transaccion.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM transacciones WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
