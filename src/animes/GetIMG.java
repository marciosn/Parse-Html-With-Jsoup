package animes;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetIMG {
	
	public static void main(String[] args) {

		List<String> animes = new ArrayList<>();
		String url = "https://wall.alphacoders.com/by_sub_category.php?id=173173";
		Document doc;
		try {
			doc = Jsoup.connect(url).get();		
			Element div  = doc.getElementsByClass("center").get(2);
			Elements img = div.select("img");
			
			for (int i = 0; i < img.size(); i++) {
				Element image = img.get(i).select("img").first();
				String urlIMAGE = image.absUrl("src");
				
				if (urlIMAGE.contains("static"))
					continue;
				animes.add(urlIMAGE);
			}
			
			for (String s : animes) {
				System.out.println(s);				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
