package com.vehicule.gestion.modele;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
// import java.io.IOException;
// import java.net.http.HttpClient;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
// import org.springframework.boot.autoconfigure.ssl.SslProperties.Bundles.Watch.File;
import org.apache.tomcat.util.http.fileupload.FileItemStream;

public class TraitementImage {
    String urlServeurStockage;
    String cheminLocal;

    public TraitementImage() {
    }

    public TraitementImage(String urlServeurStockage) {
        this.setUrlServeurStockage("https://api.imgbb.com/1/upload");
        this.urlServeurStockage = urlServeurStockage;
    }

    public String ImageToBase64() throws Exception {
        File file = new File(this.getCheminLocal());
        byte[] fileContent = FileUtils.readFileToByteArray(file);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    public void Base64ToImage(String encodedString) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        File file = new File(this.getCheminLocal());
        FileUtils.writeByteArrayToFile(file, decodedBytes);
    }

    public void hebergementImage(FileItemStream item) throws Exception {
        File file = new File(this.getCheminLocal());
        // File savedFile = new
        File savedFile = new File(file.getAbsolutePath() + File.separator + item.getName());
        FileOutputStream fos = new FileOutputStream(savedFile);
        InputStream is = item.openStream();
        int x = 0;
        byte[] b = new byte[1024];
        while ((x = is.read(b)) != -1) {
            fos.write(b, 0, x);
        }
        fos.flush();
        fos.close();
    }

    public String getUrlServeurStockage() {
        return urlServeurStockage;
    }

    public void setUrlServeurStockage(String urlServeurStockage) {
        this.urlServeurStockage = urlServeurStockage;
    }

    public String getCheminLocal() {
        return cheminLocal;
    }

    public void setCheminLocal(String cheminLocal) {
        this.cheminLocal = cheminLocal;
    }

}
