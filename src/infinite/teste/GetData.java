package infinite.teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class GetData {
	
	public static void main(String[] args) {
	
		String url = "http://censo2010.ibge.gov.br/nomes/#/search/response/8";
		Document doc;
		try {
			//doc = Jsoup.connect(url).get();
			doc = Jsoup.parse("<select class='pure-u-23-24 ng-valid ng-dirty ng-touched' ng-model='criteria.municipio' ng-disabled='!criteria.UF || criteria.UF == '53''><option value=''>Munic�pio</option><!-- ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170025' class='ng-binding ng-scope'>Abreul�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170030' class='ng-binding ng-scope'>Aguiarn�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170035' class='ng-binding ng-scope'>Alian�a do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170040' class='ng-binding ng-scope'>Almas</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170070' class='ng-binding ng-scope'>Alvorada</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170100' class='ng-binding ng-scope'>Anan�s</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170105' class='ng-binding ng-scope'>Angico</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170110' class='ng-binding ng-scope'>Aparecida do Rio Negro</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170130' class='ng-binding ng-scope'>Aragominas</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170190' class='ng-binding ng-scope'>Araguacema</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170200' class='ng-binding ng-scope'>Aragua�u</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170210' class='ng-binding ng-scope'>Aragua�na</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170215' class='ng-binding ng-scope'>Araguan�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170220' class='ng-binding ng-scope'>Araguatins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170230' class='ng-binding ng-scope'>Arapoema</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170240' class='ng-binding ng-scope'>Arraias</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170255' class='ng-binding ng-scope'>Augustin�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170270' class='ng-binding ng-scope'>Aurora do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170290' class='ng-binding ng-scope'>Axix� do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170300' class='ng-binding ng-scope'>Baba�ul�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170305' class='ng-binding ng-scope'>Bandeirantes do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170307' class='ng-binding ng-scope'>Barra do Ouro</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170310' class='ng-binding ng-scope'>Barrol�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170320' class='ng-binding ng-scope'>Bernardo Say�o</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170330' class='ng-binding ng-scope'>Bom Jesus do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170360' class='ng-binding ng-scope'>Brasil�ndia do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170370' class='ng-binding ng-scope'>Brejinho de Nazar�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170380' class='ng-binding ng-scope'>Buriti do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170382' class='ng-binding ng-scope'>Cachoeirinha</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170384' class='ng-binding ng-scope'>Campos Lindos</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170386' class='ng-binding ng-scope'>Cariri do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170388' class='ng-binding ng-scope'>Carmol�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170389' class='ng-binding ng-scope'>Carrasco Bonito</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170390' class='ng-binding ng-scope'>Caseara</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170410' class='ng-binding ng-scope'>Centen�rio</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170510' class='ng-binding ng-scope'>Chapada da Natividade</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170460' class='ng-binding ng-scope'>Chapada de Areia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170550' class='ng-binding ng-scope'>Colinas do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171670' class='ng-binding ng-scope'>Colm�ia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170555' class='ng-binding ng-scope'>Combinado</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170560' class='ng-binding ng-scope'>Concei��o do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170600' class='ng-binding ng-scope'>Couto Magalh�es</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170610' class='ng-binding ng-scope'>Cristal�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170625' class='ng-binding ng-scope'>Crix�s do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170650' class='ng-binding ng-scope'>Darcin�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170700' class='ng-binding ng-scope'>Dian�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170710' class='ng-binding ng-scope'>Divin�polis do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170720' class='ng-binding ng-scope'>Dois Irm�os do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170730' class='ng-binding ng-scope'>Duer�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170740' class='ng-binding ng-scope'>Esperantina</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170755' class='ng-binding ng-scope'>F�tima</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170765' class='ng-binding ng-scope'>Figueir�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170770' class='ng-binding ng-scope'>Filad�lfia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170820' class='ng-binding ng-scope'>Formoso do Araguaia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170825' class='ng-binding ng-scope'>Fortaleza do Taboc�o</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170830' class='ng-binding ng-scope'>Goianorte</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170900' class='ng-binding ng-scope'>Goiatins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170930' class='ng-binding ng-scope'>Guara�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170950' class='ng-binding ng-scope'>Gurupi</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='170980' class='ng-binding ng-scope'>Ipueiras</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171050' class='ng-binding ng-scope'>Itacaj�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171070' class='ng-binding ng-scope'>Itaguatins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171090' class='ng-binding ng-scope'>Itapiratins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171110' class='ng-binding ng-scope'>Itapor� do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171150' class='ng-binding ng-scope'>Ja� do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171180' class='ng-binding ng-scope'>Juarina</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171190' class='ng-binding ng-scope'>Lagoa da Confus�o</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171195' class='ng-binding ng-scope'>Lagoa do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171200' class='ng-binding ng-scope'>Lajeado</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171215' class='ng-binding ng-scope'>Lavandeira</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171240' class='ng-binding ng-scope'>Lizarda</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171245' class='ng-binding ng-scope'>Luzin�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171250' class='ng-binding ng-scope'>Marian�polis do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171270' class='ng-binding ng-scope'>Mateiros</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171280' class='ng-binding ng-scope'>Mauril�ndia do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171320' class='ng-binding ng-scope'>Miracema do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171330' class='ng-binding ng-scope'>Miranorte</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171360' class='ng-binding ng-scope'>Monte do Carmo</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171370' class='ng-binding ng-scope'>Monte Santo do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171395' class='ng-binding ng-scope'>Muricil�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171420' class='ng-binding ng-scope'>Natividade</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171430' class='ng-binding ng-scope'>Nazar�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171488' class='ng-binding ng-scope'>Nova Olinda</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171500' class='ng-binding ng-scope'>Nova Rosal�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171510' class='ng-binding ng-scope'>Novo Acordo</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171515' class='ng-binding ng-scope'>Novo Alegre</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171525' class='ng-binding ng-scope'>Novo Jardim</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171550' class='ng-binding ng-scope'>Oliveira de F�tima</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172100' class='ng-binding ng-scope'>Palmas</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171570' class='ng-binding ng-scope'>Palmeirante</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171380' class='ng-binding ng-scope'>Palmeiras do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171575' class='ng-binding ng-scope'>Palmeir�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171610' class='ng-binding ng-scope'>Para�so do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171620' class='ng-binding ng-scope'>Paran�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171630' class='ng-binding ng-scope'>Pau D'Arco</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171650' class='ng-binding ng-scope'>Pedro Afonso</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171660' class='ng-binding ng-scope'>Peixe</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171665' class='ng-binding ng-scope'>Pequizeiro</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171700' class='ng-binding ng-scope'>Pindorama do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171720' class='ng-binding ng-scope'>Piraqu�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171750' class='ng-binding ng-scope'>Pium</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171780' class='ng-binding ng-scope'>Ponte Alta do Bom Jesus</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171790' class='ng-binding ng-scope'>Ponte Alta do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171800' class='ng-binding ng-scope'>Porto Alegre do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171820' class='ng-binding ng-scope'>Porto Nacional</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171830' class='ng-binding ng-scope'>Praia Norte</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171840' class='ng-binding ng-scope'>Presidente Kennedy</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171845' class='ng-binding ng-scope'>Pugmil</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171850' class='ng-binding ng-scope'>Recursol�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171855' class='ng-binding ng-scope'>Riachinho</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171865' class='ng-binding ng-scope'>Rio da Concei��o</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171870' class='ng-binding ng-scope'>Rio dos Bois</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171875' class='ng-binding ng-scope'>Rio Sono</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171880' class='ng-binding ng-scope'>Sampaio</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171884' class='ng-binding ng-scope'>Sandol�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171886' class='ng-binding ng-scope'>Santa F� do Araguaia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171888' class='ng-binding ng-scope'>Santa Maria do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171889' class='ng-binding ng-scope'>Santa Rita do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171890' class='ng-binding ng-scope'>Santa Rosa do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='171900' class='ng-binding ng-scope'>Santa Tereza do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172000' class='ng-binding ng-scope'>Santa Terezinha do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172010' class='ng-binding ng-scope'>S�o Bento do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172015' class='ng-binding ng-scope'>S�o F�lix do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172020' class='ng-binding ng-scope'>S�o Miguel do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172025' class='ng-binding ng-scope'>S�o Salvador do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172030' class='ng-binding ng-scope'>S�o Sebasti�o do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172049' class='ng-binding ng-scope'>S�o Val�rio</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172065' class='ng-binding ng-scope'>Silvan�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172080' class='ng-binding ng-scope'>S�tio Novo do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172085' class='ng-binding ng-scope'>Sucupira</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172090' class='ng-binding ng-scope'>Taguatinga</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172093' class='ng-binding ng-scope'>Taipas do Tocantins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172097' class='ng-binding ng-scope'>Talism�</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172110' class='ng-binding ng-scope'>Tocant�nia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172120' class='ng-binding ng-scope'>Tocantin�polis</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172125' class='ng-binding ng-scope'>Tupirama</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172130' class='ng-binding ng-scope'>Tupiratins</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172208' class='ng-binding ng-scope'>Wanderl�ndia</option><!-- end ngRepeat: municipio in municipioCollection --><option ng-repeat='municipio in municipioCollection' value='172210' class='ng-binding ng-scope'>Xambio�</option><!-- end ngRepeat: municipio in municipioCollection --></select>");
			
			List<Municipio> municipios = new ArrayList<>();
			Elements options = doc.getElementsByTag("option");
			Municipio municipio = null;
			
			for (int i = 0; i < options.size(); i++) {
				Element option = options.get(i);
				municipio = new Municipio(); 
				
				String opt = option.toString();
				String pattern = "(?i)(<option.*?>)(.+?)(</option>)";
				
				if ( option.attr("value").equals("")) {
					municipio.setId(0);
					municipio.setCodigo("NA");
					municipio.setNome(opt.replaceAll(pattern, "$2"));
				} else {
					municipio.setId(i);
					municipio.setCodigo(option.val());
					municipio.setNome(opt.replaceAll(pattern, "$2"));
					
					
				}
				
				municipios.add(municipio);
					
				//System.out.println(opt.replaceAll(pattern, "$2"));
			}
			
			Gson gson = new Gson();
			String list = gson.toJson(municipios);
			System.out.println(list);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
