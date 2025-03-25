package org.testedenivelamento.webscraping;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactadorDeArquivos {

    public void ziparArquivos() {
        try {
            String diretorioArquivos = "src/main/resources/";
            String arquivoZip = "src/main/resources/arquivos_compactados.zip";

            FileOutputStream fos = new FileOutputStream(arquivoZip);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            File pasta = new File(diretorioArquivos);
            File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".pdf"));

            if (arquivos != null && arquivos.length > 0) {
                for (File arquivo : arquivos) {
                    FileInputStream fis = new FileInputStream(arquivo);
                    ZipEntry zipEntry = new ZipEntry(arquivo.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        zipOut.write(buffer, 0, len);
                    }

                    fis.close();

                    if (arquivo.delete()) {
                        System.out.println("Arquivo PDF excluído: " + arquivo.getName());
                    } else {
                        System.err.println("Erro ao excluir o arquivo: " + arquivo.getName());
                    }
                }
            } else {
                System.err.println("Nenhum arquivo PDF encontrado para compactar.");
            }

            zipOut.close();
            fos.close();
            System.out.println("Arquivos compactados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao compactar os arquivos: " + e.getMessage());
        }
    }
}
