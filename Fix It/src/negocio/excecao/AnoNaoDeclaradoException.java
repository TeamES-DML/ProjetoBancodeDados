package negocio.excecao;

public class AnoNaoDeclaradoException extends Exception{
    public AnoNaoDeclaradoException(){
        super("Ano nao foi declarado");
    }
}
