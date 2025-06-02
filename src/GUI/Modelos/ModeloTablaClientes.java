package GUI.Modelos;

import Entidades.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModeloTablaClientes extends AbstractTableModel {
    
    private ArrayList<Cliente> listadoClientes = null;

    public void setListadoClientes(ArrayList listadoClientes) {
        this.listadoClientes = listadoClientes;
    }
    
    @Override
    public int getRowCount() {
        int cnt_filas=0;
        
        if(this.listadoClientes != null){
            cnt_filas = this.listadoClientes.size();
        }
        
        return cnt_filas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        String nombreCol = "";
        
        switch (column) {
            case 0: nombreCol = "Nombre"; break;
            case 1: nombreCol = "Apellido"; break;  
            case 2: nombreCol = "DNI"; break; 
            case 3: nombreCol = "Telefono"; break;
            default:
        }   
        
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object celda = "";
        Cliente objC = this.listadoClientes.get(rowIndex);
        if(this.listadoClientes != null){
            
            switch (columnIndex) {
            case 0: celda = objC.getNombre(); break;
            case 1: celda = objC.getApellido(); break;  
            case 2: celda = objC.getDni(); break; 
            case 3: celda = objC.getTelef(); break;
            
            }
        }
        
        return celda;
    }
    
}
