package com.finanzas.dao;

import com.finanzas.models.Cuenta;
import com.finanzas.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {

    public void insertar(Cuenta cuenta) throws SQLException {
        String query = "INSERT INTO cuentas (nombre, tipo, saldo) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cuenta.getNombre());
            stmt.setString(2, cuenta.getTipo());
            stmt.setDouble(3, cuenta.getSaldo());
            stmt.executeUpdate();
        }
    }

    public List<Cuenta> consultar() throws SQLException {
        List<Cuenta> cuentas = new ArrayList<>();
        String query = "SELECT * FROM cuentas";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                cuentas.add(new Cuenta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getDouble("saldo")
                ));
            }
        }
        return cuentas;
    }

    public void actualizar(Cuenta cuenta) throws SQLException {
        String query = "UPDATE cuentas SET nombre = ?, tipo = ?, saldo = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cuenta.getNombre());
            stmt.setString(2, cuenta.getTipo());
            stmt.setDouble(3, cuenta.getSaldo());
            stmt.setInt(4, cuenta.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM cuentas WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

