package Base_Datos;

import java.util.ArrayList;

public interface ICRUD {
    public int crear(Object obj) throws Exception;
    public void actualizar(int id, Object obj) throws Exception;
    public void eliminar(int id) throws Exception;
    public ArrayList listar() throws Exception;
    public Object get(int id) throws Exception;
    public ArrayList listarinabilitados() throws Exception;
    public void restaurar(int id) throws Exception;
}
