package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Merma1 {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
  //  private final String SQL_INSERT_MERMA = "INSERT INTO merma (mer_pro_codigo, mer_fecha, mer_cantidad,mer_cantidad1,mer_cantidad2) values (?,?,?,?,?)";
    private final String SQL_SELECT_ENTRADA = "SELECT mer_id,mer_nremision,mer_fecha,mer_pro_codigo, pro_descripcion, mer_cantidad,mer_cantidad1,mer_pro_codigo2,mer_cantidad2, mer_obs FROM merma INNER JOIN producto ON mer_pro_codigo = pro_codigo ORDER BY `mer_fecha` DESC";
    
    public Cls_Merma1(){
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
        DT.addColumn("");
        DT.addColumn("Remision");
        DT.addColumn("Fecha");
        DT.addColumn("Código");
        DT.addColumn("Descripción");
        DT.addColumn("Cuerpo");
        DT.addColumn("Tapa");
        DT.addColumn("Divisor");
        DT.addColumn("cantidad");
        DT.addColumn("Observaciones");
        return DT;
    }
    
    public DefaultTableModel getDatosSalida(){
        try {
            setTitulosSalida();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_ENTRADA);
            RS = PS.executeQuery();
            Object[] fila = new Object[10];
            while(RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getDate(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getInt(6);
                fila[6] = RS.getInt(7);
                fila[7] = RS.getString(8);
                fila[8] = RS.getInt(9);
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
