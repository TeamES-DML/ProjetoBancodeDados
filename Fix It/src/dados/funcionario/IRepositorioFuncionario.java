package dados.funcionario;

import negocio.entidade.Funcionario;

import java.util.ArrayList;

public interface IRepositorioFuncionario {
    void adicionar(Funcionario funcionario);

    void remover(Funcionario funcionario);

    Funcionario procurarFuncionario(String cpf);

    ArrayList<Funcionario> getArray();

    void atualizaEscalao(Funcionario funcionario,String escalao);
}
