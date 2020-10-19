/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.dao;

/**
 *
 * @author igors
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class  Connect {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static  String caminho = "jdbc:sqlserver://localhost:1433;databaseName=DPFinanciamentos"; // O "control" representa a minha database 
    private static  String usuario = "sa";
    private static  String senha = "P@ssw0rdM0del0";
   
    
    public static Connection  getConnection() { // Metodo responsavel por realizar a conexão;
       Connection con = null;
        try {
            System.setProperty("jdbc.Drivers", driver); // Seta a propriedade do driver de conexão;
            con = DriverManager.getConnection(caminho, usuario, senha); // Realiza a conexão com o banco;
         
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
        return con;
    }
    

}