package com.example.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Holamundo {

    @GetMapping("/saludo")
    public String saludo() {
        return "Hola Mundo";
    }

    @PostMapping("/login")
    public String login(@RequestParam String nickname, @RequestParam String password, @RequestParam int edad) {
        String mensaje = "";
        if (edad < 18) {
            mensaje = "El edad debe ser mayor de 18";
        } else {
            mensaje = "el nickname es " + nickname + " la password es " + password + " eres mayor de edad";
        }
        return mensaje;
    }

    @PostMapping("/libro")
    public Libro formLibro(@RequestParam String isbn, @RequestParam String titulo, @RequestParam String autor) {
        return new Libro(isbn, titulo, autor);
    }
}
