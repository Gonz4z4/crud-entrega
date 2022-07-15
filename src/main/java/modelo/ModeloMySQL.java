package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ModeloMySQL implements Modelo{
    private static final String GET_ALL_QUERY = "SELECT * FROM juegos";
    private static final String GET_BY_ID_QUERY = "SELECT * FROM juegos WHERE idjuegos = ?";
    private static final String ADD_QUERY = "INSERT INTO juegos VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE juegos SET nombre = ?, desarrollador = ?, fecha-de-lanzamiento = ?, descripción = ?, género = ?, carátula = ?, link-compra = ? WHERE idjuegos = ?";
    private static final String DELETE_QUERY = "DELETE FROM juegos WHERE idjuegos = ?";

    @Override
    public List<Juego> getJuegos() { //trae a TODOS los juegos
        List<Juego> juegos = new ArrayList<>();
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                juegos.add(rsToJuego(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener juegos", ex);
        }
        return juegos;
    }

    @Override
    public Juego getJuego(int id) {
        Juego juego = null;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery();) {
                rs.next();
                juego = rsToJuego(rs);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener juegos", ex);
        }
        return juego;
    }

    @Override
    public int addJuego(Juego juego) {
        int regsAgregados = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(ADD_QUERY);) {
            fillPreparedStatement(ps, juego);
            regsAgregados = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener juegos", ex);
        }
        return regsAgregados;
    }

    @Override
    public int updateJuego(Juego juego) {
        int regsModificados = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);) {
            fillPreparedStatement(ps, juego);
            ps.setInt(6, juego.getId());
            regsModificados = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener juegos", ex);
        }
        return regsModificados;
    }

    @Override
    public int removeJuego(int id) {
        int regsBorrados = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(DELETE_QUERY);) {
            ps.setInt(1, id);
            regsBorrados = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener juegos", ex);
        }
        return regsBorrados;
    }
    
    private void fillPreparedStatement(PreparedStatement ps, Juego juego) throws SQLException {
        ps.setString(1, juego.getNombre());
        ps.setString(2, juego.getDesarrollador());
        ps.setString(3, juego.getFechaLanzamiento());
        ps.setString(4, juego.getDescripcion());
        ps.setString(5, juego.getGenero());
        ps.setString(6, juego.getCaratula());
        ps.setString(7, juego.getLinkCompra());
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
