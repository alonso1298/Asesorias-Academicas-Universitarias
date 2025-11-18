package mx.unam.dgtic.dao;

import mx.unam.dgtic.db.ConexionDB;
import mx.unam.dgtic.model.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO implements ICrudDAO<Materia>{
    @Override
    public List listar() {
        List<Materia> lista = new ArrayList<>();
        String sql = "SELECT * FROM materia";
        try(Connection conexion = ConexionDB.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Materia m = new Materia();
                    m.setId(rs.getInt("id"));
                    m.setNombre(rs.getString("nombre"));
                    lista.add(m);
                }
        }catch (Exception e) {
            System.out.println("Error al listar materias" + e.getMessage());
        }
        return lista;
    }

    @Override
    public Materia buscarPorId(int id) {
        Materia m = null;
        String sql = "SELECT * FROM materia WHERE id = ?";
        try(Connection conexion = ConexionDB.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql)){
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    m = new Materia();
                    m.setId(rs.getInt("id"));
                    m.setNombre(rs.getString("nombre"));
                }
        }catch (Exception e) {
            System.out.println("Error al listar materias" + e.getMessage());
        }
        return m;
    }

    @Override
    public int guardar(Materia materia) {
        String sql = "INSERT INTO materia(nombre) VALUES(?)";
        int filas = 0;

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, materia.getNombre());
            filas = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar materia: " + e.getMessage());
        }

        return filas;
    }

    @Override
    public void editar(Materia materia) {
        String sql = "UPDATE materia SET nombre = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar materia: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM materia WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al eliminar materia: " + e.getMessage());
        }
    }
}
