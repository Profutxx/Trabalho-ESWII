package DAO;

import conexoes.ConexaoMySql;
import model.Cliente;
import model.Compra;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAORelatorios {

    public List<Cliente> clientesRealizaramCompra() throws SQLException {

        List<model.Cliente> clientes = new ArrayList<model.Cliente>();
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM CLIENTE  \n" +
                "WHERE EXISTS (SELECT 1 FROM COMPRA WHERE COMPRA.idCliente = CLIENTE.idCliente)");

        while(rs.next()){
            model.Cliente c = new model.Cliente();
            c.setIdCliente(rs.getInt("idCliente"));
            c.setCpf(rs.getString("cpf"));
            c.setNome(rs.getString("nome"));
            c.setTel(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            clientes.add(c);
        }
        return clientes;
    }

    public List<String> comprasRealizadasPeriodo(String inicio, String fim) throws SQLException {

        List<String > compras = new ArrayList<>();
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        String sql = "SELECT * FROM COMPRA " +
                "INNER JOIN CLIENTE ON (CLIENTE.IDCLIENTE = COMPRA.IDCLIENTE) " +
                "INNER JOIN FUNCIONARIO ON (FUNCIONARIO.IDFUNCIONARIO = COMPRA.IDFUNCIONARIO) " +
                "WHERE DATACOMPRA BETWEEN CONVERT(DATE_FORMAT(STR_TO_DATE('"+ inicio +"', '%d/%m/%Y'), '%Y-%m-%d'), DATETIME)"+
                "AND ADDTIME(CONVERT(DATE_FORMAT(STR_TO_DATE('"+ fim +"', '%d/%m/%Y'), '%Y-%m-%d'), DATETIME), '23:59:59')";
        ResultSet rs = stat.executeQuery(sql);

        while(rs.next()){
            compras.add("Data Compra: " + rs.getString("DATACOMPRA") + " Cliente: " +rs.getString("CLIENTE.NOME") + " Funcionário: " +rs.getString("FUNCIONARIO.NOME") + " Valor Compra: " +rs.getString("VALORCOMPRA") + " Forma de Pagamento: " +rs.getString("FORMAPAGAMENTO")+"\n\n");
        }
        return compras;
    }

    public List<Produto> produtosAbaixoEstoqueMin() throws SQLException{
        List<Produto> produtos = new ArrayList<Produto>();
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM PRODUTO WHERE qntEstoque < estoqueMin");

        while(rs.next()){
            Produto p = new Produto();
            p.setDescricao(rs.getString("descricao"));
            p.setQntEstoque(rs.getInt("qntEstoque"));
            p.setEstoqueMin(rs.getInt("estoqueMin"));
            produtos.add(p);
        }
        return produtos;
    }

    public List<String> folhaDePagamento() throws SQLException{
        List<String > folha = new ArrayList<>();
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        String sql = "SELECT \n" +
                "FUNCIONARIO.IDFUNCIONARIO\n" +
                ",FUNCIONARIO.NOME\n" +
                ",SUM(VALORCOMPRA) 'valorCompra'\n" +
                ", CASE MONTH(DATACOMPRA)\n" +
                "\tWHEN 1 THEN 'JANEIRO'\n" +
                "    WHEN 2 THEN 'FEVEREIRO'\n" +
                "    WHEN 12 THEN 'MARÇO'\n" +
                "    WHEN 12 THEN 'ABRIL'\n" +
                "    WHEN 12 THEN 'MAIO'\n" +
                "    WHEN 12 THEN 'JUNHO'\n" +
                "    WHEN 12 THEN 'JULHO'\n" +
                "    WHEN 12 THEN 'AGOSTO'\n" +
                "    WHEN 12 THEN 'SETEMBRO'\n" +
                "    WHEN 12 THEN 'OUTUBRO'\n" +
                "    WHEN 12 THEN 'NOVEMBRO'\n" +
                "\tWHEN 12 THEN 'DEZEMBRO'\n" +
                "END DATACOMPRA\n" +
                "FROM COMPRA \n" +
                "INNER JOIN FUNCIONARIO ON (FUNCIONARIO.IDFUNCIONARIO = COMPRA.IDFUNCIONARIO) \n" +
                "GROUP BY FUNCIONARIO.NOME,FUNCIONARIO.IDFUNCIONARIO,MONTH(DATACOMPRA);";
        ResultSet rs = stat.executeQuery(sql);

        while(rs.next()){
            float salario = 1;
            float totalCompras = rs.getInt("valorCompra");

            if(totalCompras < 10000){
                salario = (float) (totalCompras * 1.05);
            }
            else{
                salario = (float) (totalCompras * 1.07);
            }

            folha.add("Funcionario: "+rs.getString("nome")+" Total de Vendas: "+rs.getInt("valorCompra")+" Salario: "+ salario+"\n\n");

        }
        return folha;
    }
}
