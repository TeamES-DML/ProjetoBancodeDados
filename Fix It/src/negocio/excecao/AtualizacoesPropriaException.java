package negocio.excecao;

public class AtualizacoesPropriaException extends Exception{
    public AtualizacoesPropriaException(){
        super("Atualizacoes em si mesmo nao sao possiveis");
    }

}
