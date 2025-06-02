/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Modelos;

import Entidades.Vendedor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class ModeloTablaVendedor extends AbstractTableModel {
     private ArrayList<Vendedor> listadoVendedor = null;
   
    public ArrayList getVendedor() {
        return listadoVendedor;
    }
    
    public void setlistadoVendedor(ArrayList listadoVendedor) {
        this.listadoVendedor = listadoVendedor;
    }
    
    @Override
    public int getRowCount() {
        int cnt_filas=0;
        
        if(this.listadoVendedor != null){
            cnt_filas = this.listadoVendedor.size();
        }
        
        return cnt_filas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombreCol = "";
        
        switch (columnIndex) {
            case 0: nombreCol = "Nombres"; break;
            case 1: nombreCol = "Apellidos"; break;  
            case 2: nombreCol = "Dni"; break; 
            case 3: nombreCol = "Correo"; break;
            default:
        }   
        
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object celda = "";
        Vendedor objV = this.listadoVendedor.get(rowIndex);
        if(this.listadoVendedor != null){
            
            switch (columnIndex) {
            case 0: celda = objV.getNombres(); break;
            case 1: celda = objV.getApellidos(); break;  
            case 2: celda = objV.getDni(); break; 
            case 3: celda = objV.getCorreo(); break;
            
            }
        }
        
        return celda;
    }
}
