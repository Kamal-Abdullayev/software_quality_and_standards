package com.taltech.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setName("Demo Project");

        Info info = new Info()
                .title("Demo Project")
                .version("1.0")
                .contact(contact);

        return new OpenAPI().info(info);
    }

}
