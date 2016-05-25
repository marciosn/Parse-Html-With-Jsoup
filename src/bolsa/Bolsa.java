package bolsa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class Bolsa {
	
	public static void main(String[] args) {

		List<CearaCidades> cidades = new ArrayList<>();
		String url = "http://bolsa-familia.com/cidades/ceara/8/1/1";
		Document doc;
		try {
			doc = Jsoup.connect(url).get();		
			Element table = doc.select("table[class=table]").first();
			Elements links = null;
			//List<Element> tds = table.select("td");
			List<Element> trs = table.select("tr");
			
			int tamanho = 84;
			
			for (int k = 1; k <= tamanho; k++) {
				String urlNew = "http://bolsa-familia.com/pessoas/ceara/abaiara/"+ k +"/1/1";
				System.out.println("### "+urlNew);
				doc = Jsoup.connect(urlNew).timeout(5000).get();
				Element t = doc.select("table[class=table]").first();
				List<Element> trList = t.select("tr");
				//System.out.println(t);
				
				
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
			
			/*for(int i = 0; i < trs.size(); i++){
				CearaCidades cearaCidades;
				List<Element> rows = trs.get(i).select("td");
				if (trs.get(i).text().contains("Ver Pessoas") || trs.get(i).text().contains("Ver Pagamentos")) {
					continue;
				} else {
					if ( rows.size() == 3) {
						cearaCidades = new CearaCidades();
						System.out.println(rows.get(0).text());
						System.out.println(rows.get(1).text());
						System.out.println(rows.get(2).text());
						System.out.println(rows.get(0).select("a[href]").attr("href"));
						
						cearaCidades.setNome(rows.get(0).text());
						cearaCidades.setPagamentos(rows.get(1).text());
						cearaCidades.setValor(rows.get(2).text()); 
						cearaCidades.setUrlCidade(rows.get(0).select("a[href]").attr("href"));
						cidades.add(cearaCidades);
					}
				}
			}
			
			//Gson gson = new Gson();
			//System.out.println(gson.toJson(cidades));
			ObjectMapper mapper = new ObjectMapper();  
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cidades));
*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
