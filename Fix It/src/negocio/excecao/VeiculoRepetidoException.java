package negocio.excecao;

public class VeiculoRepetidoException extends Exception {
    public VeiculoRepetidoException(){
        super("Veiculo ja existe");
    }
}
