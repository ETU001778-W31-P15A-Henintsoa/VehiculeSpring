package com.vehicule.gestion.controller;

import java.io.File;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.TraitementImage;

import org.hibernate.cache.spi.FilterKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ControllerImage {

    @Autowired
    private Gson gson = new Gson();
    private ApiResponse reponse;

    // @Transactional(rollbackOn = Exception.class)
    @GetMapping("/traitementimage")
    public ResponseEntity<String> traitementImage() {
        try {
            TraitementImage timage = new TraitementImage();
            timage.setCheminLocal("C:/Users/ITU/Desktop/VehiculeSpring/img/Peugeot-405-02.jpg");
            return ResponseEntity.ok(timage.ImageToBase64());
        } catch (Exception e) {
            // e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @GetMapping("/traitementimage/{liens}")
    public ResponseEntity<String> existanceImage(@PathVariable("liens") String liens) {
        try {
            File file = new File(liens);
            // timage.setCheminLocal("C:/Users/ITU/Desktop/VehiculeSpring/img/Peugeot-405-02.jpg");
            return ResponseEntity.ok(String.valueOf(file.exists()));
        } catch (Exception e) {
            // e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/uploadimage")
    public String displayUploadForm() {
        return "imageupload/index";
    }

    @PostMapping("/upload")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file) {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        return "imageupload/index";
    }
}
