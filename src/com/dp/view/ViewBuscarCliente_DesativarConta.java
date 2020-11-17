/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.view;

import com.dp.dto.PessoaDTO;
import com.dp.service.ServiceImpl;

import javax.swing.JOptionPane;

/**
 *
 * @author GARCIA
 */
public class ViewBuscarCliente_DesativarConta extends javax.swing.JFrame {
    private ServiceImpl service = new ServiceImpl();
    private PessoaDTO pessoa;
    
    public ViewBuscarCliente_DesativarConta() {
        
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultar = new javax.swing.JButton();
        txtCpf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnBoletos = new javax.swing.JButton();
        btnDesativarConta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        jLabel1.setText("CNPJ/CPF");
        jLabel1.setToolTipText("");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnBoletos.setText("Boletos");
        btnBoletos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletosActionPerformed(evt);
            }
        });

        btnDesativarConta.setText("Desativar Conta");
        btnDesativarConta.setEnabled(false);
        btnDesativarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarContaActionPerformed(evt);
            }
        });

        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        txtInfo.setText("Dados do cliente...\n\n");
        jScrollPane2.setViewportView(txtInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesativarConta))
                    .addComponent(jScrollPane2))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnBoletos)
                    .addComponent(btnDesativarConta))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnDesativarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarContaActionPerformed
       
        
        ViewContinuacao_DesativarConta jframe = 
                new ViewContinuacao_DesativarConta(txtCpf.getText());
        jframe.setVisible(true);
        
    }//GEN-LAST:event_btnDesativarContaActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
          this.validarCampo();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnBoletosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletosActionPerformed
        ViewBoletosPendentes jframe = new ViewBoletosPendentes(getPessoa());
        
        jframe.setVisible(true);
    }//GEN-LAST:event_btnBoletosActionPerformed

    public void validarCampo(){
        PessoaDTO dto = null;
        PessoaDTO pessoa = null;
        
        if("".equals(txtCpf.getText())){
            JOptionPane.showMessageDialog(null, "Preencha o campo");
            this.btnDesativarConta.setEnabled(false);
        }else{
            dto = new PessoaDTO();
            dto.setCpfCnpj(txtCpf.getText());

            pessoa = this.service.buscarCliente(dto);
            
            if(pessoa !=null  ) 
                this.incluirInformacoesCliente(pessoa);
                this.btnDesativarConta.setEnabled(true);
                setPessoa(pessoa);
        }
       
    }
    
    public void incluirInformacoesCliente(PessoaDTO pessoa){
        txtCpf.setText(pessoa.getCpfCnpj());
        txtInfo.setText(this.buildStringInfo(pessoa));
        
    }
    
    public String buildStringInfo(PessoaDTO pessoa){
        StringBuilder info = new StringBuilder();

        
        info.append("Nome : " + pessoa.getNome())
                .append("\nCPF/CNPJ : " + pessoa.getCpfCnpj())
                .append("\nRG : " + pessoa.getRg())
                .append("\nTel: " + pessoa.getTelefone())
                .append("\nEndereco : " + pessoa.getEndereco());
        
        
        return info.toString();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoletos;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnDesativarConta;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }
}
