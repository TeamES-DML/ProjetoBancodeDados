package negocio;

import dados.funcionario.IRepositorioFuncionario;
import gui.excecao.*;
import negocio.entidade.Funcionario;
import negocio.excecao.*;

public class NegocioFuncionario {

    private IRepositorioFuncionario repositorio;

    public NegocioFuncionario(IRepositorioFuncionario repositorio){
        this.repositorio = repositorio;
    }

    public void adicionar(Funcionario funcionario) throws FuncionarioRepetidoException, NomeNaoDeclaradoException, CpfNaoDeclaradoException, CpfInvalidoException, EscalaoNaoDeclaradoException, SenhaNaoDeclaradaException{
        Funcionario atual = this.repositorio.procurarFuncionario(funcionario.getCpf());
        if(atual != null){
            throw new FuncionarioRepetidoException();
        }
        else if(funcionario.getCpf().equals("")){
            throw new CpfNaoDeclaradoException();
        }
        else if(funcionario.getCpf().length() != 11){
            throw new CpfInvalidoException();
        }
        else if(funcionario.getNome().equals("")){
            throw new NomeNaoDeclaradoException();
        }
        else if(funcionario.getSenha().equals("")){
            throw new SenhaNaoDeclaradaException();
        }
        else if(!funcionario.getEscalao().equals("Gerente") && !funcionario.getEscalao().equals("Normal")){
            throw new EscalaoNaoDeclaradoException();
        }
        else{
            this.repositorio.adicionar(funcionario);
        }
    }

    public void remover(Funcionario logado, Funcionario funcionario) throws FuncionarioNaoEncontradoException, CpfNaoDeclaradoException, CpfInvalidoException, AtualizacoesPropriaException {
        Funcionario atual = this.repositorio.procurarFuncionario(funcionario.getCpf());
        if(atual == null){
            throw new FuncionarioNaoEncontradoException();
        }
        else if(funcionario.getCpf().equals("")){
            throw new CpfNaoDeclaradoException();
        }
        else if(funcionario.getCpf().length() != 11){
            throw new CpfInvalidoException();
        }
        else if(logado.getCpf().equals(funcionario.getCpf())){
            throw new AtualizacoesPropriaException();
        }
        else{
            this.repositorio.remover(funcionario);
        }
    }

    public void promover(Funcionario logado, Funcionario funcionario) throws FuncionarioNaoEncontradoException, FuncionarioJaEGerenteException, CpfNaoDeclaradoException, CpfInvalidoException, AtualizacoesPropriaException {
        Funcionario atual;
        atual = this.repositorio.procurarFuncionario(funcionario.getCpf());
        if(atual == null){
            throw new FuncionarioNaoEncontradoException();

        }
        else if(funcionario.getCpf().equals("")){
            throw new CpfNaoDeclaradoException();
        }
        else if (funcionario.getCpf().length() != 11){
            throw new CpfInvalidoException();
        }
        else if(logado.getCpf().equals(funcionario.getCpf())){
            throw new AtualizacoesPropriaException();
        }
        else{
            if(atual.getEscalao().equals("Gerente")){
                throw new FuncionarioJaEGerenteException();
            }
            else {
                atual.promover();
                this.repositorio.atualizaEscalao(atual,"Gerente");
            }
        }
    }
    public void despromover(Funcionario logado, Funcionario funcionario) throws FuncionarioNaoEncontradoException, FuncionarioJaEPadraoException, CpfNaoDeclaradoException, CpfInvalidoException, AtualizacoesPropriaException {
        Funcionario atual = this.repositorio.procurarFuncionario(funcionario.getCpf());
        if(atual == null){
            throw new FuncionarioNaoEncontradoException();
        }
        else if(funcionario.getCpf().equals("")){
            throw new CpfNaoDeclaradoException();
        }
        else if(funcionario.getCpf().length() != 11){
            throw new CpfInvalidoException();
        }
        else if(logado.getCpf().equals(funcionario.getCpf())){
            throw new AtualizacoesPropriaException();
        }
        else{
            if(atual.getEscalao().equals("Normal")){
                throw new FuncionarioJaEPadraoException();
            }
            else{
                atual.despromover();
                repositorio.atualizaEscalao(atual,"Normal");
            }
        }
    }
    public String login(Funcionario funcionario, String senha) throws FuncionarioNaoEncontradoException, SenhaIncorretaException {
        Funcionario f = this.repositorio.procurarFuncionario(funcionario.getCpf());
        boolean senhaCorreta;
        if (f == null){
            throw new FuncionarioNaoEncontradoException();
        }
        else{
            senhaCorreta = funcionario.validar(senha);
        }
        if (senhaCorreta){
            return funcionario.getEscalao();
        }
        else{
            throw new SenhaIncorretaException();
        }
    }

    public IRepositorioFuncionario getRepositorio() {
        return this.repositorio;
    }
}
