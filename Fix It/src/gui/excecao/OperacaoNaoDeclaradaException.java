package gui.excecao;

public class OperacaoNaoDeclaradaException extends Exception{
    public OperacaoNaoDeclaradaException(){
        super("Operacao nao declarada");
    }
}
