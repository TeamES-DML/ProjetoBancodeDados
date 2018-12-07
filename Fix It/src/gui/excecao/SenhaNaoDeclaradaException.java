package gui.excecao;

public class SenhaNaoDeclaradaException extends Exception{
    public SenhaNaoDeclaradaException(){
        super("Senha nao declarada");
    }
}
