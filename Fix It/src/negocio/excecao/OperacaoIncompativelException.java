package negocio.excecao;

public class OperacaoIncompativelException extends Exception{
    public OperacaoIncompativelException(){
        super("Operacao incompativel");
    }
}
