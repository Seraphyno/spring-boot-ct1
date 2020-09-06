package com.example.spring.boot.controllers;

import com.example.spring.boot.entities.User;
import com.example.spring.boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // intorc un ResponseEntity, ca sa am control asupra continutului raspunsului si al statusului
    // in situatia in care totul e ok (200) -> in body ma asigur ca apare un id
    // in situatia in care se intampla ceva la salvare, atunci vreau sa apara un mesaj de eroare in corp
    // cat mai usor de inteles de catre user
    @PostMapping
    public ResponseEntity<String> save(@RequestBody User user) {
        try {
            User saveUser = userService.saveUser(user);
            String message = String.format("Succesfully saved bobita, cu id: %s", saveUser.getId());
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Nu am putut salva! Username-ul este duplicat.");
        }
    }
}
