package com.vehicule.gestion.modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class TraitementImage {
    static String urlServeurStockage = "https://api.imgbb.com/1/upload";
    // String cheminLocal;
    static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    public TraitementImage() {
    }

    public String ImageToBase64() throws Exception {
        File file = new File(this.getUPLOAD_DIRECTORY());
        byte[] fileContent = FileUtils.readFileToByteArray(file);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    public void Base64ToImage(String encodedString) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        File file = new File(this.getUPLOAD_DIRECTORY());
        FileUtils.writeByteArrayToFile(file, decodedBytes);
    }

    public String hebergementImage(String pathfichier) throws Exception {
        File file = new File(pathfichier);
        this.tuto(file);
        return String.valueOf(file.exists());
    }

    public void tuto(File fileToUpload) throws Exception {
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(uploadUrl);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", file, ContentType.APPLICATION_OCTET_STREAM, file.getName());

        httpPost.setEntity(builder.build());

        HttpResponse response = httpClient.execute(httpPost);

        // Handle the response as needed
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
    }

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

}
