package dados.produto;

import java.util.ArrayList;

import dados.Database;
import negocio.entidade.Peca;
import negocio.entidade.Produto;
import negocio.entidade.*;

public class RepositorioProduto implements IRepositorioProduto{

	//private ArrayList<Produto> listaProduto;
	private Database db;

	public RepositorioProduto(){
		//this.listaProduto = new ArrayList<Produto>();
		this.db = new Database();
	}
	@Override
	public void adicionar(Produto produto){
		this.db.adicionarProduto(produto);
	}
	@Override
	public void remover(Produto produto) {
		this.db.removerProduto(produto);
	}
	public ArrayList<Produto> getArrayProduto() {
		return this.db.listarProdutos();
	}
	@Override
	public Produto procurarProduto(String tipo, String modeloCarro){//Procurar na lista a determinada peca que seja do modelo adequado
		Produto produtoProcurado = null;
		ArrayList<Produto> listaProduto = this.getArrayProduto();
		for(int i = 0;i < listaProduto.size();i++){
			if(listaProduto.get(i).getTipo().equals(tipo) && ((Peca)(listaProduto).get(i)).getModeloCarro().equals(modeloCarro)){
				produtoProcurado = listaProduto.get(i);
			}
		}
		return  produtoProcurado;
	}
	@Override
	public Produto procurarProduto(String tipo){//Procurar na lista o determinado produto que seja do tipo adequado
		Produto produtoProcurado = null;
		ArrayList<Produto> listaProduto = this.getArrayProduto();
		for(int i = 0;i<listaProduto.size();i++){
			if(listaProduto.get(i).getTipo().equals(tipo)){
				produtoProcurado = listaProduto.get(i);
			}
		}
		return produtoProcurado;
	}
	public Produto procurarPeca(String tipo,String modelo){
		Produto produtoProcurado = null;
		ArrayList<Produto> listaProduto = this.getArrayProduto();
		for(int i = 0;i<listaProduto.size();i++){
			if(listaProduto.get(i).getTipo().equals(tipo) && ((Peca)(listaProduto).get(i)).getModeloCarro().equals(modelo)){
				produtoProcurado = listaProduto.get(i);
				return produtoProcurado;
			}
		}
		return produtoProcurado;
	}
}