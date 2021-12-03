package view.Relatorios;

import controller.RelatorioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class FolhaDePagamento extends JFrame{
    private JButton gerarFolhaDePagamentoButton;
    private JTextArea textArea1;
    private JPanel MenuForm;

    public FolhaDePagamento() {

        add(MenuForm);

        setTitle("Sistema de Loja");
        setSize(600, 700);


        gerarFolhaDePagamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RelatorioController controle = new RelatorioController();

                try {
                    List<String> listFolha = controle.folhaDePagamento();
                    String[] listaFolha = new String[listFolha.size()];
                    int i = 0;

                    for (String s : listFolha) {
                        listaFolha[i] = s;
                        i++;
                    }
                    textArea1.setText(Arrays.toString(listaFolha).replace("[", "").replace(",", "").replace("]",""));
                } catch (SQLException g) {
                    g.printStackTrace();
                }
            }
        });
    }
}
