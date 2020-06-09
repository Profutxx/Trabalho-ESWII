package DAO;

import conexoes.ConexaoMySql;
import model.Locacao;

public class DAOLocacao {

    public int salvarlocacao(Locacao locacao) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "INSERT INTO locacao (DATA_LOCACAO,HORA_LOCACAO,DATA_DEVOLUCAO,HORA_DEVOLUCAO,QUILOMETRAGEM,VALOR_CALCAO,VALOR_LOCACAO,DEVOLVIDO) VALUES("
                            + "DATE_FORMAT(STR_TO_DATE('" + locacao.getDataLocacao() + "', '%d/%m/%Y'), '%Y-%m-%d'),"
                            + "'" + locacao.getHoraLocacao() + "',"
                            + "DATE_FORMAT(STR_TO_DATE('" + locacao.getDataDevolucao() + "', '%d/%m/%Y'), '%Y-%m-%d'),"
                            + "'" + locacao.getHoraDevolucao() + "',"
                            + "'" + locacao.getQuilometragem() + "',"
                            + "'" + locacao.getValorCalcao() + "',"
                            + "'" + locacao.getValorLocacao() + "',"
                            + "'" + locacao.getDevolvido() + "'"
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
