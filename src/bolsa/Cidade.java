package bolsa;

import java.util.List;

public class Cidade {
	
	private String nome;
	private String urlCidade;
	private String pagamentos;
	private String valor;
	private List<Pessoa> pessoas;
	
	public Cidade(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlCidade() {
		return urlCidade;
	}
	public void setUrlCidade(String urlCidade) {
		this.urlCidade = urlCidade;
	}
	public String getPagamentos() {
		return pagamentos;
	}
	public void setPagamentos(String pagamentos) {
		this.pagamentos = pagamentos;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
}
