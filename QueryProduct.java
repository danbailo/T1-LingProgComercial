/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho_LPC;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author daniel
 */
class QueryProduct extends JFrame{

    JTextArea text1 = new JTextArea(25,25);
    JScrollPane scroll = new JScrollPane(text1);

    JButton Fechar = new JButton("Fechar");
    JButton BotCarregarDados = new JButton("Carregar Dados");		
    JButton Limpar = new JButton("Limpar");
		
    JLabel labelVenda = new JLabel("Valor de Venda:");
    JTextField textVenda = new JTextField(10);		

    private PostgreSQL database;
    private Connection conn;

    QueryProduct(Connection conn){
        database = new PostgreSQL();
        this.conn = conn;
        
        Container c = getContentPane();
        FlowLayout layout = new FlowLayout();
        c.setLayout(layout);
        layout.setAlignment(FlowLayout.CENTER);

        Fechar.addActionListener(new TrataBotaoFechar());
        BotCarregarDados.addActionListener(new Proc());
        Limpar.addActionListener(new TrataBotaoLimpar());

        text1.setEditable(false);
        c.add(labelVenda);
        c.add(textVenda);                
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);        
        c.add(scroll);
        c.add(Limpar);
        c.add(BotCarregarDados);
        c.add(Fechar);

        setTitle("Consulta de Produtos Cadastrados");
        setSize (350,500);
        setVisible (true);			
    }

    class TrataBotaoFechar implements ActionListener{
        public void actionPerformed ( ActionEvent e ){dispose();}
    }

    class TrataBotaoLimpar implements ActionListener{
        public void actionPerformed ( ActionEvent e ){
            text1.setText ("");
            text1.requestFocus();		
            textVenda.setText("");
        }
    }

    class Proc implements ActionListener{
        public void actionPerformed(ActionEvent e){	   	
            String lista = "",filtro="";

            if (textVenda.getText().equals("")==false) filtro += "where valor_venda = '"+textVenda.getText()+"'";
                    
            try{
                Statement sent=conn.createStatement();
                ResultSet result = sent.executeQuery("select * From produto "+filtro+ " order by codigo_produto" );	

                while(result.next()){	
                    lista += "Código do Produto: " +result.getLong("codigo_produto");
                    lista += "\nNome do Produto: " +result.getString("nome_produto");		
                    lista += "\nValor Pago: " +result.getDouble("valor_pago");		
                    lista += "\nValor Venda: " +result.getDouble("valor_venda");
                    lista += "\nQuantidade de Estoque: " +result.getInt("qtde_estoque");
                    lista += "\nUnidade de Medida: " +result.getString("unidade_medida");
                    lista += "\nCategoria: " +result.getString("categoria");
                    lista += "\n\n";
                }
                sent.close();		
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(null, "Erro ao tentar realizar a consulta!\n"+err.getMessage());	
            }                    
            text1.setText(lista);
        }
    }
}