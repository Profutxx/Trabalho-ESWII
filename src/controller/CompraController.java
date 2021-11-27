package controller;

import model.Compra;
import DAO.DAOCompra;
import model.CompraProduto;
import controller.CompraProdutoController;

import java.sql.SQLException;

public class CompraController {

    public int SalvarCompra(Compra compra){

        new DAOCompra().SalvarCompra(compra);
        CompraProdutoController controle = new CompraProdutoController();

        for(CompraProduto cp : compra.getCompraProduto()){
            controle.SalvarCompraProduto(cp);
        }
        return 0;
    }
}
