package dados.produto;

import negocio.entidade.Produto;

import java.util.ArrayList;

public interface IRepositorioProduto {
    void adicionar(Produto produto);

    void remover(Produto produto);

    Produto procurarProduto(String tipo, String modeloCarro);

    Produto procurarProduto(String tipo);

    ArrayList<Produto> getArrayProduto();
}
