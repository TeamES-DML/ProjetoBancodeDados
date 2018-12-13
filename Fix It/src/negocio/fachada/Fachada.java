package negocio.fachada;
import dados.funcionario.RepositorioFuncionario;
import dados.produto.IRepositorioProduto;
import dados.produto.RepositorioProduto;
import dados.servico.RepositorioServicoConcluido;
import dados.veiculo.RepositorioVeiculo;
import gui.excecao.*;
import negocio.*;
import negocio.NegocioProduto;
import negocio.entidade.*;
import negocio.excecao.*;

import java.util.ArrayList;

public class Fachada {
    private static Fachada fachada;
    private NegocioProduto negocioProduto;
    private NegocioServico negocioServico;
    private NegocioVeiculo negocioVeiculo;
    private NegocioFuncionario negocioFuncionario;

    public Funcionario getLogado() {
        return logado;
    }

    public void setLogado(Funcionario logado) {
        this.logado = logado;
    }

    private Funcionario logado;

    public Fachada(){
        this.negocioFuncionario = new NegocioFuncionario(new RepositorioFuncionario());
        this.negocioProduto = new NegocioProduto(new RepositorioProduto());
        this.negocioServico = new NegocioServico(new RepositorioServicoConcluido());
        this.negocioVeiculo = new NegocioVeiculo(new RepositorioVeiculo());
    }
    public static Fachada getInstance(){

        if(fachada == null){
            fachada = new Fachada();

        }
        return fachada;
    }

    public void adicionarFuncionario(Funcionario funcionario) throws FuncionarioRepetidoException, NomeNaoDeclaradoException, CpfInvalidoException, CpfNaoDeclaradoException, SenhaNaoDeclaradaException, EscalaoNaoDeclaradoException {
        this.negocioFuncionario.adicionar(funcionario);
    }
    public void removerFuncionario(Funcionario funcionario) throws FuncionarioNaoEncontradoException, CpfInvalidoException, CpfNaoDeclaradoException, AtualizacoesPropriaException {
        this.negocioFuncionario.remover(this.logado, funcionario);
    }
    public void promoverFuncionario(Funcionario funcionario) throws FuncionarioJaEGerenteException, FuncionarioNaoEncontradoException, CpfInvalidoException, CpfNaoDeclaradoException, AtualizacoesPropriaException {
        this.negocioFuncionario.promover(this.logado, funcionario);
    }
    public void despromoverFuncionario(Funcionario funcionario) throws FuncionarioJaEPadraoException, FuncionarioNaoEncontradoException, CpfInvalidoException, CpfNaoDeclaradoException, AtualizacoesPropriaException {
        this.negocioFuncionario.despromover(this.logado, funcionario);
    }
    public void adicionarProduto(Produto produto) throws ProdutoRepetidoException, ModeloNaoDeclaradoException, TipoNaoDeclaradoException, PrecoDeVendaNaoDeclaradoException, PrecoDeReparoNaoDeclaradoException, PrecoDeCompraNaoDeclaradoException {
        this.negocioProduto.adicionar(produto);
    }
    public void removerProduto(Produto produto) throws ProdutoRepetidoException {
        this.negocioProduto.remover(produto);
    }
    public double lucroMensal(int mes, int ano) throws AnoNaoDeclaradoException, MesNaoDeclaradoException{
        return this.negocioServico.CalcularLucroMensal(mes,ano);
    }
    public double lucroAnual(int ano) throws AnoNaoDeclaradoException{
        return this.negocioServico.CalcularLucroAnual(ano);
    }
    public ArrayList<Produto> produtosRecorrentes(IRepositorioProduto repositorio) throws NaoHaProdutosException{
        return this.negocioServico.produtosRecorrentes(repositorio.getArrayProduto());
    }
    /*
    public void concluirServico(Veiculo veiculo, Servico servico) throws ServicoAConcluirNaoEncontradoException{
        this.negocioServico.concluirServico(veiculo, servico);
    }
    */
    public void adicionarVeiculo(Veiculo veiculo) throws VeiculoRepetidoException, PlacaInvalidaException, PlacaNaoDeclaradaException, ModeloNaoDeclaradoException, NomeNaoDeclaradoException {
        this.negocioVeiculo.adicionarVeiculo(veiculo);
    }
    public void removerVeiculo(Veiculo veiculo) throws VeiculoNaoEncontradoException {
        this.negocioVeiculo.removerVeiculo(veiculo);
    }
    public String logar(Funcionario funcionario, String senha) throws SenhaIncorretaException, FuncionarioNaoEncontradoException {
        return this.negocioFuncionario.login(funcionario, senha);
    }
    public void adicionarServico(Servico servico) throws  DataInvalidaException{
        this.negocioServico.adicionarVenda( servico);
    }
    public void adicionarCompra(Servico servico)throws DataInvalidaException{
        this.negocioServico.adicionarCompra(servico);
    }

    public NegocioProduto getNegocioProduto() {
        return negocioProduto;
    }

    public NegocioServico getNegocioServico() {
        return negocioServico;
    }

    public NegocioVeiculo getNegocioVeiculo() {
        return negocioVeiculo;
    }

    public NegocioFuncionario getNegocioFuncionario() {
        return negocioFuncionario;
    }
}
