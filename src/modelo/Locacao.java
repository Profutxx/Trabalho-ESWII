package modelo;

public class Locacao {
    private String dataLocacao;
    private String horaLocacao;
    private String dataDevolucao;
    private String horaDevolucao;
    private long quilometragem;
    private double valorCalcao;
    private double valorLocacao;
    private int devolvido;


    public void registrarLocacao(String dataLocacao, String horaLocacao, String dataDevolucao, String horaDevolucao, long quilometragem, double valorCalcao, double valorLocacao, int devolvido) {
        this.dataLocacao = dataLocacao;
        this.horaLocacao = horaLocacao;
        this.dataDevolucao = dataDevolucao;
        this.horaDevolucao = horaDevolucao;
        this.quilometragem = quilometragem;
        this.valorCalcao = valorCalcao;
        this.valorLocacao = valorLocacao;
        this.devolvido = devolvido;
    }
}
