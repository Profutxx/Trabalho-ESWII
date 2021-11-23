package DAO;
import conexoes.ConexaoMySql;
import model.Produto;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProduto {

    public int SalvarProduto(Produto produto){

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "INSERT INTO PRODUTO (CODIGO,DESCRICAO,VALOR,QNTESTOQUE,ESTOQUEMIN,VALIDADE) VALUES("
                            + "'" + produto.getCodigo() + "',"
                            + "'" + produto.getDescricao() + "',"
                            + "'" + produto.getValor() + "',"
                            + "'" + produto.getQntEstoque() + "',"
                            + "'" + produto.getEstoqueMin() + "',"
                            + "DATE_FORMAT(STR_TO_DATE('" + produto.getValidade() + "', '%d/%m/%Y'), '%Y-%m-%d')"
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
