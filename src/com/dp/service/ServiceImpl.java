/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.service;

import com.dp.dao.FinanceiraDAO;
import com.dp.dto.LoginDTO;
import java.sql.SQLException;
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
}
