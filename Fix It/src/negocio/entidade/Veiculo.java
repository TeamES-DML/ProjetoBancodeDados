package negocio.entidade;
import java.util.ArrayList;
public class Veiculo {
	private String proprietario;
	private String placa;
	private String modelo;
	private ArrayList<Servico> vetorServico;
	
	public Veiculo(String proprietario,String placa,String modelo){
		this.proprietario = proprietario;
		this.placa = placa;
		this.modelo = modelo;
		this.vetorServico = new ArrayList<Servico>();
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

	public ArrayList<Servico> getListaServico() {
		return this.vetorServico;
	}

	public void setServico(ArrayList<Servico> lista) {
		this.vetorServico = lista;
	}

	public ArrayList<Servico> getServicosNaoConcluidos(){
		ArrayList<Servico> lista = new ArrayList<Servico>();
		if(this.getListaServico().size() != 0){
			for (int i = 0; i < this.getListaServico().size(); i++){
				if (!this.getListaServico().get(i).getConcluido()){
					lista.add(this.getListaServico().get(i));
				}
			}
		}
		return lista;
	}
	//public void adicionarServico(Servico servico){
		//this.vetorServico.add(servico);
	//}
}
