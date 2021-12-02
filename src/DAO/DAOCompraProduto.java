package DAO;

import conexoes.ConexaoMySql;
import model.CompraProduto;


public class DAOCompraProduto {

    public int salvarCompraProduto(CompraProduto compraProduto) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "INSERT INTO itensCompra (idCompra,idProduto,qntProduto) VALUES("
                            + "(SELECT MAX(idCompra) FROM COMPRA),"
                            + "" + compraProduto.getProduto().getIdProduto() + ","
                            + "" + compraProduto.getQntProduto() + ""
                            + ");";

            return conexao.insertSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conexao.fecharConexao();
        }
    }

    public boolean removerQuantidadeProduto(CompraProduto compraProduto){
        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql = "UPDATE PRODUTO SET qntEstoque = qntEstoque - " + compraProduto.getQntProduto()
                    + " WHERE idProduto = " + compraProduto.getProduto().getIdProduto();

            return conexao.executarUpdateDeleteSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao();
        }
    }
}
