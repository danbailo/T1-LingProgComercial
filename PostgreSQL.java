/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho_LPC;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class PostgreSQL {
    Connection connect(String serverName, String database_name, String username, String password) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://"+serverName+":5432/"+database_name,username,password);            
            JOptionPane.showMessageDialog(null,"Conectado ao banco de dados com sucesso!");
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar ao banco, verifique seus dados e tente novamente!\n"+err.getMessage());
            System.exit(0);
        }
        catch(ClassNotFoundException err){ 
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar ao banco, verifique seus dados e tente novamente!\n"+err.getMessage());
            System.exit(0);            
        }
        return conn;
    }    
}
