package controle;

import modelo.Cliente;
import view.ClienteView;

public class ClienteController {
    Cliente cliente = new Cliente();

    public void CadastrarCliente(String nome, String cpf, String telefone, String endereco){
        cliente.cadastrarCliente(cpf,nome,endereco,telefone);
    }

}
