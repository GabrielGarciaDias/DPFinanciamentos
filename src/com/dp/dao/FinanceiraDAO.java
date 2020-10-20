package com.dp.dao;

import com.dp.dto.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinanceiraDAO {

    public LoginDTO validarLogin(LoginDTO dto) throws SQLException {

        String sql = "select LOGINid, LOGIN, NOME, CPF, EMAIL, SENHA, TIPOUSER"
                + " FROM DPFinanciamentos.dbo.LOGIN "
                + " WHERE LOGIN = ? AND SENHA = ? ";
        Connection con = null;
        PreparedStatement ps = null;
        
        LoginDTO login = null;
        int i = 1;
        try {
            con = Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(i++, dto.getLogin());
            ps.setString(i++, dto.getSenha());
            ResultSet rs = ps.executeQuery();

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
           System.out.println("Erro: " + e);
        } finally {
            con.close();
        }
        return login;
    }
}
