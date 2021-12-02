package view.Relatorios;

import controller.RelatorioController;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ClientesRealizaramCompraView extends JFrame {
    private JTextArea listClientesArea;
    private JButton listarClientesQueRealizaramButton;
    private JPanel MenuForm;

    public ClientesRealizaramCompraView() {
        add(MenuForm);

        setTitle("Sistema de Loja");
        setSize(600, 700);


        listarClientesQueRealizaramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RelatorioController controle = new RelatorioController();
                try{
                    List<Cliente> listClientes = controle.clientesRealizaramCompra();
                    String[] listaClientes = new String[listClientes.size()];
                    int i = 0;

                    for (Cliente c : listClientes) {
                        listaClientes[i] = "\n- Cliente " + (i + 1) + "\n" + "Nome:" + c.getNome() + " CPF:" + c.getCpf() + " Telefone:" + c.getTel() + " Endereço: " + c.getEndereco();
                        i++;
                    }
                    listClientesArea.setText(Arrays.toString(listaClientes).replace("[", "").replace(",", ""));
                } catch (SQLException f) {
                    f.printStackTrace();
                }

                }

            }
        );
    }
}
