package dados.produto;

import java.util.ArrayList;

import negocio.entidade.Peca;
import negocio.entidade.Produto;
import negocio.entidade.*;
public class RepositorioProduto implements IRepositorioProduto{
	private ArrayList<Produto> listaProduto;
	
	public RepositorioProduto(){
		this.listaProduto = new ArrayList<Produto>();
	}
	@Override
	public void adicionar(Produto produto){
		this.listaProduto.add(produto);
	}
	@Override
	public void remover(Produto produto) {
		this.listaProduto.remove(produto);
	}
	public ArrayList<Produto> getArrayProduto() {
		return this.listaProduto;
	}
	@Override
	public Produto procurarProduto(String tipo, String modeloCarro){//Procurar na lista a determinada peca que seja do modelo adequado
		Produto produtoProcurado = null;
		for(int i = 0;i < this.listaProduto.size();i++){
			if(this.listaProduto.get(i).getTipo().equals(tipo) && ((Peca)(this.listaProduto).get(i)).getModeloCarro().equals(modeloCarro)){
				produtoProcurado = this.listaProduto.get(i);
			}
		}
		return  produtoProcurado;
	}
	@Override
	public Produto procurarProduto(String tipo){//Procurar na lista o determinado produto que seja do tipo adequado
		Produto produtoProcurado = null;
		for(int i = 0;i<this.listaProduto.size();i++){
			if(this.listaProduto.get(i).getTipo().equals(tipo)){
				produtoProcurado = this.listaProduto.get(i);
			}
		}
		return produtoProcurado;
	}
}
