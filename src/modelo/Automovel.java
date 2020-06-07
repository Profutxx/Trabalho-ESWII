package modelo;

public class Automovel {
    private String placa;
    private String cor;
    private int portas;
    private String combustivel;
    private String quilometragem;
    private String renavam;
    private String chassi;
    private double valorLocacao;


    public void CadastrarAutomovel(String placa, String cor, int portas, String combustivel, String quilometragem, String renavam, String chassi, double valorLocacao) {
        this.placa = placa;
        this.cor = cor;
        this.portas = portas;
        this.combustivel = combustivel;
        this.quilometragem = quilometragem;
        this.renavam = renavam;
        this.chassi = chassi;
        this.valorLocacao = valorLocacao;
    }
}
