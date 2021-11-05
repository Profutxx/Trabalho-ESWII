package DAO;

import conexoes.ConexaoMySql;
import model.Automovel;

public class DAOAutomovel {

    public int salvarAutomovel(Automovel automovel) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "INSERT INTO AUTOMOVEL (PLACA,COR,QNT_PORTAS,COMBUSTIVEL,QUILOMETRAGEM,RENAVAM,CHASSI,VALOR_LOCACAO) VALUES("
                            + "'" + automovel.getPlaca() + "',"
                            + "'" + automovel.getCor() + "',"
                            + "'" + automovel.getPortas() + "',"
                            + "'" + automovel.getCombustivel() + "',"
                            + "'" + automovel.getQuilometragem() + "',"
                            + "'" + automovel.getRenavam() + "',"
                            + "'" + automovel.getChassi() + "',"
                            + "'" + automovel.getValorLocacao() + "'"
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
