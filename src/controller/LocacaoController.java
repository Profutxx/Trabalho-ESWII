package controller;

import DAO.DAOLocacao;
import model.Locacao;

public class LocacaoController {

    public int RegistrarLocacao(Locacao locacao){
        return new DAOLocacao().salvarlocacao(locacao);
    }
}
