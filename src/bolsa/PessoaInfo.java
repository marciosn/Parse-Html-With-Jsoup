package bolsa;

public class PessoaInfo {
	
	private String nome;
	private String mesRecebimento;
	private String anoRecebimento;
	private String valorRecebido;
	private String NIS;
	
	public PessoaInfo(){}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMesRecebimento() {
		return mesRecebimento;
	}

	public void setMesRecebimento(String mesRecebimento) {
		this.mesRecebimento = mesRecebimento;
	}

	public String getAnoRecebimento() {
		return anoRecebimento;
	}

	public void setAnoRecebimento(String anoRecebimento) {
		this.anoRecebimento = anoRecebimento;
	}

	public String getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(String valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public String getNIS() {
		return NIS;
	}

	public void setNIS(String nIS) {
		NIS = nIS;
	}
}
