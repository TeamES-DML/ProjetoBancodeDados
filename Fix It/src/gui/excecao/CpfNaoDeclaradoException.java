package gui.excecao;

public class CpfNaoDeclaradoException extends Exception{
    public CpfNaoDeclaradoException(){
        super("Cpf nao declarado");
    }
}
