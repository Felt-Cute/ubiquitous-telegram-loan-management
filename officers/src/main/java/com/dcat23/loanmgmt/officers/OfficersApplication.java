package com.dcat23.loanmgmt.officers;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Officers Application REST API Documentation",
                description = "Manages loan officers who handle loan applications and processing.",
                version = "v1",
                contact = @Contact(
                        name = "Devin Catuns",
                        email = "devincatuns1@gmail.com",
                        url = "https://github.com/dcat23"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Loan management Github",
                url = "https://github.com/Felt-Cute/ubiquitous-telegram-loan-management"
        ))
@SpringBootApplication
public class OfficersApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficersApplication.class, args);
    }

}
