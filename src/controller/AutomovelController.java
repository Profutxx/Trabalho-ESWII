package controller;

import DAO.DAOAutomovel;
import model.Automovel;

public class AutomovelController {

    public int CadastrarAutomovel(Automovel aAutomovel){
        return new DAOAutomovel().salvarAutomovel(aAutomovel);
    }
}
