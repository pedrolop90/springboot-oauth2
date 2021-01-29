package com.ejemplo.gradle.spring.securityoauth2.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@ConfigurationProperties(prefix = "oauth2.seguridad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OauthProperties {

    private String keySecret;


}
