package gui.excecao;

public class FuncionarioNaoEncontradoException extends Exception {
    public FuncionarioNaoEncontradoException(){
        super("Funcionario nao foi encontrado");
    }
}
