package negocio.excecao;

public class ProdutoRepetidoException extends Exception {
    public ProdutoRepetidoException(){
        super("Produto ja existe");
    }
}
