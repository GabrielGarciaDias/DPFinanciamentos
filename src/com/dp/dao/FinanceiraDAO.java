package com.dp.dao;

import com.dp.dto.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinanceiraDAO {

    public LoginDTO validarLogin(LoginDTO dto) throws SQLException {

        String sql = "select LOGINid, LOGIN, NOME, CPF, EMAIL, SENHA, TIPOUSER"
                + " FROM LOGIN "
                + " WHERE LOGIN = ? AND SENHA = ? ";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LoginDTO login = null;
        try {
            con = Connect.getConnection();
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();

            while(rs.next()){
               login = new LoginDTO();
                
                login.setCpf(rs.getString("CPF"));
                login.setEmail(rs.getString("EMAIL"));
                login.setLogin(rs.getString("LOGIN"));
                login.setLoginID(rs.getInt("LOGINID"));
                login.setNome(rs.getString("NOME"));
                login.setSenha(rs.getString("SENHA"));
                login.setTipoUser(rs.getInt("TIPOUSER"));
                
                
            }
         
        } catch (SQLException e) {
           
        } finally {
            con.close();
        }
        return login;
    }
}
