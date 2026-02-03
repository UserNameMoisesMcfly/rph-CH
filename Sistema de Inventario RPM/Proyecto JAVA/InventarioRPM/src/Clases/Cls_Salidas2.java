package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Salidas2 {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    //private final String SQL_INSERT_MERMA = "INSERT INTO merma (mer_pro_codigo, mer_fecha, mer_cantidad) values (?,?,?)";
    //private final String SQL_SELECT_SALIDAS = "SELECT sal_id,sal_fecha,sal_pro_codigo,pro_descripcion,sal_cantidad,sal_cantidad1,sal_pro_codigo2,sal_cantidad2 FROM salida INNER JOIN producto ON sal_pro_codigo = pro_codigo where pro_codigo=401742 ORDER BY sal_id ASC";
    String a="";
    public Cls_Salidas2(){
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
        DT.addColumn("Codigo");
        DT.addColumn("Descripción");
        DT.addColumn("Cantidad");
         DT.addColumn("Cantidad tapa");
        DT.addColumn("Divisor");
         DT.addColumn("Cantidad");
        return DT;
    }
    
    public DefaultTableModel getDatosSalida(String codigo,Date fecha_sql1,Date fecha_sql2){
        try {
            setTitulosSalida();
            String SQL_SELECT_SALIDAS = "SELECT sal_id,sal_fecha,sal_pro_codigo,pro_descripcion,sal_cantidad,sal_cantidad1,sal_pro_codigo2,sal_cantidad2 FROM salida INNER JOIN producto ON sal_pro_codigo = pro_codigo where pro_codigo='"+codigo+"' and sal_fecha between '"+fecha_sql1+"' and '"+fecha_sql2+"'ORDER BY sal_id ASC";
            PS = CN.getConnection().prepareStatement(SQL_SELECT_SALIDAS);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            while(RS.next()){
                 int r=RS.getInt(1);
                if(r<10){
                a="00000";
                fila[0] =a+ RS.getInt(1);
                }else if(r>=10 && r<100){
                a="0000";
                fila[0] =a+ RS.getInt(1);    
                }else if(r>=100 && r<1000){
                a="000";
                fila[0] =a+ RS.getInt(1);    
                }else if(r>=1000 && r<10000){
                a="00";
                fila[0] =a+ RS.getInt(1);    
                }else if(r>=10000 && r<100000){
                a="0";
                fila[0] =a+ RS.getInt(1);    
                }else{
                a="";
                fila[0] =a+ RS.getInt(1);    
                }
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
