package model;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    Cliente cliente;
    Funcionario funcionario;
    int idCompra,parcelas;
    float valorCompra;
    String formaPagamento,dataCompra;
    List<CompraProduto> compraProduto = new ArrayList<>();

    public Compra(){};

    public List<CompraProduto> getCompraProduto() {
        return compraProduto;
    }

    public void setCompraProduto(List<CompraProduto> compraProduto) {
        this.compraProduto = compraProduto;
    }

    public void addProduto(CompraProduto produto){
        this.compraProduto.add(produto);
    }

    public model.Cliente getCliente() {
        return cliente;
    }

    public void setCliente(model.Cliente cliente) {
        this.cliente = cliente;
    }

    public model.Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(model.Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }
}
