package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_RS {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    //private final String SQL_INSERT_MERMA = "INSERT INTO merma (mer_pro_codigo, mer_fecha, mer_cantidad) values (?,?,?)";
    //private final String SQL_SELECT_SALIDAS = "SELECT sal_id,sal_fecha,sal_pro_codigo,pro_descripcion,sal_cantidad,sal_cantidad1,sal_pro_codigo2,sal_cantidad2 FROM salida INNER JOIN producto ON sal_pro_codigo = pro_codigo";
    
    public Cls_RS(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosSalida(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        DT.addColumn("No. Remision");
        DT.addColumn("Fecha");
        DT.addColumn("Sku");
        DT.addColumn("Descripción");
        DT.addColumn("Cantidad");
         DT.addColumn("Cantidad tapa");
        DT.addColumn("Sku Divisor");
         DT.addColumn("Cantidad");
        return DT;
    }
    
    public DefaultTableModel getDatosSalida(Date fechaf){
        try {
            setTitulosSalida();
            String SQL_SELECT_SALIDAS = "SELECT sal_id,sal_fecha,sal_pro_codigo,pro_descripcion,sal_cantidad,sal_cantidad1,sal_pro_codigo2,sal_cantidad2 FROM salida INNER JOIN producto ON sal_pro_codigo = pro_codigo where sal_fecha='"+fechaf+"'ORDER BY sal_id ASC";
            PS = CN.getConnection().prepareStatement(SQL_SELECT_SALIDAS);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            while(RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getDate(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getInt(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getInt(8);
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos."+e.getMessage());
        } finally{
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DT;
    }
    
    
}
