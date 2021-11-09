package controller;

import DAO.DAOCliente;
import model.Cliente;

public class ClienteController {

    public int salvarCliente(Cliente cCliente){
        return new DAOCliente().salvarCliente(cCliente);
    }
    public boolean excluirCliente(Cliente cCliente){
        return new DAOCliente().excluirCliente(cCliente);
    }
}
