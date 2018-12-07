package negocio.excecao;

public class FuncionarioRepetidoException extends Exception {
    public FuncionarioRepetidoException(){
        super("Funcionario ja existe");
    }
}
