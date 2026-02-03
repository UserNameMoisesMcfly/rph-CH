package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Entrada {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_ENTRADA = "INSERT INTO entrada (ent_nremision,ent_pro_codigo, ent_fecha, ent_cantidad, ent_cantidad1,ent_pro_codigo2,ent_cantidad2, ent_obs) values (?,?,?,?,?,?,?,?)";
    private final String SQL_SELECT_ENTRADA = "SELECT ent_id,ent_nremision,ent_fecha,ent_pro_codigo, pro_descripcion, ent_cantidad,ent_cantidad1,ent_pro_codigo2,ent_cantidad2, ent_obs FROM entrada INNER JOIN producto ON ent_pro_codigo = pro_codigo ORDER BY `ent_id` DESC";
    
    public Cls_Entrada(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosEntrada(){
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
    
    public DefaultTableModel getDatosEntradas(){
        try {
            setTitulosEntrada();
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
    
    public int registrarEntrada(String nremision, String codigo, Date fecha, int cantidad, int cantidad1, String div,  int cantidad2, String obs){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_ENTRADA);
            PS.setString(1, nremision); 
            PS.setString(2, codigo);
            PS.setDate(3, fecha);
            PS.setInt(4, cantidad);
            PS.setInt(5, cantidad1);
            PS.setString(6, div);
            PS.setInt(7, cantidad2);
            PS.setString(8, obs);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Entrada registrada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la entrada.");
            System.err.println("Error al registrar la entrada." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
     public int actualizarProducto(String nremision,String codigo,Date fecha_sql,int cantidad,int cantidad1,String div,int cantidad2, String obs, int id_old){
        String SQL = "UPDATE entrada SET ent_fecha='"+fecha_sql+"',ent_pro_codigo='"+codigo+"',ent_cantidad='"+cantidad+"',ent_cantidad1='"+cantidad1+"',ent_pro_codigo2='"+div+"',ent_cantidad2='"+cantidad2+"' WHERE ent_id='"+id_old+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Producto actualizado con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar los datos del cliente." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    public int eliminarProducto(int id_old){
        String SQL = "DELETE from entrada WHERE ent_id ='"+id_old+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar el producto.");
            System.err.println("Error al eliminar producto." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
}
