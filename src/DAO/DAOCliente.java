package DAO;

import conexoes.ConexaoMySql;
import model.Cliente;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente {

//    private Connection con;

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

    public List<Cliente> listar() throws SQLException {

        List<Cliente> clientes = new ArrayList<Cliente>();
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("select * from cliente");

        while(rs.next()){
            Cliente c = new Cliente();
            c.setCpf(rs.getString("cpf"));
            c.setNome(rs.getString("nome"));
            c.setTel(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            clientes.add(c);
        }
        return clientes;
    }
}
