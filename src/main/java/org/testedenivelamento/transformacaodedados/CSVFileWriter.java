package org.testedenivelamento.transformacaodedados;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter {
    private static final String CSV_FILE_PATH = "target/dados_extraidos.csv";

    public void writeDataToCSV(List<String[]> data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.writeAll(data);
            System.out.println("Dados salvos no arquivo CSV.");
        }
    }
}
