package com.vehicule.gestion.modele;

import java.io.File;
// import java.io.IOException;
// import java.net.http.HttpClient;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
// import org.springframework.boot.autoconfigure.ssl.SslProperties.Bundles.Watch.File;

public class TraitementImage {
    String urlServeurStockage;
    String cheminLocal;

    public TraitementImage() {
    }

    public TraitementImage(String urlServeurStockage) {
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
