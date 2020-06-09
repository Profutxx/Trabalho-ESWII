package controller;

import view.ClienteView;
import view.MenuView;

public class MenuController {
    public static void main(String[] args){
        MenuView myMenuForm = new MenuView();
        ClienteView myClienteForm = new ClienteView();
        myMenuForm.setVisible(true);

    }

}
