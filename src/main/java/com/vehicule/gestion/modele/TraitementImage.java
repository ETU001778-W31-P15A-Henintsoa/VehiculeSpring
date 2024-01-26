package com.vehicule.gestion.modele;

// import java.io.BufferedReader;
import java.io.File;
// import java.io.FileInputStream;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.OutputStream;
// import java.io.OutputStreamWriter;
// import java.io.PrintWriter;
// import java.net.URL;
// import java.net.URLConnection;
// import java.net.http.HttpClient;
// import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class TraitementImage {
    static String apikey = "b6b7a7b84eddd705bfa4e3357e418627";
    static String urlServeurStockage = "https://api.imgbb.com/1/upload";
    static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    public TraitementImage() {
    }

    public List<byte[]> Base64ToImage(List<String> encodedString) throws Exception {
        List<byte[]> images = new ArrayList<>();
        for (String string : encodedString) {
            images.add(Base64.getDecoder().decode(string));
        }
        return images;
    }

    public String hebergementImage(String pathfichier) throws Exception {
        File file = new File(pathfichier);
        return String.valueOf(file.exists());
    }

    public String uploadImage(MultipartFile fichier) throws Exception {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(this.getUPLOAD_DIRECTORY(), fichier.getOriginalFilename());
        fileNames.append(fichier.getOriginalFilename());
        Files.write(fileNameAndPath, fichier.getBytes());
        return this.getUPLOAD_DIRECTORY() + "/" + String.valueOf(fileNameAndPath.getFileName());
    }

    public String getUrlServeurStockage() {
        return urlServeurStockage;
    }

    public void setUrlServeurStockage(String urlServeurStockage) {
        this.urlServeurStockage = urlServeurStockage;
    }

    public static String getUPLOAD_DIRECTORY() {
        return UPLOAD_DIRECTORY;
    }

    public static void setUPLOAD_DIRECTORY(String uPLOAD_DIRECTORY) {
        UPLOAD_DIRECTORY = uPLOAD_DIRECTORY;
    }

    public static String getApikey() {
        return apikey;
    }

    public static void setApikey(String apikey) {
        TraitementImage.apikey = apikey;
    }

}
