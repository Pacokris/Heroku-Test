package com.example.helloworld.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class Constantes {

    @Value("${url.back.scheme:}")
    private String urlScheme;

    @Value("${url.back.host:}")
    private String urlHost;
}
