package Base_Datos;

import Entidades.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BDGestionVendedor implements ICRUD {
     @Override
    public int crear(Object obj) throws Exception {
        Vendedor vendedor = (Vendedor) obj;
        String sql = "INSERT INTO vendedor (nombres, apellidos, dni, correo) VALUES (?, ?, ?, ?)";
        int idGenerado = -1;
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, vendedor.getNombres());
            ps.setString(2, vendedor.getApellidos());
            ps.setString(3, vendedor.getDni());
            ps.setString(4, vendedor.getCorreo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        }
        return idGenerado;
    }

    @Override
    public void actualizar(int id, Object obj) throws Exception {
        Vendedor vendedor = (Vendedor) obj;
        String sql = "UPDATE vendedor SET nombres = ?, apellidos = ?, dni = ?, correo = ? WHERE id = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vendedor.getNombres());
            ps.setString(2, vendedor.getApellidos());
            ps.setString(3, vendedor.getDni());
            ps.setString(4, vendedor.getCorreo());
            ps.setInt(5, id);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM vendedor WHERE id = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ArrayList<Vendedor> listar() throws Exception {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM vendedor";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                vendedores.add(new Vendedor(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("correo")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return vendedores;
    }

    @Override
    public Object get(int id) throws Exception {
        Vendedor vendedor;
        String sql = "SELECT * FROM vendedor WHERE id = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) throw new Exception("Vendedor no encontrado");

            vendedor = new Vendedor(
                    rs.getInt("id"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("dni"),
                    rs.getString("correo")
            );
        } catch (Exception e) {
            throw e;
        }
        return vendedor;
    }

    @Override
    public ArrayList listarinabilitados() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void restaurar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
