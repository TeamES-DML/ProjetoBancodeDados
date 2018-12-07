package dados.veiculo;

import java.util.ArrayList;

import negocio.entidade.Veiculo;
import negocio.entidade.*;
public class RepositorioVeiculo implements IRepositorioVeiculo{
	private ArrayList<Veiculo> listaVeiculo;
	
	public RepositorioVeiculo(){
		this.listaVeiculo = new ArrayList<Veiculo>();
	}
	@Override
	public void adicionar(Veiculo veiculo){
		this.listaVeiculo.add(veiculo);
	}
	@Override
	public void remover(Veiculo veiculo) {
		this.listaVeiculo.remove(veiculo);
	}

	public ArrayList<Veiculo> getListaVeiculo() {
		return this.listaVeiculo;
	}
	@Override
	public Veiculo procurarVeiculo(String placa){
		Veiculo veiculoProcurado = null;
		for(int i = 0;i< this.listaVeiculo.size();i++){
			if(this.listaVeiculo.get(i).getPlaca().equals(placa)){
				veiculoProcurado = this.listaVeiculo.get(i);
			}
		}
		return veiculoProcurado;
	}
	@Override
	public ArrayList<Veiculo> getArray(){
		return this.listaVeiculo;
	}
}
