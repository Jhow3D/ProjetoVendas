/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author jonat
 */
public class ClientesDao {

    private Connection con;

//cliando objeto para conexão do banco de dados
    public ClientesDao() {
        this.con = new ConnectionFactory().getConnection();

    }

    //Método cadastrar clientes
    public void cadastrarCliente(Clientes obj) {

        try {
            //Comando sql de inserir informações 
            String sql = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //Conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); // comoando para iniciar a o codigo SQL 
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereço());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            // Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    // Método alterar cliente 
    public void alterarCliente(Clientes obj) {
        try {
            //Comando sql de inserir informações 
            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,"
                    + "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id =?";
            //Conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); // comoando para iniciar a o codigo SQL 
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereço());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14,obj.getId());

            // Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

// Método Excluir cliente 
    public void excluirCliente(Clientes obj) {
        try {
            //Comando sql de inserir informações 
            String sql = "delete from tb_clientes where id = ?";
            //Conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); // comoando para iniciar a o codigo SQL 
            stmt.setInt(1, obj.getId());
            

            // Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

// Método listar todos os clientes
    public List<Clientes> listarCliente() {

        try {

            // criando a lista
            List<Clientes> lista = new ArrayList<>();

            //criando o comando SQL, organizar e executar
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);

            // objeto para armazenar a lista do sql     
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereço(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro" + e);
            return null;
        }

    }
// Metodo buscar cliente por nome 
    public List<Clientes> buscarCliente(String nome) {

        try {

            // criando a lista
            List<Clientes> lista = new ArrayList<>();

            //criando o comando SQL, organizar e executar
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            // objeto para armazenar a lista do sql     
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereço(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro" + e);
            return null;
        }
    }

    // buscar por CEP 
    public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereço(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descri��o do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
  
}
