package Formularios;

import Clases.Cls_Inventario_General;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;


public class Frm_Inventario_General extends javax.swing.JInternalFrame {
    private final Cls_Inventario_General CP;
    TableColumnModel columnModel;
    public static int enviar = 0;
    int num = 0;
    
    public Frm_Inventario_General() {
        initComponents();
        CP = new Cls_Inventario_General();
        columnModel = jtb_inventario.getColumnModel();
        Calendar fecha = new GregorianCalendar();                                                 
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
      switch(mes+1){
          case 1:
               if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "ENERO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "ENERO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 2:
              if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "FEBRERO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "FEBRERO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 3:
         if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "MARZO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "MARZO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 4:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "ABRIL " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "ABRIL " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 5:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "MAYO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "MAYO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 6:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "JUNIO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "JUNIO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 7:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "JULIO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "JULIO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 8:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "AGOSTO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "AGOSTO " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 9:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "SEPTIEMBRE " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "SEPTIEMBRE " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 10:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "OCTUBRE " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "OCTUBRE " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 11:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "NOVIEMBRE " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "NOVIEMBRE " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
          case 12:
        if(hora<12){
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "DICIEMBRE " + "DE " + año + "    HORA: " + (hora) + ":" + min + " am" );
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }else{
        jLabel1.setText("INVENTARIO DEL " + dia + " DE " + "DICIEMBRE " + "DE " + año + "    HORA: " + (hora) + ":" + min + " pm");   
        jLabel2.setText("MAQUILA RPM-VICHISA");
        }
              break;
      }
       
        listar();
    }
    
    private void listar(){
        jtb_inventario.setModel(CP.getDatosInventario2());
        columnModel.getColumn(1).setPreferredWidth(150);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_inventario = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Inventarios");
        setPreferredSize(new java.awt.Dimension(960, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1029, 515));

        jtb_inventario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtb_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_inventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_inventario);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("jLabel2");

        jButton4.setText("Exportar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(976, 976, 976)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(286, 286, 286)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_inventarioMouseClicked

    }//GEN-LAST:event_jtb_inventarioMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       JFileChooser chooser=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Archivos de excel","xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
            List<JTable> tb=new ArrayList<>();
            List<String>nom=new ArrayList<>();
            tb.add(jtb_inventario);
            nom.add("Detalle de Gastos");
            String file=chooser.getSelectedFile().toString().concat(".xls");
            try {
               Exporter e=new Exporter(new File(file),tb, nom);
                if (e.export()) {
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.","BCO",
                        JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Hubo un error"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_inventario;
    // End of variables declaration//GEN-END:variables
}
