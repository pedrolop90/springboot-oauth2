package com.ejemplo.gradle.spring.securityoauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author pedro
 */
@Configuration
public class PasswordEncode {

    @Bean
    public PasswordEncoder passwordEnc() {
        return new BCryptPasswordEncoder();
    }

}
