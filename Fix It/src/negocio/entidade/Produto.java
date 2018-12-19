package negocio.entidade;

import javafx.beans.property.SimpleStringProperty;

public class Produto {
	private SimpleStringProperty tipo;// Ex: Oleo
	private double precoCompra;
	private double precoVenda;
	private static int contadorProdutos = 0;
	private int id = 0;
	private boolean ePeca;
	
	public Produto(String nome, double precoCompra, double precoVenda){
		this.tipo = new SimpleStringProperty(nome);
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.id = contadorProdutos;
		this.ePeca = false;
		contadorProdutos++;
	}

	public Produto(String nome, double precoCompra, double precoVenda, int id){
		this.tipo = new SimpleStringProperty(nome);
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.id = id;
		this.ePeca = false;
		if (id >= contadorProdutos){
			contadorProdutos = id+1;
		}
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

	public int getId(){
		return this.id;
	}

	public boolean getEPeca() {
		return ePeca;
	}

	public void setePeca(boolean ePeca) {
		this.ePeca = ePeca;
	}
}
