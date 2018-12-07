package negocio.excecao;

public class TipoNaoDeclaradoException extends Exception {
    public TipoNaoDeclaradoException(){
        super("Tipo nao declarado");
    }
}
