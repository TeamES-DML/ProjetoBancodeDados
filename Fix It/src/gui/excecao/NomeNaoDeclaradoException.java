package gui.excecao;

public class NomeNaoDeclaradoException extends Exception{
    public NomeNaoDeclaradoException(){
        super("Nome nao declarado");
    }
}
