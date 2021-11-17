package controller;

import DAO.DAOCliente;
import model.Cliente;
import view.ClienteView;
import view.MenuView;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    public static void main(String[] args) throws SQLException {
        MenuView myMenuForm = new MenuView();
        ClienteView myClienteForm = new ClienteView();
        myMenuForm.setVisible(true);


    }

}
