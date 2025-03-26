package org.testedenivelamento.transformacaodedados;

import java.io.IOException;
import java.util.List;

public class MainTransformacao {

    public static void main(String[] args) {
        try {
            PDFExtractor extractor = new PDFExtractor();
            List<String> rawData = extractor.extractPDFData();

            DataProcessor processor = new DataProcessor();
            List<String[]> processedData = processor.processData(rawData);

            CSVFileWriter csvFileWriter = new CSVFileWriter();
            csvFileWriter.writeDataToCSV(processedData);

            ZipCompressor zipCompressor = new ZipCompressor();
            zipCompressor.compressCSV();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}