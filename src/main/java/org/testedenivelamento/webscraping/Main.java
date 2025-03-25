package org.testedenivelamento.webscraping;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Scraper scraper = new Scraper();
            Downloader downloader = new Downloader();
            CompactadorDeArquivos compactador = new CompactadorDeArquivos();

            scraper.scrape();

            List<String> pdfLinks = scraper.getPdfLinks();

            downloader.downloadFiles(pdfLinks);

            compactador.ziparArquivos();

            System.out.println("Processo de download e compactação concluído com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
