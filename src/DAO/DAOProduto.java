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

    public List<Produto> listar() throws SQLException{

        List<Produto> produtos = new ArrayList<>();
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("select * from produto");

        while(rs.next()){
            Produto p = new Produto();
            p.setIdProduto(rs.getInt("idProduto"));
            p.setValor(rs.getInt("valor"));
            p.setDescricao(rs.getString("descricao"));
            p.setCodigo(rs.getInt("codigo"));
            produtos.add(p);
        }
        return produtos;
    }

}
