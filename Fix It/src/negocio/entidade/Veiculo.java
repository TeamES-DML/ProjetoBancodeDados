package negocio.entidade;
import java.util.ArrayList;
public class Veiculo {
	private String proprietario;
	private String placa;
	private String modelo;
	
	public Veiculo(String proprietario,String placa,String modelo){
		this.proprietario = proprietario;
		this.placa = placa;
		this.modelo = modelo;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	//public void adicionarServico(Servico servico){
		//this.vetorServico.add(servico);
	//}
}
