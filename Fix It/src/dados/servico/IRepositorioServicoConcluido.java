package dados.servico;

import negocio.entidade.Servico;

import java.util.ArrayList;

public interface IRepositorioServicoConcluido {
    void adicionar(Servico servico);

    void remover(Servico servico);

    ArrayList<Servico> getArray();

}
