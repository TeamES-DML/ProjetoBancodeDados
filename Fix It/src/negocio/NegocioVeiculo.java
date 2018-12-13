package negocio;

import dados.veiculo.IRepositorioVeiculo;
import gui.excecao.*;
import negocio.entidade.Peca;
import negocio.entidade.Servico;
import negocio.entidade.Veiculo;
import negocio.excecao.*;

public class NegocioVeiculo {
    private IRepositorioVeiculo repositorio;

    public NegocioVeiculo(IRepositorioVeiculo repositorio){
        this.repositorio = repositorio;
    }

    public void adicionarVeiculo(Veiculo veiculo) throws VeiculoRepetidoException, ModeloNaoDeclaradoException, PlacaInvalidaException, PlacaNaoDeclaradaException, NomeNaoDeclaradoException{
        Veiculo atual =  this.repositorio.procurarVeiculo(veiculo.getPlaca());
        if(atual != null){
            throw new VeiculoRepetidoException();
        }
        else if(veiculo.getProprietario().equals("")){
            throw new NomeNaoDeclaradoException();
        }
        else if(veiculo.getModelo().equals("")){
            throw new ModeloNaoDeclaradoException();
        }
        else if(veiculo.getPlaca().equals("")){
            throw new PlacaNaoDeclaradaException();
        }
        else if(veiculo.getPlaca().length() != 7){
            throw new PlacaInvalidaException();
        }
        else{
            this.repositorio.adicionar(veiculo);
        }
    }

    public void removerVeiculo(Veiculo veiculo) throws VeiculoNaoEncontradoException{
        Veiculo atual = this.repositorio.procurarVeiculo(veiculo.getPlaca());
        if(atual != null){
            this.repositorio.remover(atual);
        }
        else{
            throw new VeiculoNaoEncontradoException();
        }
    }
    /*public void adicionarServico(Veiculo veiculo,Servico servico) throws ServicoRepetidoException, DataInvalidaException, DescricaoNaoDeclaradaException, ModeloIncompativelException, OperacaoIncompativelException {
        boolean flag = false;
        for(int i = 0; i < veiculo.getListaServico().size(); i++){
            if(veiculo.getListaServico().get(i).equals(servico)){
                flag = true;
            }
        }
        if(flag){
            throw new ServicoRepetidoException();
        }
        else if(!servico.getDataServico().validar()){
            throw new DataInvalidaException();
        }
        else if(servico.getDescricao().equals("")){
            throw new DescricaoNaoDeclaradaException();
        }
        else if(servico.getProduto() instanceof Peca && !((Peca) servico.getProduto()).getModeloCarro().equals(veiculo.getModelo())){
                throw new ModeloIncompativelException();
        }
        else if(!(servico.getProduto() instanceof Peca) && servico.getTipoOperacao().equals("Reparo")){
            throw new OperacaoIncompativelException();
        }
        else{
            veiculo.adicionarServico(servico);
        }
    }*/

    public IRepositorioVeiculo getRepositorio() {
        return repositorio;
    }
}
