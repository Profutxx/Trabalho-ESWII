package view.Relatorios;

import controller.RelatorioController;
import model.Cliente;
import model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProdutosAbaixoEstoqueMinView extends JFrame{
    private JPanel MenuForm;
    private JButton listarProdutosButton;
    private JTextArea textArea1;

    public ProdutosAbaixoEstoqueMinView() {

        add(MenuForm);

        setTitle("Sistema de Loja");
        setSize(600, 700);


        listarProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RelatorioController controle = new RelatorioController();

                try {
                    List<Produto> listProdutos = controle.produtosAbaixoEstoqueMin();
                    String[] listaProdutos = new String[listProdutos.size()];
                    int i = 0;

                    for (Produto c : listProdutos) {
                        listaProdutos[i] = "Descrição:" + c.getDescricao() + " Quantidade em Estoque:" + c.getQntEstoque() + " Quantidade Minima:" + c.getEstoqueMin() + "\n\n";
                        i++;
                    }
                    textArea1.setText(Arrays.toString(listaProdutos).replace("[", "").replace(",", "").replace("]",""));
                } catch (SQLException g) {
                    g.printStackTrace();
                }
            }
        });
    }
}
