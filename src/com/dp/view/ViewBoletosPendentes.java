/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.view;

import com.dp.dao.Constantes;
import com.dp.dto.BoletoDTO;
import com.dp.dto.PessoaDTO;
import com.dp.service.ServiceImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GARCIA
 */
public class ViewBoletosPendentes extends javax.swing.JFrame {
    private PessoaDTO pessoa;
    private ServiceImpl service = new ServiceImpl();
    private List<String> listaFiltro = new ArrayList<String>();

    public ViewBoletosPendentes(PessoaDTO pessoa)  {
        this.pessoa = pessoa;
        initComponents();
        carregarBoletos(pessoa,"");
    }

  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jAtraso = new javax.swing.JCheckBox();
        jAberto = new javax.swing.JCheckBox();
        jPago = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Boletos ");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Boleto", "Data do boleto", "Status"
            }
        )
        {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            public boolean isCellEditable(int row, int column){
                return false;
            }
        });
        jTable.setCellSelectionEnabled(true);
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome Cliente");

        buttonGroup1.add(jAtraso);
        jAtraso.setText("Em Atraso");
        jAtraso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAtrasoMouseClicked(evt);
            }
        });

        buttonGroup1.add(jAberto);
        jAberto.setText("Em Aberto");
        jAberto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAbertoMouseClicked(evt);
            }
        });

        buttonGroup1.add(jPago);
        jPago.setText("Pago");
        jPago.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jPagoStateChanged(evt);
            }
        });
        jPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPagoMouseClicked(evt);
            }
        });
        jPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jAtraso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jAberto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAtraso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAberto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPagoActionPerformed
       
    }//GEN-LAST:event_jPagoActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
          if(evt.getClickCount() > 0){
            int linhaSel = jTable.getSelectedRow(); 
            int colunaSel = jTable.getSelectedColumn(); 
          
              System.out.println( linhaSel + " " + colunaSel);
              System.out.println(jTable.getValueAt(linhaSel, colunaSel));
              
              BoletoDTO boleto = new BoletoDTO();
              
              boleto.setCodigoBoleto((Long) jTable.getValueAt(linhaSel, 0));
              boleto.setStatus((String) jTable.getValueAt(linhaSel, 2));
              
              BoletoDTO boletoDTO = new BoletoDTO();
            
              boletoDTO = this.service.buscarBoletoPorId(boleto.getCodigoBoleto());
              
              ViewConsultaBoletosPendentes jframe = new ViewConsultaBoletosPendentes(boletoDTO);
              
              jframe.setVisible(true);
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPagoMouseClicked
  
    }//GEN-LAST:event_jPagoMouseClicked

    private void jPagoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jPagoStateChanged
           if(jPago.isSelected()) 
            this.carregarBoletos(pessoa, Constantes.PAGO);
    }//GEN-LAST:event_jPagoStateChanged

    private void jAtrasoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAtrasoMouseClicked
           if(jAtraso.isSelected()) 
            this.carregarBoletos(pessoa, Constantes.ATRASADO);
    }//GEN-LAST:event_jAtrasoMouseClicked

    private void jAbertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAbertoMouseClicked
           if(jAberto.isSelected()) 
            this.carregarBoletos(pessoa, Constantes.ABERTO);
    }//GEN-LAST:event_jAbertoMouseClicked

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jAberto;
    private javax.swing.JCheckBox jAtraso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox jPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables

    public void carregarBoletos(PessoaDTO pessoa, String filtro){
        
        
        
        List<BoletoDTO> listaBoleto = this.service.buscarBoleto(pessoa,filtro);
        
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setNumRows(Constantes.ZERO);
        Object rowData[] = new Object[3] ;
        
        listaBoleto.forEach(item -> {
            rowData[0] = item.getCodigoBoleto();
            rowData[1] = item.getDtVencimento();
            rowData[2] = item.getStatus();
            model.addRow(rowData);
        });
        
       
        
    }
}
