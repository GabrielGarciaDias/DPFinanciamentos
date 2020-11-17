package com.dp.dao;

import com.dp.dto.BoletoDTO;
import com.dp.dto.LoginDTO;
import com.dp.dto.PessoaDTO;
import com.dp.service.ServiceImpl;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinanceiraDAO {

    public LoginDTO validarLogin(LoginDTO dto) throws SQLException {

        String sql = "select LOGINid , LOGIN , NOME , CPFCNPJ ,SENHA "
                + " FROM DPFinanciamentos.dbo.LOGIN "
                + " WHERE LOGIN = ? AND SENHA = ? AND TIPOUSER = ? ";
        Connection con = null;
        PreparedStatement ps = null;
        
        LoginDTO login = null;
        int i = 1;
        try {
            con = Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(i++, dto.getLogin());
            ps.setString(i++, dto.getSenha());
            ps.setInt(i++, Constantes.ZERO);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
               login = new LoginDTO();             
                login.setCpf(rs.getString("CPFCNPJ"));
                login.setLogin(rs.getString("LOGIN"));
                login.setLoginID(rs.getInt("LOGINID"));
                login.setNome(rs.getString("NOME"));

            }
         
        } catch (SQLException e) {
           System.out.println("Erro: " + e);
        } finally {
            con.close();
        }
        return login;
    }
    
    public PessoaDTO buscarCliente(PessoaDTO dto) throws SQLException {

        StringBuilder sql = new StringBuilder();
        
        sql.append(" select endereco.rua, endereco.numero ,CONCAT(cad.CAD_NOME ,cad.CAD_FANTASIA) as nome , ");
        sql.append(" CPFCNPJ , rgInscricao , DTN_Fundacao , EMAIL ,CELULAR ,TEL_COMERCIAL,FlAtivo");
        sql.append(" from CADASTRO cad ");
        sql.append(" INNER JOIN ENDERECO endereco ");
        sql.append(" ON endereco.CADid  = cad.CADid ");
        sql.append(" WHERE cad.CPFCNPJ LIKE ?  ");

        Connection con = null;
        PreparedStatement ps = null;
        
        PessoaDTO pessoa = null;
        int i = 1;
        try {
            con = Connect.getConnection();
            ps = con.prepareStatement(sql.toString());
            ps.setString(i++, "%" + dto.getCpfCnpj() + "%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
               pessoa = new PessoaDTO();             
               pessoa.setCpfCnpj(rs.getString("CPFCNPJ"));
               pessoa.setNome(rs.getString("nome"));
               pessoa.setRg(rs.getString("rgInscricao"));
               pessoa.setEmail(rs.getString("EMAIL"));
               pessoa.setTelefone(rs.getString("CELULAR"));
               pessoa.setFlAtivo(rs.getString("FlAtivo"));
               pessoa.setEndereco("Rua : " + rs.getString("rua") + " Numero : " + rs.getString("numero"));

            }
         
        } catch (SQLException e) {
           System.out.println("Erro: " + e);
        } finally {
            con.close();
        }
        return pessoa;
    }
    
    public void desativarConta(String numeroDocumento, String motivo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();    
        
        sql.append("UPDATE CADASTRO SET FlAtivo = ?, DsAtivo = ? WHERE CPFCNPJ = ? ");
        
        Connection con = null;
        PreparedStatement ps = null;
        int i = 1;
        
        try{
            
            con = Connect.getConnection();
            ps = con.prepareStatement(sql.toString());
            
            ps.setString(i++, Constantes.SIM);
            ps.setString(i++, numeroDocumento);
            ps.setString(i++, motivo);
            
            ps.execute();
            
        } catch (SQLException e) {
           Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            con.close();
       
        }
    }
    
     public List<BoletoDTO> carregarBoletos(PessoaDTO pessoa,String filtro) throws SQLException{
        
        StringBuilder sql = new StringBuilder();    
        
        sql.append(" SELECT BOLETOid, CAD_NOME, CPFCNPJ, ")
                .append(" PGTO_PARCELA_NUM, VALOR, CADid, DT_PGTO, DT_VENCIMENTO, Status")
                .append(" FROM BOLETOS ")
                .append(" WHERE CPFCNPJ = ? AND Status = ? ");
 
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<BoletoDTO> lista = new ArrayList<BoletoDTO>();
        BoletoDTO boleto;
        int i = 1;
        
        try{
            
            con = Connect.getConnection();
            ps = con.prepareStatement(sql.toString());
            ps.setString(i++, pessoa.getCpfCnpj());
            ps.setString(i++, filtro);
            rs = ps.executeQuery();
            
            
            while(rs.next()){
                boleto = new BoletoDTO();
                
                boleto.setCpf(rs.getString("CPFCNPJ"));
                boleto.setDtPagamento(rs.getDate("DT_PGTO"));
                boleto.setDtVencimento(rs.getDate("DT_VENCIMENTO"));
                boleto.setNome(rs.getString("CAD_NOME"));
                boleto.setStatus(rs.getString("Status"));
                boleto.setCodigoBoleto(rs.getLong("BoletoID"));
                
                lista.add(boleto);
            }
           
        } catch (SQLException e) {
           Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            con.close();
        }
        
        return lista;
    }
     
     
     public BoletoDTO buscarBoletoPorId(Long idBoleto)throws SQLException{
         
          StringBuilder sql = new StringBuilder();    
        
        sql.append(" SELECT BOLETOid, CAD_NOME, CPFCNPJ, ")
                .append(" PGTO_PARCELA_NUM, VALOR, CADid, DT_PGTO, DT_VENCIMENTO, Status")
                .append(" FROM BOLETOS ")
                .append(" WHERE BOLETOid = ? ");
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
   
        BoletoDTO boleto  = new BoletoDTO();;
        int i = 1;
         
        try{
            
            con = Connect.getConnection();
            ps = con.prepareStatement(sql.toString());
            ps.setLong(i++, idBoleto);
 
            rs = ps.executeQuery();
            
            
            while(rs.next()){
                
                
                boleto.setCpf(rs.getString("CPFCNPJ"));
                boleto.setDtPagamento(rs.getDate("DT_PGTO"));
                boleto.setDtVencimento(rs.getDate("DT_VENCIMENTO"));
                boleto.setNome(rs.getString("CAD_NOME"));
                boleto.setStatus(rs.getString("Status"));
                boleto.setCodigoBoleto(rs.getLong("BoletoID"));
                
               
            }
           
        } catch (SQLException e) {
           Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            con.close();
        }
        
        return boleto;
     }


}
