package dados.veiculo;

import java.util.ArrayList;

import negocio.entidade.Veiculo;
import negocio.entidade.*;
import dados.*;

public class RepositorioVeiculo implements IRepositorioVeiculo{

	private Database db;

	public RepositorioVeiculo(){
		this.db = new Database();
	}

	@Override
	public void adicionar(Veiculo veiculo){
		this.db.adicionarVeiculo(veiculo);
	}

	@Override
	public void remover(Veiculo veiculo) {
		this.db.removerVeiculo(veiculo);
	}

	@Override
	public Veiculo procurarVeiculo(String placa){
		Veiculo veiculoProcurado = null;
		ArrayList<Veiculo> listaVeiculo = this.getArray();
		for(int i = 0;i< listaVeiculo.size();i++){
			if(listaVeiculo.get(i).getPlaca().equals(placa)){
				veiculoProcurado = listaVeiculo.get(i);
			}
		}
		return veiculoProcurado;
	}

	@Override
	public ArrayList<Veiculo> getArray(){
		return this.db.listarVeiculo();
	}

}