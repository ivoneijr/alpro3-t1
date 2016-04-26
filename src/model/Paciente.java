package model;

public class Paciente {

	private String nome;
	private String rg;
	private String data;
	
	public Paciente(){}
	
	public Paciente(String nome, String rg, String data) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Paciente [rg=" + rg + ", nome=" + nome + ", data=" + data + "]";
	}
}