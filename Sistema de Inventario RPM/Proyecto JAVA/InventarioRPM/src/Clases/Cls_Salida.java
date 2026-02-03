package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Salida {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;

    private final String SQL_INSERT_SALIDA = "INSERT INTO salida (sal_pro_codigo, sal_fecha, sal_cantidad,sal_cantidad1,sal_pro_codigo2,sal_pro_des,sal_cantidad2) values (?,?,?,?,?,?,?)";
    public final String SQL_SELECT_SALIDA = "SELECT Concat('0000',(COUNT(sal_id)+1)) From salida";

    String a = "";

    public Cls_Salida(){
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

        DT.addColumn("No. FOLIO:");
        return DT;
    }

    public DefaultTableModel getDatosSalida(){
        try {
            setTitulosSalida();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_SALIDA);
            RS = PS.executeQuery();
            Object[] fila = new Object[1];
            while(RS.next()){
                int r = RS.getInt(1);
                if(r < 10){
                    a = "00000";
                    fila[0] = a + RS.getInt(1);
                }else if(r >= 10 && r < 100){
                    a = "0000";
                    fila[0] = a + RS.getInt(1);
                }else if(r >= 100 && r < 1000){
                    a = "000";
                    fila[0] = a + RS.getInt(1);
                }else if(r >= 1000 && r < 10000){
                    a = "00";
                    fila[0] = a + RS.getInt(1);
                }else if(r >= 10000 && r < 100000){
                    a = "0";
                    fila[0] = a + RS.getInt(1);
                }else{
                    a = "";
                    fila[0] = a + RS.getInt(1);
                }
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally{
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DT;
    }

    public int registrarSalida(String codigo, Date fecha, int cantidad, int cantidad1, String codigo1, String des, int cantidad2){
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_SALIDA);
            PS.setString(1, codigo);
            PS.setDate(2, fecha);
            PS.setInt(3, cantidad);
            PS.setInt(4, cantidad1);
            PS.setString(5, codigo1);
            PS.setString(6, des);
            PS.setInt(7, cantidad2);

            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Salida registrada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la salida.");
            System.err.println("Error al registrar la salida." + e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int verificarStock(String codigo){
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement("SELECT inv_stock from inventario where inv_pro_codigo = ?");
            PS.setString(1, codigo);
            RS = PS.executeQuery();

            while(RS.next()){
                res = RS.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Error al devolver cantidad de registros." + e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int verificarStock1(String codigo1){
        int res1 = 0;
        try {
            PS = CN.getConnection().prepareStatement("SELECT inv_stock3 from inventario where inv_pro_codigo = ?");
            PS.setString(1, codigo1);
            RS = PS.executeQuery();

            while(RS.next()){
                res1 = RS.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Error al devolver cantidad de registros." + e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res1;
    }

    /**
     * Obtiene la descripción (tabla producto) para un código.
     * @return descripción o "" si no existe.
     */
    public String obtenerDescripcionProducto(String codigo){
        String des = "";
        try{
            PS = CN.getConnection().prepareStatement("SELECT pro_descripcion FROM producto WHERE pro_codigo = ?");
            PS.setString(1, codigo);
            RS = PS.executeQuery();
            if(RS.next()){
                des = RS.getString(1);
            }
        }catch(SQLException e){
            System.err.println("Error al obtener descripcion de producto: " + e.getMessage());
        }finally{
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return des == null ? "" : des;
    }

    /**
     * Intenta obtener el código de divisor desde la BD tomando el último registro de salida del SKU.
     * @return código divisor o "" si no se encuentra.
     */
    public String obtenerUltimoDivisorCodigo(String codigoProducto){
        String div = "";
        try{
            PS = CN.getConnection().prepareStatement(
                "SELECT sal_pro_codigo2 FROM salida " +
                "WHERE sal_pro_codigo = ? AND sal_pro_codigo2 IS NOT NULL AND sal_pro_codigo2 <> '' " +
                "ORDER BY sal_id DESC LIMIT 1"
            );
            PS.setString(1, codigoProducto);
            RS = PS.executeQuery();
            if(RS.next()){
                div = RS.getString(1);
            }
        }catch(SQLException e){
            System.err.println("Error al obtener divisor desde salida: " + e.getMessage());
        }finally{
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return div == null ? "" : div;
    }

    /**
     * Devuelve {codigoDivisor, descripcionDivisor}. Primero intenta BD (última salida),
     * y si no hay, usa reglas hardcodeadas existentes.
     * @return arreglo de 2 strings, o null si no hay divisor.
     */
    public String[] obtenerDivisorPorProducto(String codigoProducto){
        if(codigoProducto == null) return null;
        String sku = codigoProducto.trim();
        if(sku.isEmpty()) return null;

        // 1) Intentar desde BD (última salida)
        String divCodigo = obtenerUltimoDivisorCodigo(sku);

        // 2) Fallback hardcodeado (histórico del sistema)
        if(divCodigo.isEmpty()){
            try{
                int b1 = Integer.parseInt(sku);
                if(b1==401742 || b1==400349){
                    divCodigo = "400166";
                }else if(b1==400734 || b1==401453){
                    divCodigo = "400689";
                }else if(b1==401735 || b1==402087){
                    divCodigo = "401473";
                }else if(b1==401462){
                    divCodigo = "400164";
                }
            }catch(NumberFormatException ignore){
                // no numérico
            }
        }

        if(divCodigo == null || divCodigo.trim().isEmpty()){
            return null;
        }

        String divDes = obtenerDescripcionProducto(divCodigo);
        if(divDes.trim().isEmpty()){
            // Último recurso
            if(divCodigo.equals("400166")) divDes = "DIV.20/4 LAM.";
            else if(divCodigo.equals("400689")) divDes = "DIV. LAM. 40 OZ";
            else if(divCodigo.equals("401473")) divDes = "DIV. 12/1 NR";
            else if(divCodigo.equals("400164")) divDes = "DIV.20/2 LAM.GEN.";
        }

        return new String[]{divCodigo, divDes};
    }
}
