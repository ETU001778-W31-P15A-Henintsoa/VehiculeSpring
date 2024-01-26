package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.jayway.jsonpath.internal.Path;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Mail;
import com.vehicule.gestion.modele.Message;
import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.service.ServiceMail;
import com.vehicule.gestion.service.ServiceMessage;
import com.vehicule.gestion.service.UtilisateurService;
import com.vehicule.gestion.tools.Role;

@RestController
// @RequestMapping("/api/people")
public class ControllerMail {

    @Autowired
    private ServiceMail servicemail;
    private UtilisateurService utilisateurService;
    private ServiceMessage servicemessage;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @PostMapping("mail/{idreceveur}/{message}/{files}")
    public ResponseEntity<String> save(@PathVariable("idreceveur") String receveur,
            @PathVariable("message") String message, @PathVariable("files") List<MultipartFile> path) {
        try {
            // String mailEnvoyeur =
            // String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

            // Utilisateur envoyeur = utilisateurService.findByMail(mailEnvoyeur).get();
            // Utilisateur recepteur = utilisateurService.findById(receveur).get();
            // List<Utilisateur> listesUtilisateur = utilisateurService.getAll();
            // servicemail.save(mails);

            // Mail mails = new Mail(envoyeur, recepteur, listesUtilisateur);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Mail essaie = new Mail();
            // essaie.setIdUtilisateurEnvoyeur(new Utilisateur("HERINJANAHARY", "Lova
            // Henintsoa", "GVAS 8 Soamanandrariny",
            // "h.lovahenintsoa@gmail.com", "password", 0, dateFormat.parse("2004-03-04"),
            // Role.ROLE_USER));
            // essaie.setIdUtilisateurReceveur(new Utilisateur("Tahinjanahary", "Fiderana",
            // "Ambohipo",
            // "fideranatahinjanahary@gmail.com", "motdepasse", 0,
            // dateFormat.parse("2004-06-14"),
            // Role.ROLE_USER));

            // servicemail.save(essaie);

            List<Mail> lesMails = servicemail.getAll();

            Message messages = new Message(lesMails.get(lesMails.size() - 1), message,
                    false, false);
            servicemessage.save(messages);

            // Boucle Insertion image dans la base de donnee meme que dans le premier
            // enregistrement de message

            reponse = new ApiResponse("", lesMails);

            return ResponseEntity.status(500).body(gson.toJson(reponse));

        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<String>(
                String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()),
                HttpStatus.OK);
    }

    // Read operations
    // @GetMapping
    // public ResponseEntity<List<Person>> getAllPeople() {
    // List<Person> people = personService.getAllPeople();
    // return new ResponseEntity<>(people, HttpStatus.OK);
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<Person> getPersonById(@PathVariable String id) {
    // Optional<Person> person = personService.getPersonById(id);
    // return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
    // .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }

    // // Update operation
    // @PutMapping("/{id}")
    // public ResponseEntity<Person> updatePerson(@PathVariable String id,
    // @RequestBody Person person) {
    // Optional<Person> existingPerson = personService.getPersonById(id);

    // if (existingPerson.isPresent()) {
    // person.setId(id);
    // Person updatedPerson = personService.updatePerson(person);
    // return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // // Delete operation
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deletePerson(@PathVariable String id) {
    // Optional<Person> existingPerson = personService.getPersonById(id);

    // if (existingPerson.isPresent()) {
    // personService.deletePersonById(id);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }
}
