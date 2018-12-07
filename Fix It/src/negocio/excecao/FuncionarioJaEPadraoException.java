package negocio.excecao;


public class FuncionarioJaEPadraoException extends Exception{
    public FuncionarioJaEPadraoException(){
        super("Funcionario ja e padrao");
    }
}
