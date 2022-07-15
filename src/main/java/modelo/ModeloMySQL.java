/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gonza
 */
public class ModeloMySQL implements Modelo{
    private static final String GET_ALL_QUERY = "SELECT * FROM juegos";
    private static final String GET_BY_ID_QUERY = "SELECT * FROM juegos WHERE idjuegos = ?";
    private static final String ADD_QUERY = "INSERT INTO juegos VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE juegos SET nombre = ?, desarrollador = ?, fecha-de-lanzamiento = ?, descripción = ?, género = ?, carátula = ?, link-compra = ? WHERE id_alumno = ?";
    private static final String DELETE_QUERY = "DELETE FROM juegos WHERE idjuegos = ?";

    @Override
    public List<Juego> getJuegos() { //trae a TODOS los juegos
        List<Juego> alumnos = new ArrayList<>();
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                alumnos.add(rsToJuego(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener alumnos", ex);
        }
        return alumnos;
    }

    @Override
    public Juego getJuego(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int addJuego(Juego juego) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int updateJuego(Juego juego) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int removeJuego(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    private Juego rsToJuego(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String nombre = rs.getString(2);
        String desarrollador = rs.getString(3);
        String fechaLanzamiento = rs.getString(4);
        String descripcion = rs.getString(5);
        String genero = rs.getString(6);
        String caratula = rs.getString(7);
        String linkCompra = rs.getString(8);
        return new Juego(id, nombre, desarrollador, fechaLanzamiento, descripcion, genero, caratula, linkCompra);
    }
}
