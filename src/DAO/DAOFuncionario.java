package DAO;

import conexoes.ConexaoMySql;
import model.Funcionario;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFuncionario {

    public int salvarFuncionario(Funcionario funcionario) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "INSERT INTO FUNCIONARIO (matricula,salariobase,nome,endereco,telefone,cpf) VALUES("
                            + "'" + funcionario.getMatricula() + "',"
                            + "'" + funcionario.getSalarioBase() + "',"
                            + "'" + funcionario.getNome() + "',"
                            + "'" + funcionario.getEndereco() + "',"
                            + "'" + funcionario.getTelefone() + "',"
                            + "'" + funcionario.getCpf() + "'"
                            + ");";

            return conexao.insertSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conexao.fecharConexao();
        }

    }

    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();

        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("select * from funcionario");

        while(rs.next()){
            Funcionario f = new Funcionario();
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setCpf(rs.getString("cpf"));
            f.setNome(rs.getString("nome"));
            funcionarios.add(f);
        }
        return funcionarios;
    }
}
