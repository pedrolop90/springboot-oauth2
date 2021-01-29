package com.ejemplo.gradle.spring.securityoauth2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedro
 */
@RestController
@RequestMapping("saludos")
@RequiredArgsConstructor
public class SaludoController {

    @GetMapping
    public String saludoBien() {
        return "Saludo Bien!!";
    }

}
