package DAO;

import conexoes.ConexaoMySql;
import model.Compra;

public class DAOCompra {

    public int SalvarCompra(Compra compra){

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "INSERT INTO COMPRA (idCliente,idFuncionario,valorCompra,formaPagamento,parcelas,dataCompra) VALUES("
                            + "'" + compra.getCliente().getIdCliente() + "',"
                            + "'" + compra.getFuncionario().getIdFuncionario() + "',"
                            + "'" + compra.getValorCompra() + "',"
                            + "'" + compra.getFormaPagamento() + "',"
                            + "'" + compra.getParcelas() + "',"
                            + "now()"
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
