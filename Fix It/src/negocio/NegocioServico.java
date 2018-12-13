package negocio;

import dados.servico.IRepositorioServicoConcluido;
import gui.excecao.DataInvalidaException;
import gui.excecao.MesNaoDeclaradoException;
import gui.excecao.ServicoAConcluirNaoEncontradoException;
import negocio.entidade.Produto;
import negocio.entidade.Servico;
import negocio.entidade.Veiculo;
import negocio.excecao.*;

import java.util.ArrayList;

public class NegocioServico {
    private IRepositorioServicoConcluido repositorio;
    public NegocioServico(IRepositorioServicoConcluido repositorio){
        this.repositorio = repositorio;
    }

    public double CalcularLucroMensal(int mes, int ano) throws AnoNaoDeclaradoException, MesNaoDeclaradoException {
        double lucro = 0;
        if(ano == 0){
            throw new AnoNaoDeclaradoException();
        }
        else if(mes == 0){
            throw new MesNaoDeclaradoException();
        }
        else{
            for (int i = 0; i < repositorio.getArray().size(); i++) {
                if (repositorio.getArray().get(i).getDataServico().getMes() == mes && repositorio.getArray().get(i).getDataServico().getAno() == ano && repositorio.getArray().get(i).getConcluido()) {
                    if(repositorio.getArray().get(i).getTipoOperacao() == "Compra"){
                        lucro -= this.repositorio.getArray().get(i).getPrecoServico();
                    }
                    else{
                        lucro += this.repositorio.getArray().get(i).getPrecoServico();
                    }
                }
            }
        }
        return lucro;
    }

    public double CalcularLucroAnual(int ano) throws AnoNaoDeclaradoException{
        double lucro = 0;
        if(ano == 0){
            throw new AnoNaoDeclaradoException();
        }
        else {
            for (int i = 0; i < repositorio.getArray().size(); i++) {
                if (repositorio.getArray().get(i).getDataServico().getAno() == ano && repositorio.getArray().get(i).getConcluido()) {
                    if (repositorio.getArray().get(i).getTipoOperacao() == "Compra") {
                        lucro -= this.repositorio.getArray().get(i).getPrecoServico();
                    } else {
                        lucro += this.repositorio.getArray().get(i).getPrecoServico();
                    }
                }
            }
        }
        return lucro;
    }

    public ArrayList<Produto> produtosRecorrentes(ArrayList<Produto> repositorioP) throws NaoHaProdutosException{
        Produto produtoAtual;
        ArrayList<Produto> listaProduto;
        if(repositorioP.size() != 0){
            System.out.println(repositorioP.get(0).getTipo());
            listaProduto = repositorioP;
        }
        else{
            throw new NaoHaProdutosException();
        }
        ArrayList<Integer> contadores = new ArrayList<Integer>();
        boolean erro = false;
        for(int p = 0; p < repositorio.getArray().size(); p++){
            if(repositorio.getArray().get(p).getTipoOperacao().equals("Venda")){
                erro = true;
            }
        }
        if(repositorio.getArray().size() == 0 || !erro) {
            System.out.println("Nao aqui");
            throw new NaoHaProdutosException();
        }
        else {
            for (int i = 0; i < repositorioP.size(); i++) {
                produtoAtual = repositorioP.get(i);
                int contador = 0;
                for (int j = 0; j < listaProduto.size(); j++) {
                    if (repositorio.getArray().get(i).getTipoOperacao().equals("Venda") && repositorio.getArray().get(i).getConcluido() && repositorio.getArray().get(i).getProduto() == produtoAtual) {
                        contador += 1;
                    }
                }
                contadores.add(contador);
            }
            ArrayList<Produto> listaFinal = new ArrayList<Produto>();
            while (contadores.size() > 0) {
                int maior = contadores.get(0);
                int posicao = 0;
                for (int k = 0; k < contadores.size(); k++) {
                    if (contadores.get(k) > maior) {
                        maior = contadores.get(k);
                        posicao = k;
                    }
                }
                listaFinal.add(listaProduto.get(posicao));
                listaProduto.remove(posicao);
                contadores.remove(posicao);
            }
            return listaFinal;
        }
    }
    public void concluirServico(Veiculo veiculo, Servico servico) throws ServicoAConcluirNaoEncontradoException {
        ArrayList<Servico> arrayServicos = veiculo.getServicosNaoConcluidos();
        boolean flag = true;
        for (int k = 0; k < arrayServicos.size() && flag; k++) {
            if (arrayServicos.get(k).equals(servico)) {
                servico.setConcluido(true);
                repositorio.adicionar(servico);
                flag = false;
            }
        }
        if(flag){
            throw new ServicoAConcluirNaoEncontradoException();
        }
    }
    public void adicionarCompra(Servico servico) throws DataInvalidaException{
        if(!servico.getDataServico().validar()){
            throw new DataInvalidaException();
        }
        else{
            this.repositorio.adicionar(servico);
        }
    }

    public void adicionarVenda(Servico servico) throws DataInvalidaException{
        if(!servico.getDataServico().validar()){
            throw new DataInvalidaException();
        }
        else{
            this.repositorio.adicionar(servico);
        }
    }

    public IRepositorioServicoConcluido getRepositorio() {
        return repositorio;
    }
}
