package model;

public class CompraProduto {

    Produto produto;
    int qntProduto;

    public CompraProduto(Produto produto,int qntProduto) {
        this.produto = produto;
        this.qntProduto = qntProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQntProduto() {
        return qntProduto;
    }

    public void setQntProduto(int qntProduto) {
        this.qntProduto = qntProduto;
    }
}
