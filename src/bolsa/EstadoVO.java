package bolsa;

import java.util.List;

public class EstadoVO {
	private String nome;
	private List<Cidade> cidades;
	
	public EstadoVO(String nome, List<Cidade> cidades) {
		super();
		this.nome = nome;
		this.cidades = cidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
}
