package negocio.entidade;

import javafx.beans.property.SimpleStringProperty;

public class Funcionario {
	private SimpleStringProperty nome;
	private SimpleStringProperty cpf;
	private SimpleStringProperty escalao;
	private String senha;
	
	public Funcionario(String nome,String cpf,String senha,String escalao){
		this.nome = new SimpleStringProperty(nome);
		this.cpf = new SimpleStringProperty(cpf);
		this.escalao = new SimpleStringProperty(escalao);
		this.senha = senha;
	}

	public String getNome() {
		return this.nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public String getCpf() {
		return this.cpf.get();
	}

	public void setCpf(String cpf) {
		this.cpf.set(cpf);
	}

	public String getEscalao() {
		return this.escalao.get();
	}

	public void setEscalao(String escalao) {
		this.escalao.set(escalao);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void promover(){
		this.setEscalao("Gerente");
	}
	public void despromover(){
		this.setEscalao("Normal");
	}
	public boolean validar(String senha){
		if (senha.equals(this.senha)){
			return true;
		}
		else{
			return  false;
		}
	}
}
