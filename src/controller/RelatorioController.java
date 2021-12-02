package controller;

import DAO.DAORelatorios;
import model.Cliente;
import model.Compra;
import model.Produto;

import java.sql.SQLException;
import java.util.List;

public class RelatorioController {

    public List<Cliente> clientesRealizaramCompra() throws SQLException {
        DAORelatorios dao = new DAORelatorios();
        List<Cliente> clientes = dao.clientesRealizaramCompra();
        return clientes;
    }

    public List<String> comprasRealizadasPeriodo(String inicio,String fim) throws SQLException{
        DAORelatorios dao = new DAORelatorios();
        List<String> compras = dao.comprasRealizadasPeriodo(inicio,fim);
        return compras;
    }

    public List<Produto> produtosAbaixoEstoqueMin() throws SQLException {
        DAORelatorios dao = new DAORelatorios();
        List<Produto> produtos = dao.produtosAbaixoEstoqueMin();
        return produtos;
    }
}
