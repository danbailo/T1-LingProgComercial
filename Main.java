/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho_LPC;

import java.sql.*;

/**
 *
 * @author daniel
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        PostgreSQL database = new PostgreSQL();
        Connection conn = database.connect("localhost", "supermercado", "postgres", "root");   
        new Menu(conn);
    }
}
