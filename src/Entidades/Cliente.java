package Entidades;

public class Cliente {
    //private static int cont = 0;
    private int id;
    private String nombre, apellido, dni, telef, direccion, correo;
    private int estado = -1;

    
    public Cliente(){
      // this.id = cont++;
    }
    
    public Cliente(String nombre, String apellido, String dni, String telef, String direccion, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telef = telef;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getTelef() {
        return telef;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
    
    
    @Override
    public String toString() {
        return nombre + " " + apellido + " " + dni;
    }

    
}
