package DAO;

import conexoes.ConexaoMySql;
import model.CompraProduto;


public class DAOCompraProduto {

    public int SalvarCompraProduto(CompraProduto compraProduto) {

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
}
