
package GUI.Modelos;

import Entidades.Producto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class ModeloTablaProducto extends AbstractTableModel{
    private ArrayList<Producto> listadoProducto = null;

    public void setProductos(ArrayList<Producto> productos) {
        this.listadoProducto = productos;
    }

    @Override
    public int getRowCount() {
        int cnt_filas=0;
        
        if(this.listadoProducto != null){
            cnt_filas = this.listadoProducto.size();
        }
        
        return cnt_filas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        String nombreCol = "";
        
        switch (column) {
            case 0: nombreCol = "Nombre"; break;
            case 1: nombreCol = "Categoria"; break;  
            case 2: nombreCol = "Precio"; break; 
            case 3: nombreCol = "Stock"; break;
            default:
        }   
        
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object celda = "";
        Producto objP = this.listadoProducto.get(rowIndex);
        if(this.listadoProducto != null){
            
            switch (columnIndex) {
            case 0: celda = objP.getNombre(); break;
            case 1: celda = objP.getCategoria(); break;  
            case 2: celda = objP.getPrecio(); break; 
            case 3: celda = objP.getStock(); break;
            
            }
        }
        
        return celda;
    }
}
