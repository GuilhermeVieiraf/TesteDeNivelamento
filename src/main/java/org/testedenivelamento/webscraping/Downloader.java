package org.testedenivelamento.webscraping;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.List;

public class Downloader {
    private static final String DOWNLOAD_DIR = "src/main/resources";

    public void downloadFiles(List<String> links) throws IOException {
        Files.createDirectories(Paths.get(DOWNLOAD_DIR));

        for (String link : links) {
            String fileName = link.substring(link.lastIndexOf("/") + 1);
            Path outputPath = Paths.get(DOWNLOAD_DIR, fileName);
            URL url = new URL(link);

            try (InputStream in = url.openStream()) {
                Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Arquivo salvo em: " + outputPath);
            }
        }
    }
}