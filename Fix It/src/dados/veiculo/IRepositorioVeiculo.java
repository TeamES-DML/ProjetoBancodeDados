package dados.veiculo;

import negocio.entidade.Servico;
import negocio.entidade.Veiculo;

import java.util.ArrayList;

public interface IRepositorioVeiculo {
    void adicionar(Veiculo veiculo);

    void remover(Veiculo veiculo);

    Veiculo procurarVeiculo(String placa);

    ArrayList<Veiculo> getArray();
}
