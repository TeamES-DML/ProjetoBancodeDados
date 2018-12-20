package dados.servico;

import java.util.ArrayList;

import dados.Database;
import negocio.entidade.Servico;
import negocio.entidade.Veiculo;

public class RepositorioServicoConcluido implements IRepositorioServicoConcluido {

    private Database db;

    public RepositorioServicoConcluido(){
        this.db = new Database();
        this.getArray();
    }
    @Override
    public void adicionar(Servico servico){
        this.db.adicionarServico(servico);
    }
    @Override
    public void remover(Servico servico){
        this.db.removerServico(servico);
    }
    @Override
    public ArrayList<Servico> getArray() {
        return this.db.listarServicoConcluido();
    }

    @Override
    public ArrayList<Servico> servicosAndamento(Veiculo v){
        ArrayList<Servico> andamento = this.db.listarServicoAndamento(v);
        return andamento;
    }

    @Override
    public void concluir(Servico servico){
        this.db.concluir(servico);
    }
}

