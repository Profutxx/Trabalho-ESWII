package controller;

import model.Compra;
import DAO.DAOCompra;
import model.CompraProduto;

public class CompraController {

    public int SalvarCompra(Compra compra){

        new DAOCompra().SalvarCompra(compra);
        CompraProdutoController controle = new CompraProdutoController();

        for(CompraProduto cp : compra.getCompraProduto()){
            controle.salvarCompraProduto(cp);
            controle.removerQuantidadeProduto(cp);
        }
        return 0;
    }
}
