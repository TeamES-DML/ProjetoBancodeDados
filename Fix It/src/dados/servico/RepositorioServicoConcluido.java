package dados.servico;

import java.util.ArrayList;

import dados.Database;
import negocio.entidade.Servico;

public class RepositorioServicoConcluido implements IRepositorioServicoConcluido {
    private ArrayList<Servico> listaServico;
    private Database db;

    public RepositorioServicoConcluido(){
        this.listaServico = new ArrayList<Servico>();
    }
    @Override
    public void adicionar(Servico servico){
        listaServico.add(servico);
    }
    @Override
    public void remover(Servico servico){
        listaServico.remove(servico);
    }
    @Override
    public ArrayList<Servico> getArray() {
        return listaServico;
    }
}

