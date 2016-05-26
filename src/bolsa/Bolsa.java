package bolsa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Bolsa {
	
	private static int TIMEOUT = 3000;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) {		
		try {			
			getJSONBolsaFamilia();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void getJSONBolsaFamilia(){
		List<EstadoVO> estadoVOs = new ArrayList<>();
		EstadoVO estadoVO;
		
		try {			
			for (Estado estado : getEstados()) {
				estadoVO = new EstadoVO(estado.getNome(), getCidadesEstado(estado.getNome(), estado.getQuantidadePaginas()));
				estadoVOs.add(estadoVO);
				
				createJSON(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(estadoVO),estado.nome);
			}
			createJSON(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(estadoVOs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Cidade> getCidadesEstado(String estado, int pagina){
		List<Cidade> cidades = new ArrayList<>();
		List<Pessoa> pessoas = new ArrayList<>();
		Cidade cidade = null;
		Document doc;
		int quantidadePaginas = 0;
		try {
			String urlToGetUl = "http://bolsa-familia.com/cidades/"+estado+"/1/1/1";
			doc = Jsoup.connect(urlToGetUl).timeout(TIMEOUT).get();
			Element ul = doc.select("ul[class=pagination]").first();
			quantidadePaginas = getPaginas(ul);
			
			for (int i = 1; i <= pagina; i++) {
				String url = "http://bolsa-familia.com/cidades/"+estado+"/"+i+"/1/1";
				System.out.println("loading... "+url);
				doc = Jsoup.connect(url).timeout(TIMEOUT).get();
				Element tableCidades = doc.select("table[class=table]").first();
				List<Element> trCidade = tableCidades.select("tr");
				
				for (int j = 0; j < trCidade.size(); j++) {
					List<Element> rows = trCidade.get(j).select("td");
					
					if (trCidade.get(j).text().contains("Ver Pessoas") || trCidade.get(j).text().contains("Ver Pagamentos")) {
						continue;
					} else {
						if ( rows.size() == 3) {
							cidade = new Cidade();
							cidade.setNome(rows.get(0).text());
							cidade.setPagamentos(rows.get(1).text());
							cidade.setValor(rows.get(2).text()); 
							cidade.setUrlCidade(rows.get(0).select("a[href]").attr("href"));
							String cidadeNome = rows.get(0).select("a[href]").attr("href")
									.substring(rows.get(0).select("a[href]").attr("href").lastIndexOf("/") + 1);
							pessoas = getPessoasCidade(estado, cidadeNome, quantidadePaginas, TIMEOUT);
							cidade.setPessoas(pessoas);
							cidades.add(cidade);
						}
					}
				}	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cidades;
	}
	
		
	public static List<Pessoa> getPessoasCidade(String estado, String cidade, int pagina, int timeout){
		System.out.println("@Buscando pessoa em cidade: " + cidade);
		List<Pessoa> pessoas = new ArrayList<>();
		Document doc;
		try {					
			for (int k = 1; k <= pagina; k++) {
				String urlNew = "http://bolsa-familia.com/pessoas/"+estado.toLowerCase()+"/"+ cidade +"/"+ k +"/1/1";
				System.out.println("@"+urlNew);
				doc = Jsoup.connect(urlNew).timeout(timeout).get();
				Element t = doc.select("table[class=table]").first();
				List<Element> trList = t.select("tr");
				
				for(int i = 0; i < trList.size(); i++){
					Pessoa pessoa;
					List<Element> rows = trList.get(i).select("td");
					if (trList.get(i).text().contains("Ver Pessoas") || trList.get(i).text().contains("Ver Pagamentos")) {
						continue;
					} else {
						if ( rows.size() == 3) {
							pessoa = new Pessoa();
							pessoa.setNome(rows.get(0).text());
							pessoa.setPagamentos(rows.get(1).text());
							pessoa.setValor(rows.get(2).text()); 
							pessoa.setUrlPessoa(rows.get(0).select("a[href]").attr("href"));
							
							List<PessoaInfo> pessoaInfos = getInfoPessoa(pessoa.getUrlPessoa());
							pessoa.setPessoaInfos(pessoaInfos);
							
							pessoas.add(pessoa);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoas;
	}
	
	public static List<PessoaInfo> getInfoPessoa(String urlPessoa){
		System.out.println("@Buscando pessoa info: " + urlPessoa);
		List<PessoaInfo> pessoaInfos = new ArrayList<>();
		Document doc;
		try {
			doc = Jsoup.connect(urlPessoa).timeout(TIMEOUT).get();
			Element t = doc.select("table[class=table]").first();
			List<Element> trList = t.select("tr");
			
			for(int i = 0; i < trList.size(); i++){
				List<Element> rows = trList.get(i).select("td");
				
				if ( rows.size() == 3) {
					PessoaInfo pessoaInfo = new PessoaInfo();
					
					String nome = rows.get(0).text().substring(0, rows.get(0).text().lastIndexOf(" ") + 1);
					String nis = rows.get(0).text().substring(rows.get(0).text().lastIndexOf(" ") + 1);
					String mes = rows.get(1).text().substring(0, rows.get(1).text().lastIndexOf("/") + 1);
					String ano = rows.get(1).text().substring(rows.get(1).text().lastIndexOf("/") + 1);
					String valor = rows.get(2).text().substring(0, rows.get(2).text().lastIndexOf(" ") + 1);
					pessoaInfo.setNome(nome.trim());
					pessoaInfo.setNIS(nis.trim());
					pessoaInfo.setMesRecebimento(mes.replace("/", "").trim());
					pessoaInfo.setAnoRecebimento(ano.trim());
					pessoaInfo.setValorRecebido(valor.trim());
					
					pessoaInfos.add(pessoaInfo);
				}
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pessoaInfos;
	}
	
	public static int getPaginas(Element ul){
		int pagina = 1;
		if (ul != null) {
			List<Element> lis = ul.select("li");
			if (lis != null) {
				if (lis.size() > 1) {
					lis.remove(lis.size() - 1);
					pagina = Integer.valueOf(lis.get(lis.size() - 1).text());
				} else {
					return 1;
				}
			}
		}
		return pagina;
	}

	
	public static void createJSON(String json, String estado, String cidade){
		 	File file = new File(estado + "_" + cidade+ ".json");
		 	
		 	if (file.exists()) {
		        file.delete();     
		     }
		 	
		    FileWriter writer = null;
		    try {
		        writer = new FileWriter(file);
		        writer.write(json);
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
		    }
		    System.out.printf("File is located at %s%n", file.getAbsolutePath());
	}
	
	public static void createJSON(String json, String name){
		
	 	File file = new File(name + ".json");
	 	
	 	if (file.exists()) {
	        file.delete();     
	     }
	 	
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write(json);
	    } catch (IOException e) {
	        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    System.out.printf("File is located at %s%n", file.getAbsolutePath());
}
	public static void createJSON(String json){
		
	 	File file = new File("bolsa_familia.json");
	 	
	 	if (file.exists()) {
	        file.delete();     
	     }
	 	
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write(json);
	    } catch (IOException e) {
	        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    System.out.printf("File is located at %s%n", file.getAbsolutePath());
}
	
	public static List<Estado> getEstados(){
		List<Estado> estados = new ArrayList<>();
		
		estados.add(new Estado("acre", 1));
		estados.add(new Estado("alagoas", 5));
		estados.add(new Estado("amapa", 1));
		estados.add(new Estado("amazonas", 3));
		estados.add(new Estado("bahia", 17));
		estados.add(new Estado("ceara", 8));
		estados.add(new Estado("distrito-federal", 1));
		estados.add(new Estado("espirito-santo", 4));
		estados.add(new Estado("goias", 10));
		estados.add(new Estado("maranhao", 9));
		estados.add(new Estado("mato-grosso", 6));
		estados.add(new Estado("mato-grosso-do-sul", 4));
		estados.add(new Estado("minas-gerais", 35));
		estados.add(new Estado("para", 6));
		estados.add(new Estado("paraiba", 9));
		estados.add(new Estado("parana", 16));
		estados.add(new Estado("pernambuco", 8));
		estados.add(new Estado("piaui", 9));
		estados.add(new Estado("rio-de-janeiro", 4));
		estados.add(new Estado("rio-grande-do-norte", 7));
		estados.add(new Estado("rio-grande-do-sul", 20));
		estados.add(new Estado("rondonia", 3));
		estados.add(new Estado("roraima", 1));
		estados.add(new Estado("santa-catarina", 12));
		estados.add(new Estado("sao-paulo", 26));
		estados.add(new Estado("sergipe", 3));
		estados.add(new Estado("tocantins", 6));
		return estados;
	}
	
	private static class Estado {
		private String nome;
		private int quantidadePaginas;
		
		public Estado(String nome, int quantidadePaginas) {
			this.nome = nome;
			this.quantidadePaginas = quantidadePaginas;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getQuantidadePaginas() {
			return quantidadePaginas;
		}

		public void setQuantidadePaginas(int quantidadePaginas) {
			this.quantidadePaginas = quantidadePaginas;
		}
		
	}

}
