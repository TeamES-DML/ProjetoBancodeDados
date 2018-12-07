package gui.excecao;

public class ServicoAConcluirNaoEncontradoException extends Exception{
    public ServicoAConcluirNaoEncontradoException(){
        super("Servico a concluir nao encontrado");
    }
}
