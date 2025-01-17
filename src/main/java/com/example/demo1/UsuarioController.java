package com.example.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @GetMapping("/getUser")
    public Usuario getUsuario(@RequestParam String nickname, @RequestParam String password) {
        return new Usuario(nickname, password);
    }

    @PostMapping("/postUser")
    public Usuario postUsuario(@RequestParam String nickname, @RequestParam String password) {
        if (password.length() < 8 || password.length() > 16) {
            throw new IllegalArgumentException("La contraseña debe tener entre 8 y 16 caracteres.");
        }

        String regex = "^[A-Za-z0-9]+$";
        if (!password.matches(regex)) {
            throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula, una minúscula y un número, y no debe incluir caracteres especiales.");
        }

        return new Usuario(nickname, password);
    }
}
