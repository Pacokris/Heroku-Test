package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.Properties;

@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) throws Exception {

        // set up new properties object
        // from file "myProperties.txt"
        FileInputStream propFile =
                new FileInputStream( "system.properties" );
        Properties p =
                new Properties( System.getProperties() );
        p.load( propFile );

        // set the system properties
        System.setProperties( p );
        // display new properties
        System.getProperties().list( System.out );
        SpringApplication.run( HelloworldApplication.class, args );
    }

}
