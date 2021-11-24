package controller;

import DAO.DAOProduto;
import model.Produto;

import java.sql.SQLException;
import java.util.List;

public class ProdutoController {

    public int salvarProduto(Produto produto){
        return new DAOProduto().SalvarProduto(produto);
    }

    public List<Produto> listarProdutos() throws SQLException{
        DAOProduto dao = new DAOProduto();
        List<Produto> produtos = dao.listar();
        return produtos;
    }
}
