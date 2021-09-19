/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.mdEmpleado;
import excepciones.AccesoDatosEx;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import negocio.ComisionesImpl;

/**
 *
 * @author A
 */
public class ConsultaDatos extends javax.swing.JInternalFrame {

    private static ComisionesImpl comisiones;
    private static List<mdEmpleado> empleados = new ArrayList<>();
    private int idSeleccionado = 0;

    DefaultTableModel mdlTblEmpleados = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    TableCellRenderer rendererFromHeader;
    String estado;
    String monto;
    String acumulado;
    String pendiente;

    public ConsultaDatos() throws AccesoDatosEx {
        initComponents();
        cargarColumnasTabla();
        jProgressBarPersonas.setVisible(false);
        obtenerListaEmpleados();
        txtBuscar.setText("");
    }

    private void configTitleColumn() {
        final TableCellRenderer tcrOs = tblComisiones.getTableHeader().getDefaultRenderer();
        tblComisiones.getTableHeader().setDefaultRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel lbl = (JLabel) tcrOs.getTableCellRendererComponent(table,
                        value, isSelected, hasFocus, row, column);

                lbl.setHorizontalAlignment(SwingConstants.LEFT);
                lbl.setBackground(Color.black);
                lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
                return lbl;
            }
        });
    }

    private void obtenerListaEmpleados() throws AccesoDatosEx {
        comisiones = new ComisionesImpl();
        empleados = comisiones.listarComisiones();
        cargarModeloTabla();

    }

    private void cargarColumnasTabla() {
        mdlTblEmpleados.addColumn("");
        mdlTblEmpleados.addColumn("Nombre");
        mdlTblEmpleados.addColumn("Venta enero");
        mdlTblEmpleados.addColumn("Venta Febrero");
        mdlTblEmpleados.addColumn("Venta marzo");

        tblComisiones.getColumnModel().getColumn(0).setMaxWidth(0);
        tblComisiones.getColumnModel().getColumn(0).setMinWidth(0);

        tblComisiones.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblComisiones.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        configTitleColumn();

        //OCULTAR COLUMNAS PRECIOS PORQUE LAS MUESTRA EN CERO
        /* tblComisiones.getColumnModel().getColumn(7).setMaxWidth(0);
        tblComisiones.getColumnModel().getColumn(7).setMinWidth(0);
        
        tblComisiones.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        tblComisiones.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);*/
    }

    void cargarModeloTabla() {
        limpiarTabla();

        mdlTblEmpleados.setNumRows(1);

        mdlTblEmpleados.setValueAt("1", 0, 0);
        mdlTblEmpleados.setValueAt(estado, 0, 1);
        mdlTblEmpleados.setValueAt(monto, 0, 2);
        mdlTblEmpleados.setValueAt(acumulado, 0, 3);
        mdlTblEmpleados.setValueAt(pendiente, 0, 4);

        int numeroProductos = empleados.size();

        mdlTblEmpleados.setNumRows(numeroProductos);

        for (int i = 0; i < numeroProductos; i++) {
            mdEmpleado emp = empleados.get(i);

            int id = emp.getId();
            String nombre = emp.getNombre();
            String enero = String.valueOf(emp.getEnero());
            String febrero = String.valueOf(emp.getEnero());
            String marzo = String.valueOf(emp.getFebrero());

            mdlTblEmpleados.setValueAt(id, i, 0);
            mdlTblEmpleados.setValueAt(nombre, i, 1);
            mdlTblEmpleados.setValueAt(enero, i, 2);
            mdlTblEmpleados.setValueAt(febrero, i, 3);
            mdlTblEmpleados.setValueAt(marzo, i, 4);

        }

    }

    private void limpiarTabla() {
        int numFilas = mdlTblEmpleados.getRowCount();
        if (numFilas > 0) {
            for (int i = (numFilas - 1); i >= 0; i--) {
                mdlTblEmpleados.removeRow(i);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnClicDerecho = new javax.swing.JPopupMenu();
        mnModificar = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComisiones = new javax.swing.JTable();
        /*tblComisiones.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tblComisiones.getSelectedRow()>=0)){
                        int filaSeleccionada = tblComisiones.getSelectedRow();
                        com.soluciones.ferreteria.objetos.ObjetoProducto producto = (com.soluciones.ferreteria.objetos.ObjetoProducto)mdlTblEmpleados.getValueAt(filaSeleccionada, 1);

                        txtClave.setText(producto.getIdProducto());
                        txtClave.setEnabled(false);
                        txtNombre.setText(producto.getNombreProducto());
                        txtNombre.setEnabled(false);
                        String existencia = String.valueOf(producto.getExistencia());
                        txtExistencia.setText(existencia);
                        txtExistencia.setEnabled(false);
                        productoSeleccionado = producto;
                        desplegarFoto(producto);

                    }
                }
            }

        );*/
        lblDisponibles = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jProgressBarPersonas = new javax.swing.JProgressBar();
        btnBiscarEmpleado = new javax.swing.JButton();
        btnMaxMin = new javax.swing.JButton();
        btnTresMeses = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();

        mnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mnModificar.setForeground(new java.awt.Color(0, 102, 0));
        mnModificar.setText("Modificar");
        mnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnModificarActionPerformed(evt);
            }
        });
        mnClicDerecho.add(mnModificar);

        setTitle("Consulta de empleados y comisiones");
        setToolTipText("");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        tblComisiones.setAutoCreateRowSorter(true);
        tblComisiones.setModel(mdlTblEmpleados);
        tblComisiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblComisionesMousePressed(evt);
            }
        });
        tblComisiones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblComisionesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblComisiones);

        lblDisponibles.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDisponibles.setForeground(new java.awt.Color(51, 0, 153));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 0))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1034, 211));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("- Ingrese lo que desea buscar -");

        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnBiscarEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBiscarEmpleado.setText("Buscar");
        btnBiscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBiscarEmpleadoActionPerformed(evt);
            }
        });

        btnMaxMin.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnMaxMin.setText("Venta máxima y mínima");
        btnMaxMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxMinActionPerformed(evt);
            }
        });

        btnTresMeses.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTresMeses.setText("Ver 3 meses");
        btnTresMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresMesesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBarPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscar)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBiscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnMaxMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTresMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBiscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMaxMin, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 103, Short.MAX_VALUE)
                        .addComponent(btnTresMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addComponent(jProgressBarPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnEditar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 204));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(153, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 102, 102));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditar1.setForeground(new java.awt.Color(102, 102, 0));
        btnEditar1.setText("Recargar tabla");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 12, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased


    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //txtAgregar.setText("");
        //txtClave.setText("");
        //txtExistencia.setText("");
        //txtNombre.setText("");
    }//GEN-LAST:event_formMouseClicked

    private void mnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnModificarActionPerformed

    }//GEN-LAST:event_mnModificarActionPerformed

    private void tblComisionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblComisionesKeyReleased

    }//GEN-LAST:event_tblComisionesKeyReleased

    private void tblComisionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComisionesMousePressed
       int filaSeleccionada = tblComisiones.getSelectedRow();
        if(filaSeleccionada == -1){
            return;
        }
        
        this.idSeleccionado =  Integer.parseInt(String.valueOf(tblComisiones.getValueAt(filaSeleccionada, 0)));
    }//GEN-LAST:event_tblComisionesMousePressed

    private void btnBiscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBiscarEmpleadoActionPerformed
        String buscar = txtBuscar.getText();
        empleados = comisiones.buscarComisiones(buscar);
        cargarModeloTabla();
    }//GEN-LAST:event_btnBiscarEmpleadoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ActualizarForm form = new ActualizarForm(null, true, this.idSeleccionado);
        form.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnMaxMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxMinActionPerformed
        MaxMinForm form = new MaxMinForm(null, true);
        form.setVisible(true);
    }//GEN-LAST:event_btnMaxMinActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgregarForm form = new AgregarForm(null, true);
        form.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        try {
            obtenerListaEmpleados();
        } catch (AccesoDatosEx ex) {
            Logger.getLogger(ConsultaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnTresMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresMesesActionPerformed
        Venta3MesesForm form = new Venta3MesesForm(null, true);
        form.setVisible(true);
    }//GEN-LAST:event_btnTresMesesActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este empleado?");
            
            System.out.println(opcion);
            
            if(opcion == 0){
                comisiones.eliminarComision(idSeleccionado);
            }
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
            this.obtenerListaEmpleados();
        } catch (AccesoDatosEx ex) {
            Logger.getLogger(ConsultaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBiscarEmpleado;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMaxMin;
    private javax.swing.JButton btnTresMeses;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBarPersonas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDisponibles;
    private javax.swing.JPopupMenu mnClicDerecho;
    private javax.swing.JMenuItem mnModificar;
    private javax.swing.JTable tblComisiones;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
