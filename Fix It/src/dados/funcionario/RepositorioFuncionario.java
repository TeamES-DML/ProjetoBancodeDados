package dados.funcionario;

import java.util.ArrayList;
import java.util.Collection;
import dados.Database;
import negocio.entidade.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario{

	private ArrayList<Funcionario> listaFuncionario;
	private Database db;
	
	public RepositorioFuncionario(){
		this.listaFuncionario = new ArrayList<Funcionario>();
		this.listaFuncionario.add(new Funcionario("Daniel","10579130495","123","Gerente"));
		this.listaFuncionario.add(new Funcionario("Luis","05801485481","1234","Normal"));
		this.db = new Database();
	}
	@Override
	public void adicionar(Funcionario funcionario){
		this.listaFuncionario.add(funcionario);
		this.db.adicionarFuncionario(funcionario);
	}


	@Override
	public void remover(Funcionario funcionario) {
		this.listaFuncionario.remove(funcionario);
	}


	public ArrayList<Funcionario> getArray() {
		return this.listaFuncionario;
	}
	@Override
	public Funcionario procurarFuncionario(String cpf){
		Funcionario funcionarioProcurado = null;
		for(int i = 0;i<this.listaFuncionario.size();i++){
			if(this.listaFuncionario.get(i).getCpf().equals(cpf)){
				funcionarioProcurado = this.listaFuncionario.get(i);
			}
		}
		return funcionarioProcurado;
	}
}
