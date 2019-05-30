/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho_LPC;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class Menu {
    JFrame f=new JFrame("Menu de Opções");
    JButton insert_product = new JButton ("Cadastrar Produto");
    JButton query_product = new JButton ("Consultar Produto");
    JButton quit = new JButton ("Sair");
    private Connection conn;
	    
    Menu(Connection conn){
        this.conn = conn;
        Container c= f.getContentPane();
        c.setLayout(new GridLayout(3,1));
        c.add(insert_product);
        c.add(query_product);
        c.add(quit);
        f.setDefaultCloseOperation(0);
        f.setSize(200,150);
        f.setBounds(150,200,200,150);
        f.setVisible(true);	       	        	
        insert_product.addActionListener(new FuncBot());              	
        query_product.addActionListener(new FuncBot());         	
        quit.addActionListener(new FuncBot());         	
    }
    
    class FuncBot implements ActionListener{    
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == insert_product) new InsertProduct(conn);
            if (e.getSource() == query_product) new QueryProduct(conn);
            if (e.getSource() == quit) System.exit(0);
        }	          
    }     
}
