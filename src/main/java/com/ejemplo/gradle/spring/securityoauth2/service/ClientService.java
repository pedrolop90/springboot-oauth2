package com.ejemplo.gradle.spring.securityoauth2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@RequiredArgsConstructor
public class ClientService implements ClientDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails clientDetails = new BaseClientDetails(
                "client_read",
                "service",
                "read",
                "client_credentials",
                "CLIENT_READ"
        );
        clientDetails.setClientSecret(
                passwordEncoder.encode("1234567890")
        );
        return clientDetails;
    }
}
