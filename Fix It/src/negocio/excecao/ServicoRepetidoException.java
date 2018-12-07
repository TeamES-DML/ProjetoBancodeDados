package negocio.excecao;

public class ServicoRepetidoException extends Exception {
    public ServicoRepetidoException(){
        super("Servico repetido");
    }
}
