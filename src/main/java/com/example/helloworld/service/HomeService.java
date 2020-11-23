package com.example.helloworld.service;

import com.example.helloworld.model.UsersContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpMethod.GET;

@Service
@Slf4j
public class HomeService {

    private final Constantes constantes;

    public HomeService(Constantes constantes) {
        this.constantes = constantes;
    }

    /**
     * Méthode qui permet de construire le header
     *
     * @return un header
     */
    private HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );
        return new HttpEntity<>( headers );
    }

    /**
     * Méthode qui permet de récupérer la liste des utilisateurs.
     *
     * @return Une liste d'utilisateurs
     */
    public UsersContent getAllUsers() {
        final UriComponents url = UriComponentsBuilder.newInstance()
                .scheme( constantes.getUrlScheme() )
                .host( constantes.getUrlHost() )
                .pathSegment( "user/allUsers" )
                .build();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UsersContent> response = restTemplate.exchange( url.toString(), GET, getHttpEntity(), UsersContent.class );
        return response.getBody();
    }
}
