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

import com.google.gson.Gson;

public class Bolsa {
	
	public static void main(String[] args) {
		String url = "http://bolsa-familia.com/cidades/ceara/1/1/1";
		Document doc;
		
		try {
			
			doc = Jsoup.connect(url).timeout(3000).get();
			Element tableCidades = doc.select("table[class=table]").first();
			List<Element> trCidade = tableCidades.select("tr");
			
			for (int j = 0; j < trCidade.size(); j++) {
				List<Element> rows = trCidade.get(j).select("td");
				
				if (trCidade.get(j).text().contains("Ver Pessoas") || trCidade.get(j).text().contains("Ver Pagamentos")) {
					continue;
				} else {
					if ( rows.size() == 3) {
						System.out.println("Nome da cidade " + rows.get(0).text());
						System.out.println("Pagementos da cidade " + rows.get(1).text());
						System.out.println("Valor da cidade " + rows.get(2).text());
						System.out.println("Url da cidade " + rows.get(0).select("a[href]").attr("href"));
						System.out.println("\n");
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//getPessoasCidade("ceara", "quixada", 499, 4000);
	}
	
	public List<Estado> getEstados(){
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
	
	public static void getCidadesEstado(String estado){
		Document doc;
		
		try {
			
			String url = "http://bolsa-familia.com/cidades/ceara/1/1/1";
			doc = Jsoup.connect(url).timeout(3000).get();
			Element tableCidades = doc.select("table[class=table]").first();
			List<Element> trCidade = tableCidades.select("tr");
			
			for (int j = 0; j < trCidade.size(); j++) {
				List<Element> rows = trCidade.get(j).select("td");
				
				if (trCidade.get(j).text().contains("Ver Pessoas") || trCidade.get(j).text().contains("Ver Pagamentos")) {
					continue;
				} else {
					if ( rows.size() == 3) {
						System.out.println("Nome da cidade " + rows.get(0).text());
						System.out.println("Pagementos da cidade " + rows.get(1).text());
						System.out.println("Valor da cidade " + rows.get(2).text());
						System.out.println("Url da cidade " + rows.get(0).select("a[href]").attr("href"));
						System.out.println("\n");
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getPessoasCidade(String estado,String cidade, int tamanhoLista, int timeout){
		List<CearaCidades> cidades = new ArrayList<>();
		Document doc;
		try {					
			for (int k = 1; k <= tamanhoLista; k++) {
				String urlNew = "http://bolsa-familia.com/pessoas/"+estado.toLowerCase()+"/"+ cidade +"/"+ k +"/1/1";
				System.out.println("### "+urlNew);
				doc = Jsoup.connect(urlNew).timeout(timeout).get();
				Element t = doc.select("table[class=table]").first();
				List<Element> trList = t.select("tr");
				
				for(int i = 0; i < trList.size(); i++){
					CearaCidades cearaCidades;
					List<Element> rows = trList.get(i).select("td");
					if (trList.get(i).text().contains("Ver Pessoas") || trList.get(i).text().contains("Ver Pagamentos")) {
						continue;
					} else {
						if ( rows.size() == 3) {
							cearaCidades = new CearaCidades();
							cearaCidades.setNome(rows.get(0).text());
							cearaCidades.setPagamentos(rows.get(1).text());
							cearaCidades.setValor(rows.get(2).text()); 
							cearaCidades.setUrlCidade(rows.get(0).select("a[href]").attr("href"));
							cidades.add(cearaCidades);
						}
					}
				}
			}
			
			//Gson gson = new Gson();
			//System.out.println(gson.toJson(cidades));
			ObjectMapper mapper = new ObjectMapper();  
			//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cidades));
			
			createJSON(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cidades),estado,cidade);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
		    } finally {
		        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
		    }
		    System.out.printf("File is located at %s%n", file.getAbsolutePath());
	}
	
	private class Estado {
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
