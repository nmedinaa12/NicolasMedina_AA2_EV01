package com.finanzas.dao;

import com.finanzas.models.Notificacion;
import com.finanzas.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificacionDAO {

    public void insertar(Notificacion notificacion) throws SQLException {
        String query = "INSERT INTO notificaciones (mensaje, fecha_envio) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, notificacion.getMensaje());
            stmt.setDate(2, new java.sql.Date(notificacion.getFechaEnvio().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Notificacion> consultar() throws SQLException {
        List<Notificacion> notificaciones = new ArrayList<>();
        String query = "SELECT * FROM notificaciones";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                notificaciones.add(new Notificacion(
                        rs.getInt("id"),
                        rs.getString("mensaje"),
                        rs.getDate("fecha_envio")
                ));
            }
        }
        return notificaciones;
    }

    public void actualizar(Notificacion notificacion) throws SQLException {
        String query = "UPDATE notificaciones SET mensaje = ?, fecha_envio = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, notificacion.getMensaje());
            stmt.setDate(2, new java.sql.Date(notificacion.getFechaEnvio().getTime()));
            stmt.setInt(3, notificacion.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM notificaciones WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
