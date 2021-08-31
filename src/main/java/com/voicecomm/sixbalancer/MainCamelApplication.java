package com.voicecomm.sixbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:camel/main-camel-context.xml")
public class MainCamelApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MainCamelApplication.class, args);
    }

     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainCamelApplication.class);
    }
    
}
