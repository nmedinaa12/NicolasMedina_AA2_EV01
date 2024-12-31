package com.finanzas.app;

import com.finanzas.dao.*;
import com.finanzas.utils.DatabaseConnection;
import com.finanzas.models.*;
import java.sql.Connection;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            // Verificar conexión con la base de datos
            try (Connection conn = DatabaseConnection.getConnection()) {
                if (conn != null) {
                    System.out.println("Conexión exitosa a la base de datos");
                } else {
                    System.out.println("Conexión fallida a la base de datos");
                    return; // Termina el programa si la conexión falla
                }
            } catch (Exception e) {
                System.err.println("Error al conectar con la base de datos: " + e.getMessage());
                e.printStackTrace();
                return; // Termina el programa si ocurre un error en la conexión
            }

            // Instanciar los DAO
            TransaccionDAO transaccionDAO = new TransaccionDAO();
            MetaDAO metaDAO = new MetaDAO();
            PresupuestoDAO presupuestoDAO = new PresupuestoDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            CuentaDAO cuentaDAO = new CuentaDAO();
            NotificacionDAO notificacionDAO = new NotificacionDAO();

            // ===== CRUD para Transacciones =====
            System.out.println("=== Transacciones ===");
            Transaccion nuevaTransaccion = new Transaccion(0, "Compra de supermercado", 200.0, "gasto");
            transaccionDAO.insertar(nuevaTransaccion);
            List<Transaccion> transacciones = transaccionDAO.consultar();
            for (Transaccion t : transacciones) {
                System.out.println("Transacción: " + t.getDescripcion() + " - Monto: " + t.getMonto());
            }

            // ===== CRUD para Metas =====
            System.out.println("\n=== Metas ===");
            Meta nuevaMeta = new Meta(0, "Vacaciones", 5000.0, 2000.0);
            metaDAO.insertar(nuevaMeta);
            List<Meta> metas = metaDAO.consultar();
            for (Meta m : metas) {
                System.out.println("Meta: " + m.getNombre() + " - Progreso: " + m.getProgreso() + "/" + m.getMontoObjetivo());
            }

            // ===== CRUD para Presupuestos =====
            System.out.println("\n=== Presupuestos ===");
            Presupuesto nuevoPresupuesto = new Presupuesto(0, 1000.0, "Mensual");
            presupuestoDAO.insertar(nuevoPresupuesto);
            List<Presupuesto> presupuestos = presupuestoDAO.consultar();
            for (Presupuesto p : presupuestos) {
                System.out.println("Presupuesto: " + p.getMontoTotal() + " - Periodo: " + p.getPeriodo());
            }

            // ===== CRUD para Categorías =====
            System.out.println("\n=== Categorías ===");
            Categoria nuevaCategoria = new Categoria(0, "Entretenimiento");
            categoriaDAO.insertar(nuevaCategoria);
            List<Categoria> categorias = categoriaDAO.consultar();
            for (Categoria c : categorias) {
                System.out.println("Categoría: " + c.getNombre());
            }

            // ===== CRUD para Cuentas =====
            System.out.println("\n=== Cuentas ===");
            Cuenta nuevaCuenta = new Cuenta(0, "Cuenta de Ahorro", "ahorro", 3000.0);
            cuentaDAO.insertar(nuevaCuenta);
            List<Cuenta> cuentas = cuentaDAO.consultar();
            for (Cuenta c : cuentas) {
                System.out.println("Cuenta: " + c.getNombre() + " - Saldo: " + c.getSaldo());
            }

            // ===== CRUD para Notificaciones =====
            System.out.println("\n=== Notificaciones ===");
            Notificacion nuevaNotificacion = new Notificacion(0, "Pago recibido", new java.util.Date());
            notificacionDAO.insertar(nuevaNotificacion);
            List<Notificacion> notificaciones = notificacionDAO.consultar();
            for (Notificacion n : notificaciones) {
                System.out.println("Notificación: " + n.getMensaje() + " - Fecha: " + n.getFechaEnvio());
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
