package view;

import javax.swing.*;

public class ClienteView extends JFrame{
    private JTextField myNameValue;
    private JTextField myCpfValue;
    private JTextField myTelefoneValue;
    private JTextField myEnderecoValue;
    private JButton enviarButton;
    private JPanel UserForm;

    public ClienteView(){
        add(UserForm);

        setTitle("This is my Title");
        setSize(400,500);
    }
}
