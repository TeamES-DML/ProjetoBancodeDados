package negocio.entidade;

import java.lang.Comparable;

public class DataSimples extends Object implements Comparable<DataSimples> {
	private int dia;
	private int mes;
	private int ano;
	
	public DataSimples(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	public String toString() {
		return String.valueOf(this.dia)+"-"+String.valueOf(this.mes)+"-"+String.valueOf(this.ano);
	}
	public int compareTo(DataSimples data) {
		if (this.ano == data.getAno()) {
			if(this.mes == data.getMes()) {
				if (this.dia < data.getDia()) {
					return -1;
				}
				else if (this.dia > data.getDia()) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else if(this.mes < data.getMes()) {
				return -1;
			}
			else {
				return 1;
			}
		}
		else if(this.ano < data.getAno()) {
			return -1;
		}
		else {
			return 1;
		}
	}
	public boolean validar() {
		if (this.ano <=0 || this.mes <= 0 || this.ano <= 0) {
			return false;
		}
		if (this.mes > 12) {
			return false;
		}
		if (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12) {
			if (this.dia <= 31 && this.dia > 0) {
				return true;
			}
			else{
				return false;
			}
		}
		else if (this.mes == 2) { // e preciso checar se e bissexto
			if (this.ano % 4 == 0 && this.ano % 100 != 100) {
				if (this.dia > 0 && this.dia <= 29) {
					return true;
				}
				else {
					return false;
				}
			}
			else if(this.ano % 4 != 0 && this.ano % 400 == 0) {
				if (this.dia > 0 && this.dia <= 29) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if (this.dia > 0 && this.dia <= 28) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			if (this.dia > 0 && this.dia <= 30) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
}
