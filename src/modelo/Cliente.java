package modelo;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String tel;

    public void cadastrarCliente(String cpf, String nome, String endereco, String tel) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.tel = tel;
    }

    public void removerCliente(String nome){
        this.nome = nome;

    }
}
