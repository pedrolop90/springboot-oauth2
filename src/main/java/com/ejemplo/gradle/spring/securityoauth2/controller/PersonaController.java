package com.ejemplo.gradle.spring.securityoauth2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedro
 */
@RestController
@RequestMapping("personas")
@RequiredArgsConstructor
public class PersonaController {

    @GetMapping("admin")
    @PreAuthorize("hasAuthority('ADMIN_READ')")
    public String saludoAdmin() {
        return "Hola admin!!";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('CLIENT_READ')")
    public String saludoPersona() {
        return "Hola Persona!!";
    }
}
