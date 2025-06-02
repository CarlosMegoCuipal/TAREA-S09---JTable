package Base_Datos;

import java.sql.*;

public class Conexion {
    private static String url = "jdbc:mysql://localhost:3306/gestionclientes";
    private static String user = "root";
    private static String password = "";
    
    public static Connection conectar() throws SQLException{
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("CONEXION EXITOSA");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
        return conexion;
    }
    
}
