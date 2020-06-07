package controle;

import modelo.Automovel;

public class AutomovelController {
    Automovel automovel = new Automovel();

    public void CadastrarAutomovel(String placa, String cor, int portas, String combustivel, String quilometragem, String renavam, String chassi, double valor){
        automovel.CadastrarAutomovel(placa,cor,portas,combustivel,quilometragem,renavam,chassi,valor);
    }
}
