package controller;

import DAO.DAOCliente;
import model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteController {

    public int salvarCliente(Cliente cCliente){
        return new DAOCliente().salvarCliente(cCliente);
    }
    public boolean excluirCliente(String cpf){
        return new DAOCliente().excluirCliente(cpf);
    }
    public List<Cliente> listarCliente() throws SQLException {
        DAOCliente dao = new DAOCliente();
        List<Cliente> clientes = dao.listar();
        return clientes;
    }
    public Cliente buscarCliente(String cpf) throws SQLException{
        DAOCliente dao = new DAOCliente();
        Cliente cliente = dao.getByCpf(cpf);
        return cliente;
    }
}
