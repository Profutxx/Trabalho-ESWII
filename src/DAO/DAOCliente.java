package DAO;

import conexoes.ConexaoMySql;
import model.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente {

    public int salvarCliente(Cliente cliente) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "INSERT INTO CLIENTE (CPF,NOME,TELEFONE,ENDERECO) VALUES("
                            + "'" + cliente.getCpf() + "',"
                            + "'" + cliente.getNome() + "',"
                            + "'" + cliente.getTel() + "',"
                            + "'" + cliente.getEndereco() + "'"
                            + ");";

            return conexao.insertSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conexao.fecharConexao();
        }

    }

    public boolean excluirCliente(Cliente cliente) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "DELETE FROM CLIENTE WHERE cpf = "
                            + "'" + cliente.getCpf() + "';";

            return conexao.executarUpdateDeleteSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao();
        }

    }

    public List<Cliente> listar(){

        List<Cliente> clientes = new ArrayList<>();
        ConexaoMySql conexao = new ConexaoMySql();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try{
            String sql = "SELECT * FROM CLIENTE;";
            pstm = conexao.conectar().prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){

                Cliente cliente = new Cliente();

                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTel(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));

                clientes.add(cliente);
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar clientes"+e,"erro",JOptionPane.ERROR_MESSAGE);
        }finally {
            conexao.fecharConexao();
        }

        return clientes;
    }
}
