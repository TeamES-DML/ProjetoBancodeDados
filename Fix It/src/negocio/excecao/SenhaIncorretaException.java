package negocio.excecao;

public class SenhaIncorretaException extends Exception {

    public SenhaIncorretaException(){
        super("Senha Incorreta");
    }
}
