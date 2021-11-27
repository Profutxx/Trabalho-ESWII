package controller;

import view.Cliente.ClienteView;
import view.MenuView;

import java.sql.SQLException;

public class MenuController {
    public static void main(String[] args) throws SQLException {
        MenuView myMenuForm = new MenuView();
        ClienteView myClienteForm = new ClienteView();
        myMenuForm.setVisible(true);

    }

}
