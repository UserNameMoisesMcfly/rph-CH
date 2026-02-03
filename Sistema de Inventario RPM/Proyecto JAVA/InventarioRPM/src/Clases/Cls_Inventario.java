package Clases;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class Cls_Inventario {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_SELECT_ENTRADA = "SELECT ent_id,ent_nremision,ent_fecha,ent_pro_codigo, pro_descripcion, ent_cantidad,ent_cantidad1, ent_pro_codigo2,ent_cantidad2, ent_obs FROM entrada INNER JOIN producto ON ent_pro_codigo = pro_codigo ORDER BY `ent_id` ASC";
    
    public Cls_Inventario(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosInventario2(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        DT.addColumn("#");
        DT.addColumn("Remision");
        DT.addColumn("Fecha");
        DT.addColumn("Sku");
        DT.addColumn("Descripción");
        DT.addColumn("Cuerpo");
        DT.addColumn("Tapa");
        DT.addColumn("Sku Divisor");
        DT.addColumn("Cantidad");
        DT.addColumn("Observaciones");
        return DT;
    }
    
    public DefaultTableModel getDatosInventario2(){
        try {
            setTitulosInventario2();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_ENTRADA);
            RS = PS.executeQuery();
            Object[] fila = new Object[10];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getDate(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getInt(6);
                fila[6] = RS.getInt(7);
                fila[7] = RS.getInt(8);
                fila[8] = RS.getString(9);
                fila[9] = RS.getString(10);
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
