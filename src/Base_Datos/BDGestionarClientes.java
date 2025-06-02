package Base_Datos;

import Entidades.Cliente;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionarClientes implements ICRUD {
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    @Override
    public ArrayList listar() throws Exception {
        ArrayList arrClientes = new ArrayList();
        
        try{
            this.con = Conexion.conectar();
            String sql = "SELECT * FROM cliente WHERE estado = 1";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Cliente objC = null;
            while(rs.next()){
                int id = rs.getInt("id");
                objC = new Cliente(rs.getString("nombre"), rs.getString("apellido"), 
                                   rs.getString("dni"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("correo"));
                objC.setId(id);
                if(this.Estado(id) == 1){
                    arrClientes.add(objC);
                }
            }
        }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
            throw e;
        } finally{
            this.con = null;
            this.ps = null;
            this.rs = null;
        }
        return arrClientes;    
    }
    
    @Override
    public int crear(Object obj) throws Exception {
        Cliente objC = (Cliente) obj;
        int idGenerado = -1;
        try{
            this.con = Conexion.conectar();
            String sql = "INSERT INTO cliente(nombre, apellido, dni, telefono, direccion, correo)" + "VALUES (?,?,?,?,?,?)";
            ps = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, objC.getNombre());
            ps.setString(2, objC.getApellido());
            ps.setString(3, objC.getDni());
            ps.setString(4, objC.getTelef());
            ps.setString(5, objC.getDireccion());
            ps.setString(6, objC.getCorreo());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                idGenerado = rs.getInt(1);
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.con = null;
            this.ps = null;
            this.rs = null;
        } 
        return idGenerado;
    }

    @Override
    public void actualizar(int id, Object obj) throws Exception {
        Cliente objC = (Cliente) obj;
        try{
            this.con = Conexion.conectar();
            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, telefono = ?, direccion = ?, correo = ? WHERE id = ?";
            ps = this.con.prepareStatement(sql);
            ps.setString(1, objC.getNombre());
            ps.setString(2, objC.getApellido());
            ps.setString(3, objC.getDni());
            ps.setString(4, objC.getTelef());
            ps.setString(5, objC.getDireccion());
            ps.setString(6, objC.getCorreo());
            ps.setInt(7, id);
            
            int filasAfectadas = ps.executeUpdate(); // <-- ¡Faltaba esta línea crucial!

            if (filasAfectadas > 0) {
                System.out.println("Cliente con ID " + id + " actualizado en BD.");
            } else {
                System.out.println("No se encontró cliente con ID " + id + " para actualizar o no hubo cambios.");
            }
                    
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            this.con = null;
            this.ps = null;
        }
        
    }

    @Override
    public void eliminar(int id) throws Exception {
        try{
            con = Conexion.conectar();
            String sql = "UPDATE cliente SET estado = 0 WHERE id = ?";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Cliente con ID " + id + " fue marcado como inactivo.");
            } else {
                System.out.println("No se encontró el cliente con ID " + id + " para marcarlo como inactivo.");
            }
            
        }catch(Exception e){
            throw e;
        }finally{
            con = null;
            ps = null;
        }
    }

    @Override
    public Object get(int id) throws Exception {
        Cliente objC = new Cliente();
        try{
            this.con = Conexion.conectar();
            String sql = "SELECT * FROM cliente WHERE id = ? ";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, id);
            this.rs = ps.executeQuery();
            if(rs.next()){
                objC.setNombre(rs.getString("nombre"));
                objC.setApellido(rs.getString("apellido"));
                objC.setDni(rs.getString("dni"));
                objC.setTelef(rs.getString("telefono"));
                objC.setDireccion(rs.getString("direccion"));
                objC.setCorreo(rs.getString("correo"));
            }else{
                objC=null;
            }         
             
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            this.con = null;
            this.ps = null;
        }
        return objC;
    }
    
    public int Estado(int id) throws Exception{
        int estado = 0;
        try {
        con = Conexion.conectar();
        String sql = "SELECT estado FROM cliente WHERE id = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            estado = rs.getInt("estado");
        }

        }catch (Exception e) {
            throw e;
        }
        return estado;
    }

    @Override
    public ArrayList listarinabilitados() throws Exception {
        ArrayList arrClientes = new ArrayList();
        
        try{
            this.con = Conexion.conectar();
            String sql = "SELECT * FROM cliente WHERE estado = 0";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Cliente objC = null;
            while(rs.next()){
                int id = rs.getInt("id");
                objC = new Cliente(rs.getString("nombre"), rs.getString("apellido"), 
                                   rs.getString("dni"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("correo"));
                objC.setId(id);
               
                arrClientes.add(objC);
                
            }
        }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
            throw e;
        } finally{
            this.con = null;
            this.ps = null;
            this.rs = null;
        }
        return arrClientes;        
    }

    @Override
    public void restaurar(int id) throws Exception {
        try{
            con = Conexion.conectar();
            String sql = "UPDATE cliente SET estado = 1 WHERE id = ?";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Cliente con ID " + id + " fue marcado como activo.");
            } else {
                System.out.println("No se encontró el cliente con ID " + id + " para marcarlo como activo.");
            }
            
        }catch(Exception e){
            throw e;
        }finally{
            con = null;
            ps = null;
        }
    }
}
