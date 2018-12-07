package gui.excecao;

public class VeiculoNaoEncontradoException extends Exception{
    public VeiculoNaoEncontradoException(){
        super("Veiculo nao foi encontrado");
    }
}
