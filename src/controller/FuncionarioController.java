package controller;

import DAO.DAOFuncionario;
import model.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {

    public int salvarFuncionario(Funcionario fFuncionario){
        return new DAOFuncionario().salvarFuncionario(fFuncionario);
    }
    public List<Funcionario> listarFuncionarios() throws SQLException{
        DAOFuncionario dao = new DAOFuncionario();
        List<Funcionario> funcionarios = dao.listar();
        return funcionarios;
    }
}
