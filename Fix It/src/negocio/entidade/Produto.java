package negocio.entidade;

import javafx.beans.property.SimpleStringProperty;

public class Produto {
	private SimpleStringProperty tipo;// Ex: Oleo
	private double precoCompra;
	private double precoVenda;
	
	public Produto(String nome, double precoCompra, double precoVenda){
		this.tipo = new SimpleStringProperty(nome);
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
	}

	public String getTipo() {
		return this.tipo.get();
	}

	public void setTipo(String produto) {
		this.tipo.set(produto);
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(int precoCompra) {
		this.precoCompra = precoCompra;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(int precoVenda) {
		this.precoVenda = precoVenda;
	}
}
