/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho_LPC;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author daniel
 */
public class InsertProduct extends JFrame{
	private JLabel label1, label2, label3, label4, label5, label6, label7;
	private JTextField text1, text2, text3, text4, text5, text6, text7;
	private JButton button1, button2, button3, button4;
        
        private PostgreSQL database;
        private Connection conn;
        
	public InsertProduct(Connection conn) {
            database = new PostgreSQL();
            this.conn = conn;
            
            label1 = new JLabel(" Código do Produto:");
            label2 = new JLabel(" Nome do Produto:");
            label3 = new JLabel(" Valor Pago:");
            label4 = new JLabel(" Valor Venda:");
            label5 = new JLabel(" Quantidade no Estoque:");
            label6 = new JLabel(" Unidade de Medida:");
            label7 = new JLabel(" Categoria:");
            
            text1 = new JTextField(10);
            text2 = new JTextField(10);
            text3 = new JTextField(10);
            text4 = new JTextField(10);
            text5 = new JTextField(10);
            text6 = new JTextField(10);
            text7 = new JTextField(10);
            
            button1 = new JButton("Gravar no Banco de Dados");
            button2 = new JButton("Fechar");
            button1.addActionListener(new InsertProduct.Ouvinte());
            button2.addActionListener(new InsertProduct.Ouvinte());
            text4.addActionListener(new InsertProduct.Ouvinte());
            
            Container c= getContentPane();
            c.setLayout(new GridLayout(8,2));
            
            c.add(label1); c.add(text1);
            c.add(label2); c.add(text2);
            c.add(label3); c.add(text3);
            c.add(label4); c.add(text4);
            c.add(label5); c.add(text5);
            c.add(label6); c.add(text6);
            c.add(label7); c.add(text7);
            c.add(button1); c.add(button2);
            
            setSize(500,300);
            setTitle("Cadastro de Produto");
            setLocationRelativeTo(null); 
            setVisible(true); 
        }

        private class Ouvinte implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == button1){
                    Produto p = new Produto();
                    p.setCodigo_produto(Long.parseLong(text1.getText().trim()));
                    p.setNome_produto(text2.getText().trim());
                    p.setValor_pago(Double.parseDouble(text3.getText().trim()));
                    p.setValor_venda(Double.parseDouble(text4.getText().trim()));
                    p.setQtde_estoque(Integer.parseInt(text5.getText().trim()));
                    p.setUnidade_medida(text6.getText().trim());
                    p.setCategoria(text7.getText().trim());
                    try {
                        PreparedStatement st = conn.prepareStatement("INSERT INTO produto(codigo_produto, nome_produto, valor_pago, valor_venda, "
                                + "qtde_estoque, unidade_medida, categoria) VALUES (?,?,?,?,?,?,?)");
                        st.setLong(1, p.getCodigo_produto());
                        st.setString(2, p.getNome_produto());
                        st.setDouble(3, p.getValor_pago());
                        st.setDouble(4, p.getValor_venda());
                        st.setDouble(5, p.getQtde_estoque());
                        st.setString(6, p.getUnidade_medida());
                        st.setString(7, p.getCategoria());        
                        try{
                            st.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
                        }
                        catch(SQLException err){
                            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados!\n"+err.getMessage());
                        }
                        st.close();
                    }catch(SQLException err) {
                        Logger.getLogger(InsertProduct.class.getName()).log(Level.SEVERE, null, err);
                    }
                    dispose();
                }
                else if (e.getSource() == button2) dispose();
            }	
        }     
}