package view.Compra;

import controller.ClienteController;
import controller.CompraController;
import controller.FuncionarioController;
import controller.ProdutoController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CompraView extends JFrame {
    private JComboBox comboBoxCliente;
    private JComboBox comboBoxFuncionario;
    private JComboBox comboBoxPagamento;
    private JButton realizarCompraButton;
    private JPanel MenuForm;
    private JComboBox comboBoxProdutos;
    private JList listaDeProdutos;
    private JButton adicionarButton;
    private JTextField quantidadeTextField;
    private JTextField subTotalProdutosField;
    private JTextField descontoField;
    private JTextField totalProdutosField;
    private JSpinner parcelasField;
    private JSpinner qntProduto;
    float totalProdutosFloat = 0;



    public CompraView() {
        add(MenuForm);

        setTitle("Sistema de Loja");
        setSize(600, 700);

        Compra compra = new Compra();

        parcelasField.setValue(1);
        parcelasField.setEnabled(false);
        SpinnerModel modeloSpinner = new SpinnerNumberModel(1,1,3,1);
        parcelasField.setModel(modeloSpinner);


        DefaultListModel modelo_da_lista = new DefaultListModel();


        //Listando Clientes
        ClienteController controleCliente = new ClienteController();
        try {
            List<Cliente> listClientes = controleCliente.listarCliente();
            String[] listaClientes = new String[listClientes.size()];
            int i = 0;

            for (Cliente c : listClientes) {
                comboBoxCliente.addItem(c.getNome());
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //Listando Funcionários
        FuncionarioController controleFuncionario = new FuncionarioController();

        try {
            List<Funcionario> listFuncionarios = controleFuncionario.listarFuncionarios();
            String[] listaFuncionarios = new String[listFuncionarios.size()];
            int i = 0;

            for (Funcionario f : listFuncionarios) {
                comboBoxFuncionario.addItem(f.getNome());
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Listando Funcionários
        ProdutoController controleProduto = new ProdutoController();

        try {
            List<Produto> listProdutos = controleProduto.listarProdutos();
            String[] listaProdutos = new String[listProdutos.size()];
            int i = 0;

            for (Produto p : listProdutos) {
                comboBoxProdutos.addItem(p.getDescricao());
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        realizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                Funcionario funcionario = new Funcionario();

                // Cliente
                try {
                    List<Cliente> listClientes = controleCliente.listarCliente();
                    String[] listaClientes = new String[listClientes.size()];
                    int i = 0;
                    int index = comboBoxCliente.getSelectedIndex();


                    for (Cliente c : listClientes) {
                        if (index == i){
                            compra.setCliente(c);
                        }
                        i++;
                    }
                } catch (SQLException c) {
                    c.printStackTrace();
                }

                // Funcionário
                try {
                    List<Funcionario> listFuncionarios = controleFuncionario.listarFuncionarios();
                    String[] listaFuncionarios = new String[listFuncionarios.size()];
                    int i = 0;
                    int index = comboBoxFuncionario.getSelectedIndex();


                    for (Funcionario f : listFuncionarios) {
                        if (index == i){
                            compra.setFuncionario(f);
                        }
                        i++;
                    }
                } catch (SQLException c) {
                    c.printStackTrace();
                }

                //Forma de Pagamento

                compra.setFormaPagamento(comboBoxPagamento.getSelectedItem()+"");

                //Parcelas

                compra.setParcelas((Integer) parcelasField.getValue());

                // Compra Valor

                compra.setValorCompra(Float.parseFloat(totalProdutosField.getText()));

                // Enviar Controller
                CompraController controle = new CompraController();
                controle.SalvarCompra(compra);
                dispose();

            }


        });



        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBoxProdutos.getSelectedIndex();

                try {
                    List<Produto> listProdutos = controleProduto.listarProdutos();
                    String[] listaProdutos = new String[listProdutos.size()];
                    int i = 0;


                    for (Produto p : listProdutos) {
                        if (index == i) {
                            modelo_da_lista.addElement(quantidadeTextField.getText() + "x " + p.getDescricao() + " Valor Unidade: " + p.getValor() + " Total: " + String.valueOf(Integer.parseInt(quantidadeTextField.getText()) * p.getValor()));
                            listaDeProdutos.setModel(modelo_da_lista);
                            totalProdutosFloat += (Integer.parseInt(quantidadeTextField.getText()) * p.getValor());
                            subTotalProdutosField.setText(String.valueOf(totalProdutosFloat));
                            float desconto;
                            CompraProduto compraProduto = (new CompraProduto(p,Integer.parseInt(quantidadeTextField.getText())));
                            compra.addProduto(compraProduto);

                            if(totalProdutosFloat > 1000){
                                desconto = totalProdutosFloat/100*5;
                            }
                            else{
                                desconto = totalProdutosFloat/100*3;
                            }


                            descontoField.setText(String.valueOf(desconto));
                            totalProdutosField.setText(String.valueOf(totalProdutosFloat-desconto));

                            if(totalProdutosFloat-desconto > 500 && comboBoxPagamento.getSelectedIndex() == 1){
                                parcelasField.setEnabled(true);
                            }

                        }
                        i++;
                    }
                } catch (SQLException a) {
                    a.printStackTrace();
                }
            }
        });


        comboBoxPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxPagamento.getSelectedIndex() == 0){
                    parcelasField.setEnabled(false);
                    parcelasField.setValue(1);
                }
                else if(Float.parseFloat(totalProdutosField.getText()) > 500){
                    parcelasField.setEnabled(true);
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MenuForm = new JPanel();
        MenuForm.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(11, 3, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Realizar Compra");
        MenuForm.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(308, 16), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Cliente");
        MenuForm.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(308, 16), null, 0, false));
        comboBoxCliente = new JComboBox();
        MenuForm.add(comboBoxCliente, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Funcionario");
        MenuForm.add(label3, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(308, 16), null, 0, false));
        comboBoxFuncionario = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        comboBoxFuncionario.setModel(defaultComboBoxModel1);
        MenuForm.add(comboBoxFuncionario, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Produtos");
        MenuForm.add(label4, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(308, 16), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Forma de Pagamento");
        MenuForm.add(label5, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(308, 16), null, 0, false));
        comboBoxPagamento = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Dinheiro");
        defaultComboBoxModel2.addElement("Cartão de Crédito");
        comboBoxPagamento.setModel(defaultComboBoxModel2);
        MenuForm.add(comboBoxPagamento, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        realizarCompraButton = new JButton();
        realizarCompraButton.setText("Realizar Compra");
        MenuForm.add(realizarCompraButton, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxProdutos = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        comboBoxProdutos.setModel(defaultComboBoxModel3);
        MenuForm.add(comboBoxProdutos, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(308, 30), null, 0, false));
        listaDeProdutos = new JList();
        MenuForm.add(listaDeProdutos, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        adicionarButton = new JButton();
        adicionarButton.setText("Adicionar");
        MenuForm.add(adicionarButton, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        quantidadeTextField = new JTextField();
        quantidadeTextField.setText("Quantidade");
        MenuForm.add(quantidadeTextField, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MenuForm;
    }

}
