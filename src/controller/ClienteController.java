package controller;

import DAO.DAOCliente;
import model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteController {

    public int salvarCliente(Cliente cCliente){
        return new DAOCliente().salvarCliente(cCliente);
    }
    public boolean excluirCliente(Cliente cCliente){
        return new DAOCliente().excluirCliente(cCliente);
    }
    public List<Cliente> listarCliente() throws SQLException {
        DAOCliente dao = new DAOCliente();
        List<Cliente> clientes = dao.listar();
        return clientes;
    }
}
