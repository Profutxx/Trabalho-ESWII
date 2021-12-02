package view.Relatorios;

import controller.RelatorioController;
import model.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ComprasRealizadasPeriodoView extends JFrame {
    private JPanel MenuForm;
    private JTextField dataInicioField;
    private JTextField dataFimField;
    private JButton buscarButton;
    private JTextArea textArea1;

    public ComprasRealizadasPeriodoView() {

        add(MenuForm);

        setTitle("Sistema de Loja");
        setSize(600, 700);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inicio = dataInicioField.getText();
                String fim = dataFimField.getText();

                RelatorioController controle = new RelatorioController();
                try {
                    List<String> listCompras = controle.comprasRealizadasPeriodo(inicio,fim);
                    String[] listaCompras = new String[listCompras.size()];
                    int i = 0;

                    for (String s : listCompras) {
                        listaCompras[i] = s;
                        i++;
                    }
                    textArea1.setText(Arrays.toString(listaCompras).replace("[", "").replace(",", ""));
                } catch (SQLException g) {
                    g.printStackTrace();
                }
            }
        });
    }
}
