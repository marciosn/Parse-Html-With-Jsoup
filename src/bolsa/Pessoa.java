package bolsa;

import java.util.List;

public class Pessoa {
	
	private String nome;
	private String urlPessoa;
	private String pagamentos;
	private String valor;
	List<PessoaInfo> pessoaInfos;
	
	public Pessoa(String nome, String urlPessoa, String pagamentos, String valor) {
		this.nome = nome;
		this.urlPessoa = urlPessoa;
		this.pagamentos = pagamentos;
		this.valor = valor;
	}
	
	public Pessoa() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlPessoa() {
		return urlPessoa;
	}
	public void setUrlPessoa(String urlPessoa) {
		this.urlPessoa = urlPessoa;
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

	public List<PessoaInfo> getPessoaInfos() {
		return pessoaInfos;
	}

	public void setPessoaInfos(List<PessoaInfo> pessoaInfos) {
		this.pessoaInfos = pessoaInfos;
	}

}
