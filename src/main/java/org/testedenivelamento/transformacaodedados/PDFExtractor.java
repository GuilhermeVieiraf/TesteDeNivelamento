package org.testedenivelamento.transformacaodedados;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PDFExtractor {
    private static final String PDF_URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf";

    public List<String> extractPDFData() throws IOException {
        PDDocument document = PDDocument.load(new URL(PDF_URL).openStream());
        PDFTextStripper stripper = new PDFTextStripper();
        String pdfText = stripper.getText(document);
        document.close();

        String[] lines = pdfText.split("\n");

        List<String> extractedData = new ArrayList<>();
        for (String line : lines) {
            extractedData.add(line.trim());
        }

        return extractedData;
    }
}
