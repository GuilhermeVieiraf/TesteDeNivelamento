package org.testedenivelamento.transformacaodedados;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    public List<String[]> processData(List<String> rawData) {
        List<String[]> processedData = new ArrayList<>();

        for (String line : rawData) {
            String[] columns = line.split("\\s+");

            for (int i = 0; i < columns.length; i++) {
                if ("OD".equals(columns[i])) {
                    columns[i] = "Seg. Odontológica";
                } else if ("AMB".equals(columns[i])) {
                    columns[i] = "Seg. Ambulatorial";
                }
            }

            processedData.add(columns);
        }

        return processedData;
    }
}