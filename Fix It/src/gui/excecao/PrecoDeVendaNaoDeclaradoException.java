package gui.excecao;

public class PrecoDeVendaNaoDeclaradoException extends Exception{
    public PrecoDeVendaNaoDeclaradoException(){
        super("Preco de venda nao declarado");
    }
}
