package negocio;

import dados.produto.IRepositorioProduto;
import gui.excecao.ModeloNaoDeclaradoException;
import gui.excecao.PrecoDeCompraNaoDeclaradoException;
import gui.excecao.PrecoDeReparoNaoDeclaradoException;
import gui.excecao.PrecoDeVendaNaoDeclaradoException;
import negocio.excecao.*;
import negocio.entidade.Peca;
import negocio.entidade.Produto;

public class NegocioProduto {
    private IRepositorioProduto repositorio;

    public NegocioProduto(IRepositorioProduto repositorio){
        this.repositorio = repositorio;
    }

    public void adicionar(Produto produto) throws ProdutoRepetidoException, TipoNaoDeclaradoException, PrecoDeCompraNaoDeclaradoException, PrecoDeVendaNaoDeclaradoException, ModeloNaoDeclaradoException, PrecoDeReparoNaoDeclaradoException {
        if(produto instanceof Peca){
            Produto atual = this.repositorio.procurarProduto(produto.getTipo(), ((Peca) produto).getModeloCarro());
            if(atual != null){
                throw new ProdutoRepetidoException();
            }
            else if(produto.getTipo().equals("")){
                throw new TipoNaoDeclaradoException();
            }
            else if(produto.getPrecoCompra() == 0.0){
                throw new PrecoDeCompraNaoDeclaradoException();
            }
            else if(produto.getPrecoVenda() == 0.0){
                throw new PrecoDeVendaNaoDeclaradoException();
            }
            else if(((Peca) produto).getModeloCarro().equals("")){
                throw new ModeloNaoDeclaradoException();
            }
            else if(((Peca) produto).getPrecoReparo() == 0.0){
                throw new PrecoDeReparoNaoDeclaradoException();
            }
            else{
                this.repositorio.adicionar(produto);
            }
        }
        else{
            Produto atual = this.repositorio.procurarProduto(produto.getTipo());
            if(atual != null){
                throw new ProdutoRepetidoException();
            }
            else if(produto.getTipo().equals("")){
                throw new TipoNaoDeclaradoException();
            }
            else if(produto.getPrecoCompra() == 0.0){
                throw new PrecoDeCompraNaoDeclaradoException();
            }
            else if(produto.getPrecoVenda() == 0.0){
                throw new PrecoDeVendaNaoDeclaradoException();
            }
            else{
                this.repositorio.adicionar(produto);
            }
        }
    }

    public void remover(Produto produto) throws ProdutoRepetidoException{
        if(produto instanceof Peca){
            Produto atual = this.repositorio.procurarProduto(produto.getTipo(), ((Peca) produto).getModeloCarro());
            if(atual == null){
                this.repositorio.remover(produto);
            }
            else{
                throw new ProdutoRepetidoException();
            }
        }
        else{
            Produto atual = this.repositorio.procurarProduto(produto.getTipo());
            if(atual == null){
                this.repositorio.remover(produto);
            }
            else{
                throw new ProdutoRepetidoException();
            }
        }
    }

    public IRepositorioProduto getRepositorio() {
        return repositorio;
    }
}
