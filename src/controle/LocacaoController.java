package controle;

import modelo.Locacao;

public class LocacaoController {
    Locacao locacao = new Locacao();

    public void RegistrarLocacao(String dataLocacao, String horaLocacao, String dataDevolucao, String horaDevolucao, long quilometragem, double valorCalcao, double valorLocacao, String devolvido){
        locacao.registrarLocacao(dataLocacao,horaLocacao,dataDevolucao,horaDevolucao,quilometragem,valorCalcao,valorLocacao,devolvido);
    }
}
