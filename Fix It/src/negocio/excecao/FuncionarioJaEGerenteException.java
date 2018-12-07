package negocio.excecao;

public class FuncionarioJaEGerenteException extends Exception{
    public FuncionarioJaEGerenteException(){
        super("Funcionario ja e gerente");
    }
}
