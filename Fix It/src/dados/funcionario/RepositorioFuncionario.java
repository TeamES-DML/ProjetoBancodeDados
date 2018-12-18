package dados.funcionario;

import java.util.ArrayList;
import java.util.Collection;
import dados.Database;
import negocio.entidade.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario{

	private Database db;

	public RepositorioFuncionario(){
		this.db = new Database();
		this.db.adicionarFuncionario(new Funcionario("Daniel","10579130495","123","Gerente"));
	}
	@Override
	public void adicionar(Funcionario funcionario){
		this.db.adicionarFuncionario(funcionario);
	}


	@Override
	public void remover(Funcionario funcionario) {
		this.db.removerFuncionario(funcionario);
	}


	public ArrayList<Funcionario> getArray() {
		return this.db.listarFuncionario();
	}
	@Override
	public Funcionario procurarFuncionario(String cpf){
		ArrayList<Funcionario> listaFuncionario = this.getArray();
		Funcionario funcionarioProcurado = null;
		for(int i = 0;i<listaFuncionario.size();i++){
			if(listaFuncionario.get(i).getCpf().equals(cpf)){
				funcionarioProcurado = listaFuncionario.get(i);
			}
		}
		return funcionarioProcurado;
	}
}