package org.testedenivelamento.transformacaodedados;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompressor {
    private static final String ZIP_FILE_PATH = "target/Teste_" + System.getProperty("user.name") + ".zip";
    private static final String CSV_FILE_PATH = "target/dados_extraidos.csv";

    public void compressCSV() throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(CSV_FILE_PATH));
             ZipOutputStream zipOut = new ZipOutputStream(new java.io.FileOutputStream(ZIP_FILE_PATH))) {
            ZipEntry zipEntry = new ZipEntry(new File(CSV_FILE_PATH).getName());
            zipOut.putNextEntry(zipEntry);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zipOut.write(buffer, 0, length);
            }
            zipOut.closeEntry();
            System.out.println("Arquivo compactado: " + ZIP_FILE_PATH);
        }
    }
}
