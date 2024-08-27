package edu.spring_web_api.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Title - Rest API")
                        .description("API exemplo de uso de Springboot REST API")
                        .version("1.0")
                        .termsOfService("Termo de uso: Open Source")
                        .contact(new Contact()
                                .name("seu nome")
                                .url("http://www.seusite.com.br")
                                .email("vinhororozz@hotmail.com"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Licença - Sua Empresa")
                                .url("http://www.seusite.com.br")));
   }
}
