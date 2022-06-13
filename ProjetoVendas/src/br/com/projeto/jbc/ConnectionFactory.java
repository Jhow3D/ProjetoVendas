/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author jonat
 */
public class ConnectionFactory {

    private Connection con;
    private Statement s;

    public Connection getConnection() {
        /**
         * try { return
         * DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true","root","88280053");
         * } catch (Exception erro) { throw new RuntimeException(erro);
         *
         * }*
         */
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("CONEXÃO ABERTA...");
                return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "88280053");
                
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        return null;
         
    }

    public void desconectar() {
        if (con != null) {
            try {
                if (s != null) {
                    s.close();
                    s = null;
                }
                con.close();
                System.out.println("CONEXÃO FECHADA...");
            } catch (Exception e) {
                //EM CASO DE ERRO
                System.out.println("Error desconectar : " + e);
            }
        }
    }

    /* metodo que faz conexao com o banco de dados

retorna true se houve sucesso, ou false em caso negativo
     */
}
