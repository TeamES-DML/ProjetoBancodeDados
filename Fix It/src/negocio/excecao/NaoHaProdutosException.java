package negocio.excecao;

public class NaoHaProdutosException extends Exception {
    public NaoHaProdutosException(){
        super("Nao existem produtos vendidos");
    }
}
