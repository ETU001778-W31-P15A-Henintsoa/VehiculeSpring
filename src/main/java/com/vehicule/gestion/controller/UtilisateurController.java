// package com.vehicule.gestion.controller;

// import java.util.Map;

// import com.vehicule.gestion.auth.AuthenticationRequest;
// import com.vehicule.gestion.auth.RegisterRequest;
// import com.vehicule.gestion.service.AuthenticationService;
// import com.vehicule.gestion.tools.Util;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatusCode;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/initial")
// public class UtilisateurController {

//   @Autowired
//   private AuthenticationService service;

//   @GetMapping("/hello")
//   public String register() {
//     return "Hello";
//   }

//   @PostMapping("/inscription")
//   public ResponseEntity<Map<String, Object>> register(
//     @RequestBody RegisterRequest request
//   ) throws Exception{
//     Map<String, Object> response = Util.getDefaultResponse();
//     response.put("response", service.register(request));
//     return new ResponseEntity<Map<String, Object>>(
//       response,
//       HttpStatusCode.valueOf(400)
//     );
//   }

//   @PostMapping("/login")
//   public ResponseEntity<Map<String, Object>> auth(
//     @RequestBody AuthenticationRequest request
//   ) {
//     Map<String, Object> response = Util.getDefaultResponse();
//     response.put("response", service.authenticate(request));
//     return new ResponseEntity<Map<String, Object>>(
//       response,
//       HttpStatusCode.valueOf(400)
//     );
//   }
// }
