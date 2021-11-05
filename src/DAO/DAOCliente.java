package DAO;

import conexoes.ConexaoMySql;
import model.Cliente;

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
}
