package model;

public class Medicamento {

	private String nome;
	private Long codigo;
	
	public Medicamento(){}

	public Medicamento(Long codigo,String nome) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Medicamento [codigo=" + codigo + ", nome=" + nome+ "]";
	}
}
