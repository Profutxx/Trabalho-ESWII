package controller;

import model.CompraProduto;
import DAO.DAOCompraProduto;

import java.sql.SQLException;

public class CompraProdutoController {

    public int SalvarCompraProduto(CompraProduto compraProduto){
        return new DAOCompraProduto().SalvarCompraProduto(compraProduto);
    }
}
