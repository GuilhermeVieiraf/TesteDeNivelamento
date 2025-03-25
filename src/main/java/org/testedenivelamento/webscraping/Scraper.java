package org.testedenivelamento.webscraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scraper {

    private static final String URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

    private List<String> pdfLinks = new ArrayList<>();

    public void scrape() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            String href = link.attr("abs:href");
            if (href.endsWith(".pdf") && (href.contains("Anexo_I") || href.contains("Anexo_II"))) {
                pdfLinks.add(href);
                System.out.println("Link encontrado: " + href);
            }
        }
    }

    public List<String> getPdfLinks() {
        return pdfLinks;
    }
}
