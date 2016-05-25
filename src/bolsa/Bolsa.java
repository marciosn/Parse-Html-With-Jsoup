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
		
		getPessoasCidade("ceara", "quixada");
	}
	
	public static void getPessoasCidade(String estado ,String cidade){
		List<CearaCidades> cidades = new ArrayList<>();
		Document doc;
		try {			
			int tamanho = 84;
			
			for (int k = 1; k <= tamanho; k++) {
				String urlNew = "http://bolsa-familia.com/pessoas/"+estado.toLowerCase()+"/"+ cidade +"/"+ k +"/1/1";
				System.out.println("### "+urlNew);
				doc = Jsoup.connect(urlNew).timeout(5000).get();
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
			
			Gson gson = new Gson();
			System.out.println(gson.toJson(cidades));
			ObjectMapper mapper = new ObjectMapper();  
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cidades));
			
			createJSON(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cidades),"ceara","abaiara");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createJSON(String json, String estado, String cidade){
		
		 	File file = new File(estado + "_" + cidade+ ".json");
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
		
/*		try (FileWriter file = new FileWriter("/Jsoup/json/" + estado + "_" + cidade + ".json")) {
			file.write(json);
			System.out.println("Successfully Copied JSON Object to File...");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
