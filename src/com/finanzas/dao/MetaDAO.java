package com.finanzas.dao;

import com.finanzas.models.Meta;
import com.finanzas.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaDAO {

    public void insertar(Meta meta) throws SQLException {
        String query = "INSERT INTO metas (nombre, monto_objetivo, progreso) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, meta.getNombre());
            stmt.setDouble(2, meta.getMontoObjetivo());
            stmt.setDouble(3, meta.getProgreso());
            stmt.executeUpdate();
        }
    }

    public List<Meta> consultar() throws SQLException {
        List<Meta> metas = new ArrayList<>();
        String query = "SELECT * FROM metas";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                metas.add(new Meta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("monto_objetivo"),
                        rs.getDouble("progreso")
                ));
            }
        }
        return metas;
    }
}
