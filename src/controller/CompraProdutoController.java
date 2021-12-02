package controller;

import model.CompraProduto;
import DAO.DAOCompraProduto;

public class CompraProdutoController {

    public int salvarCompraProduto(CompraProduto compraProduto){
        return new DAOCompraProduto().salvarCompraProduto(compraProduto);
    }

    public boolean removerQuantidadeProduto(CompraProduto compraProduto){
        return new DAOCompraProduto().removerQuantidadeProduto(compraProduto);
    }
}
