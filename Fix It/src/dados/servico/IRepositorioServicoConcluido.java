package dados.servico;

import negocio.entidade.Servico;
import negocio.entidade.Veiculo;

import java.util.ArrayList;

public interface IRepositorioServicoConcluido {
    void adicionar(Servico servico);

    void remover(Servico servico);

    ArrayList<Servico> getArray();

    ArrayList<Servico> servicosAndamento(Veiculo v);

    void concluir(Servico servico);

}
