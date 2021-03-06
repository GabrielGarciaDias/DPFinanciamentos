/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.service;

import com.dp.dao.FinanceiraDAO;
import com.dp.dto.BoletoDTO;
import com.dp.dto.LoginDTO;
import com.dp.dto.PessoaDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igors
 */
public class ServiceImpl {
    FinanceiraDAO dao = new FinanceiraDAO();
    
    public LoginDTO validarLogin(LoginDTO loginDTO) {
        LoginDTO dto = null;
        
        try { 
            dto = this.dao.validarLogin(loginDTO);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return dto;
    }
    
    public PessoaDTO buscarCliente(PessoaDTO pessoaDTO){
        PessoaDTO dto = null;
        
        try{
            dto = this.dao.buscarCliente(pessoaDTO);
        }catch(SQLException ex){
            Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dto;
    }
 
    public void desativarConta(String numeroDocumento, String motivo){
        try{
            this.dao.desativarConta(numeroDocumento, motivo);
        }catch(SQLException ex){
            Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<BoletoDTO> buscarBoleto(PessoaDTO pessoa, String filtro)  {
        List<BoletoDTO> listaBoleto = new ArrayList<>();
        try {
            listaBoleto = this.dao.carregarBoletos(pessoa,filtro);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaBoleto;
    }
    
    public BoletoDTO buscarBoletoPorId(Long idBoleto){
        BoletoDTO boleto = new BoletoDTO();
        
        try{
            boleto = this.dao.buscarBoletoPorId(idBoleto);
        }catch (SQLException ex) {
            Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return boleto;
    }
}
