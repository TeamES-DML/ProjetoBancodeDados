package negocio.entidade;

import javafx.beans.property.SimpleStringProperty;

public class Peca extends Produto {
	private SimpleStringProperty modeloCarro;// Ex: Fiat
	private double precoReparo;
	private double precoMaoDeObra;
	public Peca(String tipo,String modeloCarro,double precoCompra,double precoVenda, double precoMaoDeObra,double precoReparo){
		super(tipo,precoCompra,precoVenda);// Ex Tipo: Motor
		this.precoMaoDeObra = precoMaoDeObra;
		this.modeloCarro = new SimpleStringProperty(modeloCarro);
		this.precoReparo = precoReparo;
		this.setePeca(true);
	}
	public String getModeloCarro() {
		return modeloCarro.get();
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro.set(modeloCarro);
	}


	public double getPrecoReparo() {
		return precoReparo;
	}

	public void setPrecoReparo(double precoReparo) {
		this.precoReparo = precoReparo;
	}

	public double getPrecoMaoDeObra(){
		return this.precoMaoDeObra;
	}
}
